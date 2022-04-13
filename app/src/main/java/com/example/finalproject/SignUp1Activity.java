package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp1Activity extends AppCompatActivity {

    EditText username, password, repassword;
    Button next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        repassword= (EditText) findViewById(R.id.repassword);
        next= (Button) findViewById(R.id.nextBtn1);
        back= (Button) findViewById(R.id.backBtn1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}