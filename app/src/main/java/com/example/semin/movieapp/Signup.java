package com.example.semin.movieapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Signup extends AppCompatActivity {
    Button signupBtn;
    EditText signup_id_edit, signup_pw_edit, signup_email_edit, signup_pw_check_edit,signup_card_type_edit, signup_card_number_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        signupBtn = (Button) findViewById(R.id.sign_up_page_sign_btn);
        signup_id_edit = (EditText) findViewById(R.id.sign_up_page_id);
        signup_email_edit = (EditText) findViewById(R.id.sign_up_page_email);
        signup_pw_edit = (EditText) findViewById(R.id.sign_up_page_pw);
        signup_pw_check_edit = (EditText) findViewById(R.id.sign_up_page_pw_check);
        signup_card_type_edit = (EditText) findViewById(R.id.sign_up_page_card_type);
        signup_card_number_edit = (EditText) findViewById(R.id.sign_up_page_card_number);
        signup_pw_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        signup_pw_check_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        signup_email_edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signup_pw = signup_pw_edit.getText().toString();
                final String signup_pw_check = signup_pw_check_edit.getText().toString();
                if (signup_pw.equals(signup_pw_check)) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(getFilesDir() + "user.txt", true));
                        String result = "";
                        result += signup_id_edit.getText().toString();
                        result += ",";
                        result += signup_email_edit.getText().toString();
                        result += ",";
                        result += signup_pw_edit.getText().toString();
                        result += ",";
                        result+= signup_card_type_edit.getText().toString();
                        result += ",";
                        result += signup_card_number_edit.getText().toString();
                        result += ",";
                        result += "0";
                        bw.write(result);
                        bw.write("\n");
                        bw.close();
                        Toast.makeText(getApplicationContext(),"회원가입을 축하합니다~!",Toast.LENGTH_LONG).show();
                        finish();
                        // Toast.makeText(ChatLog.this, "저장완료", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        Toast.makeText(Signup.this, "File not found", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Signup.this);
                    builder.setTitle("패스워드 오류");
                    builder.setMessage("패스워드가 틀립니다.");
                    builder.setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    signup_pw_edit.setText("");
                                    signup_pw_check_edit.setText("");
                                }
                            });
                    builder.show();
                }
            }
        });

    }
}
