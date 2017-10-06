package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MicroscopeRequestActivity extends AppCompatActivity {


    Button buttonModelA,buttonModelB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microscope_request);

        buttonModelA = (Button) findViewById(R.id.modelA);
        buttonModelB = (Button) findViewById(R.id.modelB);

        buttonModelA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MicroscopeRequestActivity.this,ModelA_Accessories.class);
                startActivity(intent);
            }
        });

        buttonModelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MicroscopeRequestActivity.this,ModelB_Accessories.class);
                startActivity(intent);
            }
        });
    }
}
