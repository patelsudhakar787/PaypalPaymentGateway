package com.rlard.rlard008.stbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startSplash();
    }


    void startSplash() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            doFinish();
                        }
                    });
                }
            }
        }).start();
    }

    void doFinish() {

        Intent splash = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(splash);
        finish();
    }
}
