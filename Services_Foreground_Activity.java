package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Services_Foreground_Activity extends AppCompatActivity {

    private EditText editTextInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services__foreground_);

        editTextInput = findViewById(R.id.edit_text_input);
    }

    public void startService(View view) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent = new Intent(this, MyServices_2.class);
        serviceIntent.putExtra("inputExtra", input);

        ContextCompat.startForegroundService(this, serviceIntent);
    }


    public void stopService(View view) {
        Intent serviceIntent = new Intent(this, MyServices_2.class);
        stopService(serviceIntent);
    }
}