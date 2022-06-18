package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class full_screen_Activity extends AppCompatActivity {
    TextView get_text, dtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_);
        get_text = findViewById(R.id.full_text);
        dtext = findViewById(R.id.dText);


        get_text.setText(getIntent().getStringExtra("header_text"));
        dtext.setText(getIntent().getStringExtra("dtext"));
    }
}