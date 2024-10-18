package com.example.musicrecommendation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoooseMood extends AppCompatActivity {

    Button sad,happy,surprise,disgust,fear,angry,neutral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooose_mood);

        happy = findViewById(R.id.happy);
        sad = findViewById(R.id.sad);
        surprise = findViewById(R.id.surprised);
        disgust = findViewById(R.id.disgusted);
        fear = findViewById(R.id.fear);
        angry = findViewById(R.id.angry);
        neutral = findViewById(R.id.neutral);

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sadActivity();
            }
        });

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                happyActivity();
            }
        });

        surprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surpriseActivity();
            }
        });
        disgust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disgustActivity();
            }
        });
        fear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fearActivity();
            }
        });
        angry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angryActivity();
            }
        });
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                neutralActivity();
            }
        });

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
}