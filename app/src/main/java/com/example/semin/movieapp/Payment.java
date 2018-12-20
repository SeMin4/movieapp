package com.example.semin.movieapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Payment extends AppCompatActivity {

    Button buybutton;
    Button backbutton;
    TextView seat;
    ArrayList<String> list;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView cardcomp = (TextView)findViewById(R.id.cardcomp);
        TextView cardnum = (TextView)findViewById(R.id.cardnum);
        Signup_Info info = MainActivity.list.get(MainActivity.user_status);

        cardcomp.setText(info.getCard_type());
        cardnum.setText(info.getCard_number());

        String seatstr="";
        Intent intent =getIntent();
        seat = (TextView)findViewById(R.id.seat);
        buybutton = (Button)findViewById(R.id.buybutton);
        list = (ArrayList<String>)intent.getSerializableExtra("names");

        for(int i = 0;i<list.size();i++)
        {
            seatstr += list.get(i)+" ";
        }

        seat.setText(seatstr);
    }

    public void onClickButton(View v)
    {
                AlertDialog.Builder dig = new AlertDialog.Builder(Payment.this);
                dig.setTitle("영화앱이름");
                dig.setMessage("결제 되었습니다.\n즐거운 영화관람 되십시오!");
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dig.show();
    }
}
