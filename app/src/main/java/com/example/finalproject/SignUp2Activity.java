package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp2Activity extends AppCompatActivity {

    EditText firstname, lastname, email, emailvrf;
    Button next, back;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        firstname= (EditText) findViewById(R.id.firstname);
        lastname= (EditText) findViewById(R.id.lastname);
        email= (EditText) findViewById(R.id.emailaddr);
        emailvrf= (EditText) findViewById(R.id.emailvrf);
        next= (Button) findViewById(R.id.nextBtn2);
        back= (Button) findViewById(R.id.backBtn2);
        DB= new DBHelper(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = getIntent().getStringExtra("username");
                String pass = getIntent().getStringExtra("password");
                String fn = firstname.getText().toString();
                String ln = lastname.getText().toString();
                String em = email.getText().toString();
                String em2 = emailvrf.getText().toString();
                Toast.makeText(SignUp2Activity.this, user+" "+pass+" "+fn+" "+ln+" "+em+" "+em2,Toast.LENGTH_LONG).show();

                if(TextUtils.isEmpty(fn) || TextUtils.isEmpty(ln) || TextUtils.isEmpty(em) || TextUtils.isEmpty(em2))
                    Toast.makeText(SignUp2Activity.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    if(em.equals(em2)) {
                        Intent intent = new Intent(getApplicationContext(), SignUp3Activity.class);
                        intent.putExtra("uname", user);
                        intent.putExtra("passw", pass);
                        intent.putExtra("fname", fn);
                        intent.putExtra("lname", ln);
                        intent.putExtra("email", em);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUp2Activity.this,"Email addresses don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}