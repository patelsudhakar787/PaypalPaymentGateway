package com.rlard.rlard008.stbi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonBegin,buttonFindOpportinity,buttonMentor,buttonInvestor,buttonManageSIG,buttonUpgradeSkill,buttonScaleBusiness,buttonManageBusiness;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBegin = (Button) findViewById(R.id.btnbegin);
        buttonFindOpportinity = (Button) findViewById(R.id.btnfind);
        buttonMentor = (Button) findViewById(R.id.btnjoinmentor);
        buttonInvestor = (Button) findViewById(R.id.btnjoininvester);
        buttonManageSIG = (Button) findViewById(R.id.btnminstitute);
        buttonUpgradeSkill = (Button) findViewById(R.id.btnupgradeskill);
        buttonScaleBusiness = (Button) findViewById(R.id.btnupgrade);
        buttonManageBusiness = (Button) findViewById(R.id.btnbookresources);


        buttonBegin.setBackgroundColor(Color.TRANSPARENT);
        buttonFindOpportinity.setBackgroundColor(Color.TRANSPARENT);
        buttonMentor.setBackgroundColor(Color.TRANSPARENT);
        buttonInvestor.setBackgroundColor(Color.TRANSPARENT);
        buttonManageSIG.setBackgroundColor(Color.TRANSPARENT);
        buttonUpgradeSkill.setBackgroundColor(Color.TRANSPARENT);
        buttonScaleBusiness.setBackgroundColor(Color.TRANSPARENT);
        buttonManageBusiness.setBackgroundColor(Color.TRANSPARENT);



        sharedPreferences = getSharedPreferences("ActivityName",MODE_PRIVATE);


        buttonBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
                Intent launchiintent=getPackageManager().getLaunchIntentForPackage("com.rlard.beginmystartupidea");
                if (launchiintent != null) {
                    // We found the activity now start the activity
                    launchiintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchiintent);
                }

            }
        });

        buttonFindOpportinity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
                Intent launchiintent=getPackageManager().getLaunchIntentForPackage("com.rlard.findmyopportunity");
                if (launchiintent != null) {
                    // We found the activity now start the activity
                    launchiintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchiintent);
                }

            }
        });

        buttonMentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked",Toast.LENGTH_LONG).show();
                Intent launchiintent=getPackageManager().getLaunchIntentForPackage("com.rlard.joinasmentor");
                if (launchiintent != null) {
                    // We found the activity now start the activity
                    launchiintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchiintent);
                }
            }
        });

        buttonInvestor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"You didn't install this Module",Toast.LENGTH_LONG).show();

            }
        });

        buttonManageSIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You didn't install this Module",Toast.LENGTH_LONG).show();


            }
        });

        buttonUpgradeSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You didn't install this Module",Toast.LENGTH_LONG).show();


            }
        });

        buttonScaleBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You didn't install this Module",Toast.LENGTH_LONG).show();

            }
        });

        buttonManageBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You didn't install this Module",Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
    }
}
