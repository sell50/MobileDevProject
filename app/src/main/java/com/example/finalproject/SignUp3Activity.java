package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp3Activity extends AppCompatActivity {

    EditText birthdate, gender;
    Button register, back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        birthdate= (EditText) findViewById(R.id.birthdate);
        gender= (EditText) findViewById(R.id.gender);
        register= (Button) findViewById(R.id.register);
        back= (Button) findViewById(R.id.backBtn3);
        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = getIntent().getStringExtra("uname");
                String pass = getIntent().getStringExtra("passw");
                String fn = getIntent().getStringExtra("fname");
                String ln = getIntent().getStringExtra("lname");
                String em = getIntent().getStringExtra("email");
                String dob = birthdate.getText().toString();
                String gndr = gender.getText().toString();

                if(TextUtils.isEmpty(dob))
                    Toast.makeText(SignUp3Activity.this, "Date of Birth Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(user, pass, fn, ln, em, dob, gndr);
                    if(insert==true){
                        Toast.makeText(SignUp3Activity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), QuizMenuActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUp3Activity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp2Activity.class);
                startActivity(intent);
            }
        });
    }
}