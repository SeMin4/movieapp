package com.example.semin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button loginBtn, signupBtn;
    EditText user_id_edit, user_pw_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn = (Button)findViewById(R.id.login_page_login);
        signupBtn = (Button)findViewById(R.id.login_page_sign_up);
        user_id_edit = (EditText)findViewById(R.id.login_page_id);
        user_pw_edit = (EditText)findViewById(R.id.login_page_pw);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                String user_id = user_id_edit.getText().toString();
                String user_pw = user_pw_edit.getText().toString();
                intent.putExtra("id",user_id);
                intent.putExtra("pw",user_pw);
                startActivity(intent);
            }
        });
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
    }
}
