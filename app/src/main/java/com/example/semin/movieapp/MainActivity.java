package com.example.semin.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button mypageBtn, loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.earthquake_shelter);

        Scanner scanner = new Scanner(inputStream);
        ArrayList<EarthquakeShelter> list = new ArrayList<>();

        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            try {
                list.add(new EarthquakeShelter(data[2], Double.parseDouble(data[6]), Double.parseDouble(data[5])));
            }catch(NumberFormatException e){
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
        scanner.close();

        mypageBtn = (Button)findViewById(R.id.main_my_page);
        loginBtn =(Button)findViewById(R.id.main_login);
        mypageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Mypage.class);
                startActivity(intent);
            }
        });
        loginBtn = (Button)findViewById(R.id.main_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
