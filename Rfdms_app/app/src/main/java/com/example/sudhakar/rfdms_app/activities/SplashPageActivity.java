package com.example.sudhakar.rfdms_app.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sudhakar.rfdms_app.R;



public class SplashPageActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        textView=(TextView)findViewById(R.id.text);
        imageView=(ImageView)findViewById(R.id.image);


        textView.setText("Remote Data Feeder \nMonitoring System\n  (RFDMS)");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashPageActivity.this,LoginActivity.class);
                startActivity(intent);
        }
        },3000);
    }



}
