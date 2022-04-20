package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button signin;
    QuizzardDB DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        signin=findViewById(R.id.signin1);
        DB=new QuizzardDB(this);

        signin.setOnClickListener(view -> {
            String user=username.getText().toString();
            String pass=password.getText().toString();

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                Toast.makeText(LoginActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
            else{
                Boolean userValid = DB.validateUser(user, pass);
                if(userValid){
                    String fname = DB.getFirstName(user);
                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), QuizMenuActivity.class);
                    //
                    intent.putExtra("FNAME", fname);
                    intent.putExtra("USER", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}