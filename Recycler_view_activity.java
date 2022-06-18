package com.delawar.app_intents;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import Adapters.R_adapter;
import Adapters.myAdapter;

public class Recycler_view_activity extends AppCompatActivity {
    RecyclerView rcv;
    String arr[]={"C","C++","JAVA","PHP",".NEt","JQuery","C","C++","JAVA","PHP",".NEt","JQuery","C","C++","JAVA","PHP",".NEt","JQuery"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_activity);
       // rcv = (RecyclerView)findViewById(R.id.recycle_view);
        rcv = findViewById(R.id.rclview);

        myAdapter adapter = new myAdapter(arr);
        rcv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcv.setLayoutManager(linearLayoutManager);

       // rcv.setLayoutManager(new LinearLayoutManager(this));


        //rcv.setAdapter(new myAdapter(arr));



    }
}