package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressActivity extends AppCompatActivity {
    Button homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        homeBtn = findViewById(R.id.homeBtn2);

        homeBtn.setOnClickListener(view -> {
            Intent intent_main = new Intent(ProgressActivity.this, MainActivity.class);
            startActivity(intent_main);
        });
    }
}