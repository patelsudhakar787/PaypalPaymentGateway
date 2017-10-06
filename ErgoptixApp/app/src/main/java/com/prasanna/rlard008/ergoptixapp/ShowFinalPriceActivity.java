package com.prasanna.rlard008.ergoptixapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class ShowFinalPriceActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton12mon,radioButton6mon,radioButtonPreLaunch,radioButtonFamily;
    String radioData="";

    Button buttonNext;

    String accessories;
    String model;

    String acc1,acc2,acc3,acc4,acc5;


    String msg ;

    float priceAcc1,priceAcc2,priceAcc3,priceAcc4,priceAcc5;

    float total,saved;

    SharedPreferences sharedPreferences;

    float CPTotal;
    float CPAcc1=104231.0f;
    float CPAcc2=120445.0f;
    float CPAcc3=78204.0f;
    float CPAcc4=104231.0f;
    float CPAcc5=9796.0f;


    private ArrayList<Integer>arrayListInt=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_final_price);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroupOffers);
        radioButton12mon=(RadioButton)findViewById(R.id.radioOffer12Mon);
        radioButton6mon=(RadioButton)findViewById(R.id.radioOffer6Mon);
        radioButtonPreLaunch=(RadioButton)findViewById(R.id.radioOfferPreLaunch);
        radioButtonFamily=(RadioButton)findViewById(R.id.radioOfferFamily);

        buttonNext = (Button) findViewById(R.id.submitOffer);

        //getting data from arraylist
        Intent intent=getIntent();
        arrayListInt=intent.getIntegerArrayListExtra("checkdata");
        Log.e("arraylist",""+arrayListInt);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();
                getPrice();

                calculate();

                AlertDialog alertDialog = new AlertDialog.Builder(ShowFinalPriceActivity.this)
                    .setTitle("Confirmation")
                    .setMessage(""+msg)
                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {

                            accessories =""+(!acc1.equals("NA")? acc1:"")+" ,"+(!acc2.equals("NA")? acc2:"")+" ,"
                                    +(!acc3.equals("NA")? acc3:"")+" ,"+(!acc4.equals("NA")? acc4:"")+" ,"
                                    +(!acc5.equals("NA")? acc5:"");


                            sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("accessories", accessories);

                            editor.commit();


                            Intent intent = new Intent(ShowFinalPriceActivity.this,SubmitAccessoryActivity.class);
                            startActivity(intent);


                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(ShowFinalPriceActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .create();

            alertDialog.show();
            }
        });

    }


    void getData() {

        getRadioButtonData();

        sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);


        acc1 = sharedPreferences.getString("acc1","NA");
        acc2 = sharedPreferences.getString("acc2","NA");
        acc3 = sharedPreferences.getString("acc3","NA");
        acc4 = sharedPreferences.getString("acc4","NA");
        acc5 = sharedPreferences.getString("acc5","NA");

        model = sharedPreferences.getString("model","");

    }

    void getRadioButtonData() {

        int selectedId=radioGroup.getCheckedRadioButtonId();
        if(selectedId==R.id.radioOffer12Mon)
        {
            radioData="Offer12Mon";
        }
        if(selectedId==R.id.radioOffer6Mon)
        {
            radioData="Offer6Mon";
        }

        if(selectedId==R.id.radioOfferPreLaunch)
        {
            radioData="OfferPreLaunch";
        }
        if(selectedId==R.id.radioOfferFamily)
        {
            radioData="OfferFamily";
        }
    }

    void getPrice() {



        if (arrayListInt.size() == 0 ) {

            if (model.equals("A")) {
                CPTotal = 393925.0f;
                total = CPTotal;
                saved = 0.0f;
            }

            if (model.equals("B")) {
                CPTotal = 448448.0f;
                total = CPTotal;
                saved = 0.0f;
            }

        }

        else if(radioData.equals("") && !arrayListInt.isEmpty()) {

            if (model.equals("A")) {


                CPTotal = 393925.0f;

                if(arrayListInt.contains(1))
                {
                    CPTotal = CPTotal + CPAcc1;
                    total = CPTotal;

                }
                if(arrayListInt.contains(2))
                {

                    CPTotal = CPTotal + CPAcc2;
                    total = CPTotal;
                }
                if(arrayListInt.contains(3))
                {
                    CPTotal = CPTotal + CPAcc3;
                    total = CPTotal;
                }
                if(arrayListInt.contains(4))
                {

                    CPTotal = CPTotal + CPAcc4;
                    total = CPTotal;

                }
                if(arrayListInt.contains(5))
                {

                    CPTotal = CPTotal + CPAcc5;
                    total = CPTotal;
                }

                saved=CPTotal-total;

            }

            if (model.equals("B")) {

                CPTotal = 448448.0f;

                if(arrayListInt.contains(1))
                {

                    CPTotal = CPTotal + CPAcc1;
                    total = CPTotal;

                }
                if(arrayListInt.contains(2))
                {

                    CPTotal = CPTotal + CPAcc2;
                    total = CPTotal;
                }
                if(arrayListInt.contains(3))
                {

                    CPTotal = CPTotal + CPAcc3;
                    total = CPTotal;
                }
                if(arrayListInt.contains(4))
                {

                    CPTotal = CPTotal + CPAcc4;
                    total = CPTotal;

                }
                if(arrayListInt.contains(5))
                {

                    CPTotal = CPTotal + CPAcc5;
                    total = CPTotal;
                }

                saved=CPTotal-total;

            }

        }


        else if (model.equals("A")) {

            Log.e("model A", "" );

            CPTotal = 393925.0f;

            if (radioData.equals("Offer12Mon")) {

                priceAcc1 = 67750.0f;
                priceAcc2 = 78289.0f;
                priceAcc3 = 50833.0f;
                priceAcc4 = 67750.0f;
                priceAcc5 = 6368.0f;

                total = 256051.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

            if (radioData.equals("Offer6Mon")) {

                priceAcc1 = 62539.0f;
                priceAcc2 = 72267.0f;
                priceAcc3 = 46923.0f;
                priceAcc4 = 62539.0f;
                priceAcc5 = 5878.0f;

                total = 236355.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;


            }

            if (radioData.equals("OfferPreLaunch")) {

                priceAcc1 = 83385.0f;
                priceAcc2 = 96356.0f;
                priceAcc3 = 62563.0f;
                priceAcc4 = 83385.0f;
                priceAcc5 = 7837.0f;

                total = 315140.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

            if (radioData.equals("OfferFamily")) {

                priceAcc1 = 78174.0f;
                priceAcc2 = 90334.0f;
                priceAcc3 = 58653.0f;
                priceAcc4 = 78174.0f;
                priceAcc5 = 7347.0f;

                total = 295444.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

        }


        else if (model.equals("B")) {

            CPTotal = 448448.0f;

            if (radioData.equals("Offer12Mon")) {

                priceAcc1 = 67750.0f;
                priceAcc2 = 78289.0f;
                priceAcc3 = 50833.0f;
                priceAcc4 = 67750.0f;
                priceAcc5 = 6368.0f;

                total = 291491.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

            if (radioData.equals("Offer6Mon")) {

                priceAcc1 = 62539.0f;
                priceAcc2 = 72267.0f;
                priceAcc3 = 46923.0f;
                priceAcc4 = 62539.0f;
                priceAcc5 = 5878.0f;

                total = 269069.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

            if (radioData.equals("OfferPreLaunch")) {

                priceAcc1 = 62539.0f;
                priceAcc2 = 72267.0f;
                priceAcc3 = 46923.0f;
                priceAcc4 = 62539.0f;
                priceAcc5 = 5878.0f;

                total = 358758.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

            if (radioData.equals("OfferFamily")) {

                priceAcc1 = 62539.0f;
                priceAcc2 = 72267.0f;
                priceAcc3 = 46923.0f;
                priceAcc4 = 62539.0f;
                priceAcc5 = 5878.0f;

                total = 336336.0f;

                if(arrayListInt.contains(1))
                {
                    total=total+priceAcc1;
                    CPTotal = CPTotal + CPAcc1;
                }
                if(arrayListInt.contains(2))
                {
                    total=total+priceAcc2;
                    CPTotal = CPTotal + CPAcc2;
                }
                if(arrayListInt.contains(3))
                {
                    total=total+priceAcc3;
                    CPTotal = CPTotal + CPAcc3;
                }
                if(arrayListInt.contains(4))
                {
                    total=total+priceAcc4;
                    CPTotal = CPTotal + CPAcc4;
                }
                if(arrayListInt.contains(5))
                {
                    total=total+priceAcc5;
                    CPTotal = CPTotal + CPAcc5;
                }

                saved=CPTotal-total;

            }

        }

    }

    void calculate() {

        msg = "Your Details: "+
                "\n"+"You have saved Rs "+saved+
                "\n"+"Your final total is Rs "+total;

    }

}
