package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class QuizMenuActivity extends AppCompatActivity {

    Button quiz1Btn, quiz2Btn, quiz3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);
        quiz1Btn = findViewById(R.id.idQuizBtn1);
        quiz2Btn = findViewById(R.id.idQuizBtn2);
        quiz3Btn = findViewById(R.id.idQuizBtn3);

        quiz1Btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.putExtra("QUIZ CHOICE",1);
            startActivity(intent);
        });

        quiz2Btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.putExtra("QUIZ CHOICE",2);
            startActivity(intent);
        });

        quiz3Btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            intent.putExtra("QUIZ CHOICE",3);
            startActivity(intent);
        });
    }
}