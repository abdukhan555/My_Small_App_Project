package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import Adapters.DbAdafter;
import Database.DataBaseHelper;
import Modal.Records;

public class Sqlite_viewdata_list extends AppCompatActivity {

    ArrayList<Records> records;
    RecyclerView recyclerView;
    DbAdafter dbAdafter;
    DataBaseHelper dataBaseHelper;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_viewdata_list);
        textView = findViewById(R.id.total_records);
        recyclerView = findViewById(R.id.rec_view);

        dataBaseHelper = new DataBaseHelper(this);
       /* records = dataBaseHelper.getAllRecords();
        textView.setText("Total Records:"+ records.size());


        dbAdafter = new DbAdafter(records,this);
        recyclerView.setAdapter(dbAdafter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);*/



    }

    @Override
    protected void onStart() {
        super.onStart();
        records = dataBaseHelper.getAllRecords();
        textView.setText("Total Records:"+ records.size());


        dbAdafter = new DbAdafter(records,this);
        recyclerView.setAdapter(dbAdafter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(llm);
    }
}