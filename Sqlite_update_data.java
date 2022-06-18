package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Adapters.DbAdafter;
import Database.DataBaseHelper;
import Modal.Records;

public class Sqlite_update_data extends AppCompatActivity {
    EditText edName, edCourse, edMobile, edTotal, edFeepaid;
    Button btn_update;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_update_data);

        Records r = (Records) getIntent().getExtras().getSerializable("RECORD");
        id = r.getId();
        edName = findViewById(R.id.user_name);
        edCourse = findViewById(R.id.course_name);
        edMobile = findViewById(R.id.mobile_no);
        edTotal = findViewById(R.id.total_fee);
        edFeepaid = findViewById(R.id.fee_paid);
        btn_update = findViewById(R.id.update_data);




        edName.setText(r.getName());
        edCourse.setText(r.getCourse());
        edMobile.setText(r.getMobile());
        edTotal.setText(String.valueOf(r.getTotalfee()));
        edFeepaid.setText(String.valueOf(r.getFee_paid()));

     btn_update.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String username = edName.getText().toString().trim();
             String course = edCourse.getText().toString().trim();
             String mobile = edMobile.getText().toString().trim();
             String total = edTotal.getText().toString().trim();
             String feepaid = edFeepaid.getText().toString().trim();

             Records records = new Records(id,username,course,mobile,Integer.parseInt(total),Integer.parseInt(feepaid));
           //  System.out.println("the id is " +id);

             DataBaseHelper dataBaseHelper = new DataBaseHelper(getApplicationContext());
             int result = dataBaseHelper.updateStudents(records);


             if(result > 0){
                 Toast.makeText(Sqlite_update_data.this, "Data updated "+ result, Toast.LENGTH_SHORT).show();
                 finish();
             }
             else{
                 Toast.makeText(Sqlite_update_data.this, "updation   failed" + result, Toast.LENGTH_SHORT).show();
             }


         }
     });

    }
}