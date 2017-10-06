package com.example.rahuls.hideappdemo;

import android.app.Activity;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityNew extends Activity {

    Button hideButton,unHideButton;
    TextView demotext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

        Intent i = getIntent();
        String data = i.getStringExtra("key");
        if(data != null)
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

    }
}
