package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Shared_preferences_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText first_name,last_name;
    TextView textView,disp_l_name;
    Button add,btn_view_data,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_);

        first_name = findViewById(R.id.edit_text);
        last_name = findViewById(R.id.last_name);

        add = findViewById(R.id.btn_add);
        btn_view_data = findViewById(R.id.btn_view_data);
        delete = findViewById(R.id.btn_delete);

        textView = findViewById(R.id.view_text);
        disp_l_name=findViewById(R.id.disp_l_name);

        add.setOnClickListener(this);
        btn_view_data.setOnClickListener(this);
        delete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                SharedPreferences sharedPreferences = getSharedPreferences("datafile",MODE_PRIVATE);
                SharedPreferences.Editor ed = sharedPreferences.edit();
                ed.putString("Name",first_name.getText().toString());
                ed.putString("lastname",last_name.getText().toString());
                ed.commit();
                first_name.setText("");
                last_name.setText("");
               Toast.makeText(this,"Data added ",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_view_data:
                SharedPreferences sharedPreferences1 = getSharedPreferences("datafile",MODE_PRIVATE);
                if(sharedPreferences1.contains("Name")){
                    textView.setText(sharedPreferences1.getString("Name",""));
                    disp_l_name.setText(sharedPreferences1.getString("lastname",""));
                }
                else {
                    Toast.makeText(this,"No data availabe",Toast.LENGTH_LONG).show();
                }
                 break;
            case R.id.btn_delete:
                SharedPreferences sharedPreferences2 = getSharedPreferences("datafile",MODE_PRIVATE);
                SharedPreferences.Editor delete_text = sharedPreferences2.edit();
                if(sharedPreferences2.contains("Name")){
                    delete_text.remove("Name");
                    delete_text.remove("lastname");
                    delete_text.commit();
                    textView.setText("");
                    disp_l_name.setText("");
                    Toast.makeText(this,"deleted ",Toast.LENGTH_LONG).show();
                }
                break;
        }

    }
}