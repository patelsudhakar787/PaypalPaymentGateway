package com.example.rlard008.hr_app.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.rlard008.hr_app.Pojo.Network;
import com.example.rlard008.hr_app.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        startSplash();
    }

    void startSplash(){


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

        Network network = null;

        if (network.isNetworkConnected(this)) {

            SharedPreferences sharedPreferences = getSharedPreferences("isLog", MODE_PRIVATE);
            String stat = sharedPreferences.getString("islog", "");


            if (stat.equals("yes")) {  // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
                // and the GoogleSignInResult will be available instantly.

                //Toast.makeText(SplashActivity.this, "Already Logged in", Toast.LENGTH_LONG).show();
                Intent splash = new Intent(SplashActivity.this, DrawerActivity.class);
                startActivity(splash);
                finish();

            } else {

                Intent splash = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(splash);
                finish();
            }
        }
        else {

            Toast.makeText(SplashActivity.this,"No Internet Connection. Pls try again", Toast.LENGTH_LONG).show();
        }

    }

}
