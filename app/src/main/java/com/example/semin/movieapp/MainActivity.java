package com.example.semin.movieapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button mypageBtn, loginBtn;
    static int login_status = 0;
    public static ArrayList<Signup_Info> list = new ArrayList<>();
    public static int user_status ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mypageBtn = (Button)findViewById(R.id.main_my_page);
        loginBtn =(Button)findViewById(R.id.main_login);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_status==1) {
                    Intent intent = new Intent(MainActivity.this, Mypage.class);
                    startActivity(intent);
                }
                else if(login_status == 0)
                {
                    Toast.makeText(getApplicationContext(),"로그인 해주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginBtn = (Button)findViewById(R.id.main_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_status ==0) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                }
            }
        });

        try{
            BufferedReader buf = new BufferedReader(new FileReader( getFilesDir() +"user.txt"));
            String str= null;
            while((str = buf.readLine())!= null){
                String[] one_record = str.split(",");
                list.add(new Signup_Info(one_record[0],one_record[1],one_record[2],one_record[3],one_record[4],one_record[5]));
            }
            buf.close();
        }catch(FileNotFoundException e) {
            // Toast.makeText(ChatLog.this,"File not found",Toast.LENGTH_SHORT).show();

        }catch(IOException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(login_status == 1)
            loginBtn.setText("로그아웃");

    }

    public void onClickButton(View v)
    {
        int id = v.getId();

        switch(id)
        {
            case R.id.bohamin:
                AlertDialog.Builder dig = new AlertDialog.Builder(this);
                dig.setTitle("영화제목 : 보헤미안 랩소디");
                dig.setMessage("장르 : 드라마\n연령 : 12세 이상\n실행 시간 : 134분\n개봉 : 2018.10.31");
                dig.setPositiveButton("예약하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
            case R.id.poison:
                AlertDialog.Builder dig2 = new AlertDialog.Builder(this);
                dig2.setTitle("영화제목 : 마약왕");
                dig2.setMessage("장르 : 범죄,드라마\n연령 : 청소년 관람불가\n실행 시간 : 139분\n개봉 : 2018.12.19");
                dig2.setPositiveButton("예약하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;

            case R.id.aqua:
                AlertDialog.Builder dig3 = new AlertDialog.Builder(this);
                dig3.setTitle("영화제목 : 아쿠아맨");
                dig3.setMessage("장르 : 액션\n연령 : 12세 이상\n실행 시간 : 143분\n개봉 : 2018.12.19");
                dig3.setPositiveButton("예약하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;

            case R.id.swing:
                AlertDialog.Builder dig4 = new AlertDialog.Builder(this);
                dig4.setTitle("영화제목 : 스윙키즈");
                dig4.setMessage("장르 : 드라마\n연령 : 12세 이상\n실행 시간 : 133분\n개봉 : 2018.12.19");
                dig4.setPositiveButton("예약하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
        }
    }
}
