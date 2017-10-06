package com.rlard.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_launch=(Button)findViewById(R.id.btn);



        final String packagename="com.rlard.app2.MainActivity";
        btn_launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchiintent=getPackageManager().getLaunchIntentForPackage("com.rlard.app2");
                if (launchiintent != null) {
                    // We found the activity now start the activity
                    launchiintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchiintent);
                }
            }
        });
    }
}
