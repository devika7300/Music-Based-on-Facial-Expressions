package com.example.musicrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {

    ImageView logo1;
    Button capture;
    Button choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        logo1 = findViewById(R.id.logo2);
        capture = findViewById(R.id.capture);
        choose = findViewById(R.id.choose);

        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }
        });
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity1();
            }
        });
    }

    private void openactivity2() {
        Intent intent = new Intent(this,CaptureImage.class);
        startActivity(intent);
    }

    private void openactivity1() {
        Intent intent = new Intent(this,ChoooseMood.class);
        startActivity(intent);
    }


}