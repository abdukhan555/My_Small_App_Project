package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Services_Activity extends AppCompatActivity  implements View.OnClickListener {
    Button buttonStart, buttonStop,buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_);

        buttonStart = findViewById(R.id.buttonStart);
        buttonStop = findViewById(R.id.buttonStop);
        buttonNext =  findViewById(R.id.buttonNext);

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonNext.setOnClickListener(this);


    }

    @Override
    public void onClick(View src) {
        switch (src.getId()) {
            case R.id.buttonStart:


                startService(new Intent(this, MyServices.class));

                break;
            case R.id.buttonStop:
                stopService(new Intent(this, MyServices.class));
                break;
            case R.id.buttonNext:
                Intent intent=new Intent(this,Next_pageServices.class);
                startActivity(intent);
                break;
        }
    }
}