package com.example.rahuls.hideappdemo;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
/*
        try{
            PackageManager p = getPackageManager();
            p.setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        }catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}


/*/*
                ApplicationInfo ai =
                        null;
                try {
                    ai =MainActivity.this.getPackageManager().getApplicationInfo("com.example.rahuls.hideappdemo",0);
                    boolean appStatus = ai.enabled;
                    if(appStatus)
                    {
                      */
/*  Intent sendIntent =MainActivity.this.getPackageManager().getLaunchIntentForPackage("com.example.rahuls.hideappdemo");
                        sendIntent.putExtra("key", editText.getText().toString());
                        startActivity(sendIntent);*//*

                        PackageManager pm;
                        pm = getPackageManager();
                        //  get a list of installed apps.
                        List<ApplicationInfo> packages = pm.getInstalledApplications(0);
                        for(int i=0;i<packages.size();i++)
                        {
if(packages.get(i).packageName.toString().equals("com.example.rahuls.hideappdemo")) {
    Log.d("CheckAppIsAvailable", packages.get(i).packageName.toString());

          try {
              PackageManager p = getPackageManager();
              p.setComponentEnabledSetting(getComponentName(), PackageManager., PackageManager.DONT_KILL_APP);
          }catch (Exception ex)

          {
              ex.printStackTrace();
          }
*/
               /*Intent sendIntent =MainActivity.this.getPackageManager().getLaunchIntentForPackage(packages.get(i).packageName.toString());
                sendIntent.putExtra("key", editText.getText().toString());
                startActivity(sendIntent);
*/
        /*                }}

                    }else
                    {

                        PackageManager pm;
                        pm = getPackageManager();
                        //  get a list of installed apps.
                List<ApplicationInfo> packages = pm.getInstalledApplications(0);
                        for(int i=0;i<packages.size();i++)
                        {

                        }
                    }

                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

*/
