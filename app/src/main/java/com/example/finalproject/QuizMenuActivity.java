package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizMenuActivity extends AppCompatActivity {

    private Button quiz1Btn, quiz2Btn, quiz3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        quiz1Btn = findViewById(R.id.idQuizBtn1);
        quiz2Btn = findViewById(R.id.idQuizBtn2);
        quiz3Btn = findViewById(R.id.idQuizBtn3);

        quiz1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("QUIZ CHOICE",1);
                startActivity(intent);
            }
        });

        quiz2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("QUIZ CHOICE",2);
                startActivity(intent);
            }

        });

        quiz3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("QUIZ CHOICE",3);
                startActivity(intent);
            }
        });
    }
}