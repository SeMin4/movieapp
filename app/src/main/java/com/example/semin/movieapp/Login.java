package com.example.semin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        user_pw_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                String user_id = user_id_edit.getText().toString();
                String user_pw = user_pw_edit.getText().toString();
                //intent.putExtra("id",user_id);
                //intent.putExtra("pw",user_pw);
                int k =0;
                for(int i =0 ; i<MainActivity.list.size();i++) {
                    Signup_Info info = MainActivity.list.get(i);
                    if(user_id.equals(info.getId()) && user_pw.equals(info.getPassword())) {
                        MainActivity.login_status=1;
                        Toast.makeText(getApplicationContext(),info.getId()+ "님 "+"환영합니다~!!",Toast.LENGTH_SHORT).show();
                        MainActivity.user_status = i;
                        startActivity(intent);
                        break;
                    }
                    k++;
                }
                if(k == MainActivity.list.size())
                    Toast.makeText(getApplicationContext(),"아이디와 비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
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
