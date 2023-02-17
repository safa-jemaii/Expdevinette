package com.isetR.devinette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class recyclerv extends AppCompatActivity {
    MyDatabaseHelper Mydb;
    public RecyclerView rv;

    ArrayList<String> player_id,devinette_title,score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_recyclerv);
        CustomAdapter CustomAdapter;
        rv = (RecyclerView) findViewById(R.id.rv);



        Mydb = new MyDatabaseHelper(recyclerv.this);
        devinette_title = new ArrayList<>();
        score = new ArrayList<>();
        player_id = new ArrayList<>();
        storeDataInArrays();
        CustomAdapter = new CustomAdapter(recyclerv.this,player_id,devinette_title, score);
        rv.setAdapter(CustomAdapter);
        rv.setLayoutManager(new LinearLayoutManager(recyclerv.this));
    }
    void storeDataInArrays(){
        Cursor cursor = Mydb.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){

                devinette_title.add(cursor.getString(1));
                score.add(cursor.getString(2));

            }

        }
    }
}