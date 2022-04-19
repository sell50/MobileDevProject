package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText username, password, repassword, firstname, lastname, email, emailvrf, birthdate, gender;
    Button register, back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username= (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        repassword= (EditText) findViewById(R.id.repassword);
        firstname= (EditText) findViewById(R.id.firstname);
        lastname= (EditText) findViewById(R.id.lastname);
        email= (EditText) findViewById(R.id.emailaddr);
        emailvrf= (EditText) findViewById(R.id.emailvrf);
        birthdate= (EditText) findViewById(R.id.birthdate);
        gender= (EditText) findViewById(R.id.gender);

        register= (Button) findViewById(R.id.register);
        back= (Button) findViewById(R.id.backBtn);
        DB= new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get user input from fields
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                String fn = firstname.getText().toString();
                String ln = lastname.getText().toString();
                String em = email.getText().toString();
                String em2 = emailvrf.getText().toString();
                String dob = birthdate.getText().toString();
                String gndr = gender.getText().toString();

                // check that fields are not empty and validate before inserting into database
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) || TextUtils.isEmpty(fn) || TextUtils.isEmpty(ln) || TextUtils.isEmpty(em) || TextUtils.isEmpty(em2) || TextUtils.isEmpty(dob)) {
                    Toast.makeText(SignUpActivity.this, "All fields but gender required", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pass.equals(repass)) {
                        // check if username is taken
                        Boolean userTaken = DB.checkUsername(user);
                        if(!userTaken){
                            // check that email address is confirmed
                            if (em.equals(em2)) {
                                // if it is, insert user info into database
                                Boolean insert = DB.insertData(user, pass, fn, ln, em, dob, gndr);
                                if(insert==true){
                                    // display registration success message
                                    Toast.makeText(SignUpActivity.this, "Registered successful", Toast.LENGTH_SHORT).show();

                                    // pass user session and go to quiz menu
                                    Intent intent = new Intent(SignUpActivity.this, QuizMenuActivity.class);
                                    intent.putExtra("USER", user);
                                    intent.putExtra("FNAME", fn);
                                    startActivity(intent);
                                } else Toast.makeText(SignUpActivity.this,"Registration unsuccessful", Toast.LENGTH_SHORT).show();
                            } else Toast.makeText(SignUpActivity.this, "Email addresses don't match", Toast.LENGTH_SHORT).show();
                        } else Toast.makeText(SignUpActivity.this,"Username is unavailable", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(SignUpActivity.this,"Passwords don't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}