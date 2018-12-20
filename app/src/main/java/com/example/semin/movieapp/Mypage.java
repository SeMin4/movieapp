package com.example.semin.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Mypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        if(MainActivity.login_status == 1)
        {
            TextView user_id = (TextView)findViewById(R.id.user_id);
            user_id.setText(MainActivity.list.get(MainActivity.user_status).getId());
            TextView point = (TextView)findViewById(R.id.point);
            point.setText(MainActivity.list.get(MainActivity.user_status).getPoint());

            TextView textView = (TextView)findViewById(R.id.reservation);

        }

    }
}

