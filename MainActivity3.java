package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    ImageView full_image;
    TextView pic_name, description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        full_image = findViewById(R.id.full_screen);
        pic_name = findViewById(R.id.pic_name);
        description = findViewById(R.id.description);


        Intent intent = getIntent();
        int position = intent.getExtras().getInt("id");
        Adapter_Grid adapter_grid = new Adapter_Grid(this);
        full_image.setImageResource(adapter_grid.images[position]);
        pic_name.setText(adapter_grid.names[position]);
        description.setText(adapter_grid.description[position]);



    }
}