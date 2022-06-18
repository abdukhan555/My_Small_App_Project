package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_shared_pref_activity extends AppCompatActivity {
    EditText ed_first_name, ed_password;
    CheckBox checkBox;
    Button   btn_login;

    SharedPreferences sh; // to create fiel in sharedprefrences..
    SharedPreferences.Editor editor; // to add , view or delete data from shared prefrences...
    String name ="admin"; // user name
    String pass = "admin"; // password
    Boolean isLoggedIn; // for checking if the user is login



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_shared_pref_activity);
        ed_first_name = findViewById(R.id.first_name);
        ed_password = findViewById(R.id.password);
        checkBox = findViewById(R.id.checkbox);
        btn_login= findViewById(R.id.btn_login);
        TextView sign_up = findViewById(R.id.sign_up);

        sh = getSharedPreferences("DATA",MODE_PRIVATE); //

        editor = sh.edit();
        ed_first_name.setText(sh.getString("Name",""));
        ed_password.setText(sh.getString("password",""));
        isLoggedIn = sh.getBoolean("isLogin",false);
        if(isLoggedIn){
            startActivity(new Intent(Login_shared_pref_activity.this,MainActivity.class));
            finish();
        }




        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = ed_first_name.getText().toString();
                String password = ed_password.getText().toString();
                if(userName.equals(name)&& password.equals(pass)){
                    if(checkBox.isChecked())
                    {
                        editor.putString("Name",userName);
                        editor.putString("password",password);
                        editor.putBoolean("isLogin",true);
                        editor.apply();
                        Intent intent = new Intent(Login_shared_pref_activity.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Intent intent = new Intent(Login_shared_pref_activity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }
                else {
                    Toast.makeText(Login_shared_pref_activity.this,"Invalid user name and password",Toast.LENGTH_LONG).show();
                }

            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_shared_pref_activity.this,Sign_up_Activity.class));
            }
        });

    }
}