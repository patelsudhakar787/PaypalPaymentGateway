package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

public class ModelA_Accessories extends AppCompatActivity {

    Button buttonNext;

    CheckBox accessory1,accessory2,accessory3,accessory4,accessory5;

    String model="A";
    String acc1,acc2,acc3,acc4,acc5;

    SharedPreferences sharedPreferences;

    private ArrayList<Integer> arrayListInt=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_a__accessories);

        buttonNext = (Button) findViewById(R.id.nextAccessories_A);

        accessory1 = (CheckBox) findViewById(R.id.checkA);
        accessory2 = (CheckBox) findViewById(R.id.checkB);
        accessory3 = (CheckBox) findViewById(R.id.checkC);
        accessory4 = (CheckBox) findViewById(R.id.checkD);
        accessory5 = (CheckBox) findViewById(R.id.checkE);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getCheckBoxData();

                sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("model",model);

                editor.putString("acc1",acc1);
                editor.putString("acc2",acc2);
                editor.putString("acc3",acc3);
                editor.putString("acc4",acc4);
                editor.putString("acc5",acc5);

                editor.commit();

                Intent intent = new Intent(ModelA_Accessories.this,ShowFinalPriceActivity.class);
                intent.putIntegerArrayListExtra("checkdata",arrayListInt);
                startActivity(intent);

            }
        });

    }/// eof onCreate


    public void getCheckBoxData() {

        int number=0;

        if (accessory1.isChecked()) {
            acc1=accessory1.getText().toString();
            number=1;
            arrayListInt.add(number);

        }

        if (accessory2.isChecked()) {

            acc2 = accessory2.getText().toString();
            number=2;
            arrayListInt.add(number);

        }

        if (accessory3.isChecked()) {

            acc3 = accessory3.getText().toString();
            number=3;
            arrayListInt.add(number);

        }

        if (accessory4.isChecked()) {

            acc4 = accessory4.getText().toString();
            number=4;
            arrayListInt.add(number);

        }

        if (accessory5.isChecked()) {

            acc5 = accessory5.getText().toString();
            number=5;
            arrayListInt.add(number);

        }

    }

    @Override
    protected void onStop() {
        super.onStop();


        acc1 = "";
        acc2 = "";
        acc3 = "";
        acc4 = "";

    }

    @Override
    protected void onStart() {
        super.onStart();


        sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("acc1");
        editor.remove("acc2");
        editor.remove("acc3");
        editor.remove("acc4");

        editor.remove("priceAcc1");
        editor.remove("priceAcc2");
        editor.remove("priceAcc3");
        editor.remove("priceAcc4");

        editor.apply();

    }
}
