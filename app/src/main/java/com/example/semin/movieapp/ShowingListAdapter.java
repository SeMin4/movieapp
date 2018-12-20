package com.example.semin.movieapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShowingListAdapter extends BaseAdapter {
   private LayoutInflater inflater;
   private ArrayList<Showing> data;
   private int layout;

    public ShowingListAdapter(Context context, int layout, ArrayList<Showing> data){
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data =data;
        this.layout = layout;
    }
    @Override
    public int getCount(){
        return data.size();
    }
    @Override
    public String getItem(int position){
        return null;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    public Showing getChat(int position){
        return data.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        Showing listviewitem=data.get(position);
        TextView Theatername=(TextView)convertView.findViewById(R.id.showing_theater_id);
        TextView Boxofficename=(TextView)convertView.findViewById(R.id.showing_box_office);
        Theatername.setText(listviewitem.getTheaterName());
        Boxofficename.setText(listviewitem.getTheater_Box_office());

        try{
            if(listviewitem.time.get(0).equals("")){

            }else{
                Button btn1=(Button)convertView.findViewById(R.id.btn1);
                btn1.setText(listviewitem.time.get(0));
            }
            if(listviewitem.time.get(1).equals("")){

            }else{
                Button btn2=(Button)convertView.findViewById(R.id.btn2);
                btn2.setText(listviewitem.time.get(1));
            }
            if(listviewitem.time.get(2).equals("")){

            }else{
                Button btn3=(Button)convertView.findViewById(R.id.btn3);
                btn3.setText(listviewitem.time.get(2));
            }
            if(listviewitem.time.get(3).equals("")){

            }else{
                Button btn4=(Button)convertView.findViewById(R.id.btn4);
                btn4.setText(listviewitem.time.get(3));
            }


            if(listviewitem.time.get(4).equals("")){

            }else {


                Button btn5 = (Button) convertView.findViewById(R.id.btn5);
                btn5.setText(listviewitem.time.get(4));
            }
            if(listviewitem.time.get(5).equals("")){

            }else {

                Button btn6 = (Button) convertView.findViewById(R.id.btn6);
                btn6.setText(listviewitem.time.get(5));
            }
            if(listviewitem.time.get(6).equals("")){

            }else {

                Button btn7 = (Button) convertView.findViewById(R.id.btn7);
                btn7.setText(listviewitem.time.get(6));
            }

            if(listviewitem.time.get(7).equals("")){

            }else{
                Button btn8=(Button)convertView.findViewById(R.id.btn8);
                btn8.setText(listviewitem.time.get(7));
            }

        }catch(IndexOutOfBoundsException e ){

        }



        return convertView;
    }
}
