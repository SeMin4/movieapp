package com.example.semin.movieapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SeatActivity extends AppCompatActivity {
    Button button;
    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        list = new ArrayList<String>();
        Button bt = (Button)findViewById(R.id.reservation);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),Payment.class);
               intent.putExtra("names",list);
               startActivity(intent);
            }
        });

    }

    public void onClickButton(View v) {
        button = (Button) findViewById(v.getId());
        ColorDrawable color = (ColorDrawable)button.getBackground();
        int btcolor = color.getColor();
        if(btcolor != Color.RED)
        {
            String str= button.getText().toString();
            button.setBackgroundColor(Color.RED);
            list.add(str);
        }
        else
        {
            String str = button.getText().toString();
            button.setBackgroundColor(Color.parseColor("#FF1FAFB2"));
            for(int i =0; i<list.size();i++)
            {
                String str2 = list.get(i);
                if(str2.equals(str) == true) {
                    list.remove(i);
                    break;
                }
            }
        }
    }
}
