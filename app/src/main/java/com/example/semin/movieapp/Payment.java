package com.example.semin.movieapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {

    Button buybutton;
    Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        buybutton = (Button)findViewById(R.id.buybutton);
        /*buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialog dig = new AlertDialog.Builder(Payment.this);
               dig.setTitle("영화앱이름");
               dig.setMessage("결제 되었습니다.\n즐거운 영화관람 되십시오!");
               dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                    finish();
                            }
                        });
               dig.show();

            }
        });*/
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
