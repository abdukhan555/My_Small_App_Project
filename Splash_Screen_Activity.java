package com.delawar.app_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen_Activity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 2000;

    //variables
    Animation top_animation, bottom_animation;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);
        getSupportActionBar().hide();
       top_animation = AnimationUtils.loadAnimation(this,R.anim.top_animaiton);
       bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.textView);

      imageView.setAnimation(top_animation);
      textView.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen_Activity.this,Login_shared_pref_activity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_SCREEN);
    }
}