package com.example.musicrecommendation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import com.example.musicrecommendation.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CaptureImage extends AppCompatActivity {

    Button camera;
    TextView result;
    ImageView img;
    int isize = 48;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);

        camera = findViewById(R.id.camera);
        result = findViewById(R.id.result);
        img = findViewById(R.id.face);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askCameraPermission();
            }
        });
    }

    private void askCameraPermission() {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 3);

        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
        }
    }

    public void classifyImage(Bitmap image){
        try {
            Model model = Model.newInstance(getApplicationContext());

            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 48, 48, 1}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4*isize * isize);
            byteBuffer.order(ByteOrder.nativeOrder());
            Log.d("shape", byteBuffer.toString());
            Log.d("shape", inputFeature0.getBuffer().toString());
            int[] intValues = new int[isize * isize];
            image.getPixels(intValues, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
            int pixel = 0;
            //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
           for(int i = 0; i < isize; i ++){
                for(int j = 0; j < isize; j++){

                    int val = intValues[pixel++]; // RGB
                    int r = (val >> 16) & 0xFF;
                    int g = (val >> 8) & 0xFF;
                    int b = (val & 0xFF);
                    float grey = ((r+g+b)/3.f/255.f);
                   byteBuffer.putFloat(grey);

                    //byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 255.f));
                    //byteBuffer.putFloat((val & 0xFF) * (1.f / 255.f));
                }
            }

            inputFeature0.loadBuffer(byteBuffer);

            // Runs model inference and gets result.
            Model.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

            float[] confidences = outputFeature0.getFloatArray();
            // find the index of the class with the biggest confidence.
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            String[] classes = {"Angry", "Disgust", "Fear", "Happy", "Neutral", "Sad", "Surprised"};
           // result.setText(classes[maxPos]);
            mood = classes[maxPos];

            switch (mood) {
                case "Angry":
                    angryActivity();
                    break;
                case "Disgust":
                    disgustActivity();
                    break;
                case "Fear":
                    fearActivity();
                    break;
                case "Happy":
                    happyActivity();
                    break;
                case "Neutral":
                    neutralActivity();
                    break;
                case "Sad":
                    sadActivity();
                    break;
                case "Surprised":
                    surpriseActivity();
                    break;
                default:
                    result.setText("Not able to detect emotion");
            }
            // Releases model resources if no longer used.
            model.close();
        } catch ( IOException e) {
            // TODO Handle the exception
        }
    }

    private void neutralActivity() {
        Intent intent = new Intent(this, NeutralMood.class);
        startActivity(intent);
    }

    private void angryActivity() {
        Intent intent = new Intent(this, AngryMood.class);
        startActivity(intent);
    }

    private void fearActivity() {
        Intent intent = new Intent(this, FearMood.class);
        startActivity(intent);
    }

    private void disgustActivity() {
        Intent intent = new Intent(this, DisgustMood.class);
        startActivity(intent);
    }

    private void surpriseActivity() {
        Intent intent = new Intent(this, SurpriseMood.class);
        startActivity(intent);
    }

    private void happyActivity() {
        Intent intent = new Intent(this, HappyMood.class);
        startActivity(intent);
    }

    private void sadActivity() {
        Intent intent = new Intent(this, SadMood.class);
        startActivity(intent);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       // if(resultCode == RESULT_OK){
            if(requestCode==3){
                assert data != null;
                Bitmap image = (Bitmap) data.getExtras().get("data");
                int dimension = Math.min(image.getWidth(), image.getHeight());
                image = ThumbnailUtils.extractThumbnail(image, dimension, dimension);
                img.setImageBitmap(image);

               image = Bitmap.createScaledBitmap(image, isize, isize, false);
                classifyImage(image);
            }
       // }
        super.onActivityResult(requestCode, resultCode, data);
    }


}