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

    EditText user, pass, passvrf, firstname, lastname, email, emailvrf, birthdate, gender;
    Button register, back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        user= findViewById(R.id.username);
        pass= findViewById(R.id.password);
        passvrf= findViewById(R.id.repassword);
        firstname= findViewById(R.id.firstname);
        lastname= findViewById(R.id.lastname);
        email= findViewById(R.id.emailaddr);
        emailvrf= findViewById(R.id.emailvrf);
        birthdate= findViewById(R.id.birthdate);
        gender= findViewById(R.id.gender);

        register= findViewById(R.id.register);
        back= findViewById(R.id.backBtn);
        DB= new DBHelper(this);

        register.setOnClickListener(view -> {
            // get user input from fields
            String un = user.getText().toString();
            String pw = pass.getText().toString();
            String pw2 = passvrf.getText().toString();
            String fn = firstname.getText().toString();
            String ln = lastname.getText().toString();
            String em = email.getText().toString();
            String em2 = emailvrf.getText().toString();
            String dob = birthdate.getText().toString();
            String gndr = gender.getText().toString();

            // check that fields are not empty and validate before inserting into database
            if(TextUtils.isEmpty(un) || TextUtils.isEmpty(pw) || TextUtils.isEmpty(pw2) || TextUtils.isEmpty(fn) || TextUtils.isEmpty(ln) || TextUtils.isEmpty(em) || TextUtils.isEmpty(em2) || TextUtils.isEmpty(dob)) {
                Toast.makeText(SignUpActivity.this, "All fields but gender required", Toast.LENGTH_SHORT).show();
            }
            else {
                if(pass.equals(pw2)) {
                    // check if user is taken
                    Boolean userTaken = DB.checkUsername(un);
                    if(!userTaken){
                        // check that email address is confirmed
                        if (em.equals(em2)) {
                            // if it is, insert user info into database
                            Boolean insert = DB.insertData(un, pw, fn, ln, em, dob, gndr);
                            if(insert==true){
                                // display registration success message
                                Toast.makeText(SignUpActivity.this, "Registered successful", Toast.LENGTH_SHORT).show();

                                // pass user session and go to quiz menu
                                Intent intent = new Intent(SignUpActivity.this, QuizMenuActivity.class);
                                //
                                intent.putExtra("USER", un);
                                intent.putExtra("FNAME", fn);
                                startActivity(intent);
                            } else Toast.makeText(SignUpActivity.this,"Registration unsuccessful", Toast.LENGTH_SHORT).show();
                        } else Toast.makeText(SignUpActivity.this, "Email addresses don't match", Toast.LENGTH_SHORT).show();
                    } else Toast.makeText(SignUpActivity.this,"Username is unavailable", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(SignUpActivity.this,"Passwords don't match", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}