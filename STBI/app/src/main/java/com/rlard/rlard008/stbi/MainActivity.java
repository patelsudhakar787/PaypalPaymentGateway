package com.rlard.rlard008.stbi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","Begin");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonFindOpportinity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","FindOpportinuty");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonMentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","JoinMentor");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonInvestor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","JoinInvestor");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonManageSIG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("clickedButton","ManageSIG");
//                editor.commit();

                Intent intent = new Intent(MainActivity.this,SIG_LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonUpgradeSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","UpgradeSkill");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonScaleBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("clickedButton","UpgradeBusiness");
                editor.commit();

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        buttonManageBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        moveTaskToBack(true);
    }
}
