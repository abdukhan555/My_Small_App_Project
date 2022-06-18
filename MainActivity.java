package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button implicit_intent, gird_button, card_view,
            RecycleView,service_btn , fground_services,btn_sqlite,
            web_view_btn;
    // to get data
    SharedPreferences sh;
    SharedPreferences.Editor editor;


    TextView username, logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        implicit_intent = findViewById(R.id.im_intent_btn);
        gird_button = findViewById(R.id.gird_btn);
        card_view = findViewById(R.id.btn_card_view);
        RecycleView = findViewById(R.id.recycle_view);
        service_btn = findViewById(R.id.btn_service);
        fground_services = findViewById(R.id.shared_pref);
        btn_sqlite = findViewById(R.id.sqlite);
        web_view_btn = findViewById(R.id.webview);

        username = findViewById(R.id.username);
        logout = findViewById(R.id.logout);


        sh = getSharedPreferences("DATA",MODE_PRIVATE);
        editor = sh.edit();
        username.setText(sh.getString("Name",""));

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.apply();

                startActivity(new Intent(MainActivity.this,Login_shared_pref_activity.class));
                finish();
            }
        });





        implicit_intent.setOnClickListener(this);
        gird_button.setOnClickListener(this);
        card_view.setOnClickListener(this);
        RecycleView.setOnClickListener(this);
        service_btn.setOnClickListener(this);
        fground_services.setOnClickListener(this);
        btn_sqlite.setOnClickListener(this);
        web_view_btn.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gird_btn:
                Intent intent = new Intent(MainActivity.this,GridActivity.class);
                startActivity(intent);
                break;
            case  R.id.im_intent_btn:
                Intent im_intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(im_intent);
                break;
            case R.id.btn_card_view:
                startActivity(new Intent(MainActivity.this,Card_view_Activity.class) );
                break;
            case R.id.recycle_view:
                startActivity(new Intent(MainActivity.this,Recycler_view_activity2.class));
                break;
            case R.id.btn_service:
                startActivity(new Intent(MainActivity.this,Services_Activity.class));
                break;
            case R.id.shared_pref:
                startActivity(new Intent(MainActivity.this,Shared_preferences_Activity.class));
                break;
            case R.id.sqlite:
                startActivity(new Intent(MainActivity.this,Sqlite_add_data.class));
                break;
            case R.id.webview:
                startActivity(new Intent(MainActivity.this,web_viewActivity.class));
                break;

        }
    }
}

/*textView = findViewById(R.id.first_activity);
        editText = findViewById(R.id.data);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });*/