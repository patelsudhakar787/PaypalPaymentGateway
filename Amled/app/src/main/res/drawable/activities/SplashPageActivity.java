package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.sudhakar.amled.R;

public class SplashPageActivity extends AppCompatActivity {


    private ImageView imageViewsplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
        imageViewsplash=(ImageView)findViewById(R.id.imageViewSplash);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(com.example.sudhakar.amled.activities.SplashPageActivity.this, com.example.sudhakar.amled.activities.WelComePageActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}
