package com.example.semin.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Moive_list extends AppCompatActivity {
    ShowingListAdapter showingListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_list);
        final ListView listView = (ListView)findViewById(R.id.movie_list);
        ArrayList<Showing> list = new ArrayList<>();
        int i = 0;
        InputStream inputStream = getResources().openRawResource(R.raw.cgv);
        Scanner scanner = new Scanner(inputStream);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            try {
                list.add(new Showing("cgv대구",data[0],data[1],data[2]));
                for(int j = 3;;j++){
                    if(data[j].isEmpty() == true){
                        break;
                    }
                    list.get(i).time.add(data[j]);
                }
            }catch(NumberFormatException e){
                i++;
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                i++;
                continue;
            }
            i++;
        }
        scanner.close();

        InputStream inputStream2 = getResources().openRawResource(R.raw.lotte);
        scanner = new Scanner(inputStream2);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            try {
                list.add(new Showing("Lotte시네마 동성로점",data[0],data[1],data[2]));
                for(int j = 3;;j++){
                    if(data[j].isEmpty() == true){
                        break;
                    }
                    list.get(i).time.add(data[j]);
                }
            }catch(NumberFormatException e){
                i++;
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                i++;
                continue;
            }
            i++;
        }
        scanner.close();

        InputStream inputStream3 = getResources().openRawResource(R.raw.mega);
        scanner = new Scanner(inputStream3);
        scanner.nextLine();
        while(scanner.hasNextLine()){
            String[] data = scanner.nextLine().split(",");
            try {
                list.add(new Showing("메가박스 칠성점",data[0],data[1],data[2]));
                for(int j = 3;;j++){
                    if(data[j].isEmpty() == true){
                        break;
                    }
                    list.get(i).time.add(data[j]);
                }
            }catch(NumberFormatException e){
                i++;
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                i++;
                continue;
            }
            i++;
        }
        scanner.close();
        showingListAdapter = new ShowingListAdapter(Moive_list.this,R.layout.showingitm,list);
        listView.setAdapter(showingListAdapter);

    }
}
