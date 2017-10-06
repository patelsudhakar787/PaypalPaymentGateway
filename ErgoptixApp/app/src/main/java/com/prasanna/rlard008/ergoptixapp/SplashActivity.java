package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.prasanna.rlard008.ergoptixapp.Pojo.Network;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FacebookSdk.sdkInitialize(getApplicationContext());

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

        Network network=null;

        if (network.isNwConnected(this)) {

            SharedPreferences sharedPreferences = getSharedPreferences("isLog", MODE_PRIVATE);
            String stat = sharedPreferences.getString("islog", "");


            if (AccessToken.getCurrentAccessToken() != null || stat.equals("yes")) {  // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
                // and the GoogleSignInResult will be available instantly.

                Intent splash = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(splash);
                finish();

            } else {

                Intent splash = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(splash);
                finish();

            }
        }
        else {

            Toast.makeText(SplashActivity.this,"No Internet Connection.Pls try again", Toast.LENGTH_LONG).show();
        }
    }
}
