package com.rlard.app2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//        PackageManager pkg=this.getPackageManager();
//        pkg.setComponentEnabledSetting(new ComponentName(this,MainActivity.class),PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
       //         PackageManager.DONT_KILL_APP);

    }
}
