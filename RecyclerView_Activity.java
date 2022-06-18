package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Adapters.R_adapter;
import Modal.Modal_recycle;

public class RecyclerView_Activity extends AppCompatActivity {
    RecyclerView recyclerView;

    // we need 3 types of work

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_);
        recyclerView = findViewById(R.id.recycle_view);
        ArrayList <Modal_recycle> list = new ArrayList<>();
        list.add(new Modal_recycle(R.drawable.pic_1,"image1"));
        list.add(new Modal_recycle(R.drawable.pic_5,"image2"));
        list.add(new Modal_recycle(R.drawable.pic_3,"image3"));
        list.add(new Modal_recycle(R.drawable.pic_4,"image4"));
        list.add(new Modal_recycle(R.drawable.pic_3,"image5"));
        list.add(new Modal_recycle(R.drawable.pic_2,"image6"));
        list.add(new Modal_recycle(R.drawable.pic_12,"image7"));
        list.add(new Modal_recycle(R.drawable.pic_11,"image8"));

        R_adapter adapter = new R_adapter(list,this);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(linearLayoutManager);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager((gridLayoutManager));
    }
}