package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DataBaseHelper;
import Modal.Records;

public class Sqlite_add_data extends AppCompatActivity  {
    EditText edName, edCourse, edMobile, edTotal, edFeepaid;
    Button save_btn, show_record_btn;

    boolean isAllFieldsChecked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_add_data);
        edName = findViewById(R.id.user_name);
        edCourse = findViewById(R.id.course_name);
        edMobile = findViewById(R.id.mobile_no);
        edTotal = findViewById(R.id.total_fee);
        edFeepaid = findViewById(R.id.fee_paid);

        save_btn = findViewById(R.id.save_data);
        show_record_btn = findViewById(R.id.show_records);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // check validation
                isAllFieldsChecked = CheckAllFields();
                if(isAllFieldsChecked) {
                    // get data from edittext
                    String username = edName.getText().toString().trim();
                    String course = edCourse.getText().toString().trim();
                    String mobile = edMobile.getText().toString().trim();
                    String total = edTotal.getText().toString().trim();
                    String feepaid = edFeepaid.getText().toString().trim();

                    DataBaseHelper dataBaseHelper = new DataBaseHelper(Sqlite_add_data.this);

                    Records records = new Records(username, course, mobile, Integer.parseInt(total), Integer.parseInt(feepaid));

                    long result = dataBaseHelper.addRecord(records);

                    if (result > 0) {


                        Toast.makeText(Sqlite_add_data.this, "Data inserted " + result, Toast.LENGTH_SHORT).show();
                        edName.setText("");
                        edCourse.setText("");
                        edMobile.setText("");
                        edTotal.setText("");
                        edFeepaid.setText("");
                    } else {
                        Toast.makeText(Sqlite_add_data.this, "insertion failed" + result, Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

        show_record_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sqlite_add_data.this,Sqlite_viewdata_list.class));
            }

        });
    }


        private  boolean CheckAllFields(){
            if(edName.length() == 0){
                edName.setError("This field is required");
                return false;
            }
            if(edCourse.length() == 0){
                edCourse.setError("This Field is required");
                return false;
            }
            if (edMobile.length() < 11 ){
                edMobile.setError("Mobile Number must contain Atleast 11 digits");
                return false;
            }
            if(edTotal.length()== 0 ){
                edTotal.setError("reuired");
                return false;
            }
            if(edFeepaid.length()== 0){
                edFeepaid.setError("required");
                return false;
            }

            return true;

    }


}