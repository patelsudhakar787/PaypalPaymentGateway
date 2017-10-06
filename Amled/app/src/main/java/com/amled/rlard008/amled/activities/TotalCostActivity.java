package com.amled.rlard008.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.AmledCost;
import com.amled.rlard008.amled.pojo.WelcomeImageData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.amled.rlard008.amled.R.id.qty;
import static com.amled.rlard008.amled.R.id.spinner;


public class TotalCostActivity extends AppCompatActivity{


    private ImageView image;
    private TextView textv;
    private EditText etquantity;
    private Button btn_order;
    private Button btn_confirmorder;
    private Button btn_cancelorder;
    private ActionBar actionbar=null;
    private CardView cardorder;
    private CardView cardconfirmorder;
    private CardView cardView;
    private Spinner spinnerwattage;
    private ArrayList<AmledCost>amledCosts=null;
    private ArrayList<Integer>spinnertplight;
    private ArrayList<Integer>spinnerfbslight;
    private ArrayAdapter<Integer>adapter;
    private String ledtype="";
    private String chooseleds="";
    private String ledconfigs="";
    private String leddrivers="";
    private String ledpcbs="";
    private String ledpccovers="";
    private String ledpccovergrade="";
    private String chooseledgrade="";
    private String mhousinggrade="";
    private String leddrivergrade="";
    private String ledpcbgrade="";
    //initializing TextViews
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView19;
    private TextView textViewtcost;
    private TextView textperunit;
    private WelcomeImageData welcomeImageData;
    private ArrayList<WelcomeImageData>arrayList;
    private int quatity=0;
    private int wattage=0;
    private double totalcost=0.0;
    private double qlmcost=0.0;
    private static int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_total_cost);

        btn_order=(Button)findViewById(R.id.btn_order);
        btn_confirmorder=(Button)findViewById(R.id.btnconfirm);
        btn_cancelorder=(Button)findViewById(R.id.btncancel);
        cardorder=(CardView)findViewById(R.id.cardorder);
        cardconfirmorder=(CardView)findViewById(R.id.cardconfirmorder);
        cardView=(CardView)findViewById(R.id.card);
        spinnerwattage=(Spinner)findViewById(spinner);
        image=(ImageView)findViewById(R.id.image);
        textv=(TextView)findViewById(R.id.text);
        textView1=(TextView)findViewById(R.id.tv2);
        textView2=(TextView)findViewById(R.id.tv4);
        textView3=(TextView)findViewById(R.id.tv6);

        textView4=(TextView)findViewById(R.id.tv8);
        textView5=(TextView)findViewById(R.id.tv10);
        textView6=(TextView)findViewById(R.id.tv12);
        textView7=(TextView)findViewById(R.id.tv14);
        textView8=(TextView)findViewById(R.id.tv16);
        textView9=(TextView)findViewById(R.id.tv18);
        textView10=(TextView)findViewById(R.id.tv20);
        textView19=(TextView)findViewById(R.id.textView19);
        textViewtcost=(TextView)findViewById(R.id.textView3);
        textperunit=(TextView)findViewById(R.id.tv22);


        textView19.setText("QualityCheck Cost,\nLabour Cost");
        textViewtcost.setText("Total Cost\n(including qualitycheck cost,\nlabour cost and material cost)");

        actionbar=getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));
        etquantity=(EditText) findViewById(qty);
        etquantity.setInputType(InputType.TYPE_CLASS_TEXT);

        cardconfirmorder.setVisibility(View.GONE);


        addingListData();

        //timer
        final Handler handler=new Handler();
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        welcomeImageData=arrayList.get(i);
                        image.setImageResource(welcomeImageData.getImageid());
                        textv.setText(welcomeImageData.getImagename());
                        i++;
                        if(i==5)
                        {
                            i=0;
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0,4*1000);


        //getting led type
        SharedPreferences sharedPreferences1_1=getSharedPreferences("lights",MODE_PRIVATE);
        ledtype=sharedPreferences1_1.getString("light","");
        Log.e("LEDType",""+ledtype);
//calling function
        getAmledCost(ledtype);
        if(ledtype.equals("TubeLight") || ledtype.equals("PanelLight"))
        {
            getTPSpinner();
        }
        if(ledtype.equals("FloodLight") || ledtype.equals("StreetLight") || ledtype.equals("BayLight"))
        {
            getFBSSpinner();
        }



        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wattage=Integer.parseInt(spinnerwattage.getSelectedItem().toString());
                Log.e("Wattage","Wt"+wattage);
                getSharedPreferencesData(wattage);

                boolean flag=false;
                String quatityd = etquantity.getText().toString();

                if (!quatityd.matches("^[0-9]*$")) {

                    etquantity.setError("Pls Enter Numbers Only");
                    flag=false;
                    return;
                }
                else {
                    try {
                        quatity = Integer.parseInt(quatityd);
                        totalcost=quatity*totalcost;
                        Log.e("Quantity","qty"+quatity);
                        flag = true;
                    }
                    catch (Exception NumberFormatException) {
                        etquantity.setError("Pls Enter Numbers Only");
                    }
                }




               if(flag == true) {
                   cardorder.setVisibility(View.GONE);
                   cardView.setVisibility(View.GONE);
                   cardconfirmorder.setVisibility(View.VISIBLE);



                   //setting data to textView
                   textView1.setText("" + quatity);
                   textView2.setText("" + wattage);
                   DecimalFormat precision = new DecimalFormat("0.00");
                   textView3.setText("" + precision.format(totalcost)+" Rs");
                   qlmcost=totalcost/5;
                   DecimalFormat precision1 = new DecimalFormat("0.00");
                   textView10.setText(""+precision1.format(qlmcost)+" RS");
                   textView4.setText("" + chooseleds);
                   textView5.setText("" + ledpcbs);
                   textView6.setText("" + leddrivers);
                   textView7.setText("" + ledconfigs);
                   textView8.setText(""+ledtype);
                   textView9.setText(""+ledpccovers);

                   double perunitcost=totalcost/quatity;
                   DecimalFormat decimalFormat=new DecimalFormat("0.00");
                   textperunit.setText(""+decimalFormat.format(perunitcost)+" Rs");
               }
            }
        });

        btn_cancelorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardconfirmorder.setVisibility(View.GONE);
                cardorder.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.VISIBLE);
            }
        });


        btn_confirmorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TotalCostActivity.this,RegistrationActivity.class);
                intent.putExtra("cost",totalcost);
                startActivity(intent);
            }
        });


}//eof on create



        public void getSharedPreferencesData(int wt)
        {


            //getting data from chooseLED
            SharedPreferences sharedPreferences1_2=getSharedPreferences("chooseledobj",MODE_PRIVATE);
            chooseleds=sharedPreferences1_2.getString("chooseled","");
            chooseledgrade=sharedPreferences1_2.getString("chooseledgrade","");
            Log.e("ChooseLEd","----"+chooseleds);
            Log.e("ChooseLEdGrade","----"+chooseledgrade);

            //calling function
           double cost1=findCost(ledtype,chooseledgrade,wt);
            Log.e("Cost1",""+cost1);

            //getting data from LED Configuration
            SharedPreferences sharedPreferences1_3=getSharedPreferences("mhousingobj",MODE_PRIVATE);
            String ledconfig1=sharedPreferences1_3.getString("mhousing1","");
            String ledconfig2=sharedPreferences1_3.getString("mhousing2","");
            mhousinggrade=sharedPreferences1_3.getString("mhousinggrade","");
            ledconfigs=ledconfig1+":"+ledconfig2;

            Log.e("MhousingGrade","----"+mhousinggrade);


            //calling function
            double cost2=findCost(ledtype,mhousinggrade,wt);
            Log.e("Cost2",""+cost2);


            //getting data from LED Driver
            SharedPreferences sharedPreferences1_4=getSharedPreferences("leddriverobj",MODE_PRIVATE);
             leddrivers=sharedPreferences1_4.getString("leddriver","");
            leddrivergrade=sharedPreferences1_4.getString("leddrivergrade","");
            Log.e("LEDDriver",""+leddrivers);
            Log.e("LedDriverGrade","----"+leddrivergrade);


            //calling function
           double cost3=findCost(ledtype,leddrivergrade,wt);
            Log.e("Cost3",""+cost3);


            //getting data from LED PCB
            SharedPreferences sharedPreferences1_5=getSharedPreferences("ledpcbobj",MODE_PRIVATE);
             ledpcbs=sharedPreferences1_5.getString("ledpcb","");
            ledpcbgrade=sharedPreferences1_5.getString("ledpcbgrade","");
            Log.e("LEDPcb",""+ledpcbs);
            Log.e("LedPcbGarde","----"+ledpcbgrade);

            //calling function
            double cost4=findCost(ledtype,ledpcbgrade,wt);
            Log.e("Cost4",""+cost4);


            //getting data from LED PC COVER
            SharedPreferences sharedPreferences1_6=getSharedPreferences("ledpccoverobj",MODE_PRIVATE);
             ledpccovergrade=sharedPreferences1_6.getString("ledpccovergrade","");
            ledpccovers=sharedPreferences1_6.getString("ledpccover","");
            Log.e("LEDPCCover",""+ledpccovers);

            //calling function
            double cost5=findCost(ledtype,ledpccovergrade,wt);
            Log.e("Cost5",""+cost5);

            totalcost=cost1+cost2+cost3+cost4+cost5;



            Log.e("Total Cost",""+totalcost);
        }





        //costlist of amled products
    public void getAmledCost(String ledlight)
    {
       amledCosts=new ArrayList<AmledCost>();
        //tubelight
        if(ledlight.equals("TubeLight")) {
            // grade A

                amledCosts.add(new AmledCost("TubeLight", "A", 3, 60.00));
                amledCosts.add(new AmledCost("TubeLight", "A", 6, 106.00));
                amledCosts.add(new AmledCost("TubeLight", "A", 9, 142.00));
                amledCosts.add(new AmledCost("TubeLight", "A", 12, 184.00));
                amledCosts.add(new AmledCost("TubeLight", "A", 15, 210.00));
                amledCosts.add(new AmledCost("TubeLight", "A", 18, 270.00));

            //grade B

                amledCosts.add(new AmledCost("TubeLight", "B", 3, 50.00));
                amledCosts.add(new AmledCost("TubeLight", "B", 6, 96.00));
                amledCosts.add(new AmledCost("TubeLight", "B", 9, 122.00));
                amledCosts.add(new AmledCost("TubeLight", "B", 12, 154.00));
                amledCosts.add(new AmledCost("TubeLight", "B", 15, 178.00));
                amledCosts.add(new AmledCost("TubeLight", "B", 18, 205.00));

            //grade C

                amledCosts.add(new AmledCost("TubeLight", "C", 3, 42.00));
                amledCosts.add(new AmledCost("TubeLight", "C", 6, 76.00));
                amledCosts.add(new AmledCost("TubeLight", "C", 9, 99.00));
                amledCosts.add(new AmledCost("TubeLight", "C", 12, 116.00));
                amledCosts.add(new AmledCost("TubeLight", "C", 15, 137.00));
                amledCosts.add(new AmledCost("TubeLight", "C", 18, 174.00));

        }
        if(ledlight.equals("BayLight"))
        {
            //baylight
            //grade A
            amledCosts.add(new AmledCost("BayLight", "A", 15, 460.00));
            amledCosts.add(new AmledCost("BayLight", "A", 20, 940.00));
            amledCosts.add(new AmledCost("BayLight", "A", 45, 1380.00));
            amledCosts.add(new AmledCost("BayLight", "A", 60, 1700.00));
            amledCosts.add(new AmledCost("BayLight", "A", 75, 2040.00));
            amledCosts.add(new AmledCost("BayLight", "A", 90,2540.00));
            amledCosts.add(new AmledCost("BayLight", "A", 120, 2820.00));

            //grade B
            amledCosts.add(new AmledCost("BayLight", "B", 15, 360.00));
            amledCosts.add(new AmledCost("BayLight", "B", 30, 700.0));
            amledCosts.add(new AmledCost("BayLight", "B", 45, 1020.00));
            amledCosts.add(new AmledCost("BayLight", "B", 60, 1260.00));
            amledCosts.add(new AmledCost("BayLight", "B", 75, 1580.00));
            amledCosts.add(new AmledCost("BayLight", "B", 90, 1820.00));
            amledCosts.add(new AmledCost("BayLight", "B", 120, 2140.00));

            //grade C
            amledCosts.add(new AmledCost("BayLight", "C", 15, 280.00));
            amledCosts.add(new AmledCost("BayLight", "C", 30, 540.00));
            amledCosts.add(new AmledCost("BayLight", "C", 45, 700.00));
            amledCosts.add(new AmledCost("BayLight", "C", 60, 840.00));
            amledCosts.add(new AmledCost("BayLight", "C", 75, 1140.00));
            amledCosts.add(new AmledCost("BayLight", "C", 90, 1380.00));
            amledCosts.add(new AmledCost("BayLight", "C", 120, 1620.00));
        }

        if(ledlight.equals("FloodLight"))
        {
            //baylight
            //grade A
            amledCosts.add(new AmledCost("FloodLight", "A", 15, 460.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 20, 940.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 45, 1380.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 60, 1700.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 75, 2040.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 90,2540.00));
            amledCosts.add(new AmledCost("FloodLight", "A", 120, 2820.00));

            //grade B
            amledCosts.add(new AmledCost("FloodLight", "B", 15, 360.00));
            amledCosts.add(new AmledCost("FloodLight", "B", 30, 700.0));
            amledCosts.add(new AmledCost("FloodLight", "B", 45, 1020.00));
            amledCosts.add(new AmledCost("FloodLight", "B", 60, 1260.00));
            amledCosts.add(new AmledCost("FloodLight", "B", 75, 1580.00));
            amledCosts.add(new AmledCost("FloodLight", "B", 90, 1820.00));
            amledCosts.add(new AmledCost("FloodLight", "B", 120, 2140.00));

            //grade C
            amledCosts.add(new AmledCost("FloodLight", "C", 15, 280.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 30, 540.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 45, 700.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 60, 840.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 75, 1140.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 90, 1380.00));
            amledCosts.add(new AmledCost("FloodLight", "C", 120, 1620.00));
        }

        if(ledlight.equals("StreetLight"))
        {
            //baylight
            //grade A
            amledCosts.add(new AmledCost("StreetLight", "A", 15, 460.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 20, 940.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 45, 1380.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 60, 1700.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 75, 2040.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 90,2540.00));
            amledCosts.add(new AmledCost("StreetLight", "A", 120, 2820.00));

            //grade B
            amledCosts.add(new AmledCost("StreetLight", "B", 15, 360.00));
            amledCosts.add(new AmledCost("StreetLight", "B", 30, 700.0));
            amledCosts.add(new AmledCost("StreetLight", "B", 45, 1020.00));
            amledCosts.add(new AmledCost("StreetLight", "B", 60, 1260.00));
            amledCosts.add(new AmledCost("StreetLight", "B", 75, 1580.00));
            amledCosts.add(new AmledCost("StreetLight", "B", 90, 1820.00));
            amledCosts.add(new AmledCost("StreetLight", "B", 120, 2140.00));

            //grade C
            amledCosts.add(new AmledCost("StreetLight", "C", 15, 280.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 30, 540.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 45, 700.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 60, 840.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 75, 1140.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 90, 1380.00));
            amledCosts.add(new AmledCost("StreetLight", "C", 120, 1620.00));
        }

        if(ledlight.equals("PanelLight"))
        {
            amledCosts.add(new AmledCost("PanelLight", "A", 3, 330.00));
            amledCosts.add(new AmledCost("PanelLight", "A", 6, 583.00));
            amledCosts.add(new AmledCost("PanelLight", "A", 9, 781.00));
            amledCosts.add(new AmledCost("PanelLight", "A", 12, 1012.00));
            amledCosts.add(new AmledCost("PanelLight", "A", 15, 1155.00));
            amledCosts.add(new AmledCost("PanelLight", "A", 18, 1485.00));

            //grade B
            amledCosts.add(new AmledCost("PanelLight", "B", 3, 209.00));
            amledCosts.add(new AmledCost("PanelLight", "B", 6, 401.20));
            amledCosts.add(new AmledCost("PanelLight", "B", 9, 501.00));
            amledCosts.add(new AmledCost("PanelLight", "B", 12, 643.80));
            amledCosts.add(new AmledCost("PanelLight", "B", 15, 744.00));
            amledCosts.add(new AmledCost("PanelLight", "B", 18, 857.20));

            //grade C
            amledCosts.add(new AmledCost("PanelLight", "C", 3, 92.40));
            amledCosts.add(new AmledCost("PanelLight", "C", 6, 167.20));
            amledCosts.add(new AmledCost("PanelLight", "C", 9, 217.80));
            amledCosts.add(new AmledCost("PanelLight", "C", 12, 255.20));
            amledCosts.add(new AmledCost("PanelLight", "C", 15, 301.40));
            amledCosts.add(new AmledCost("PanelLight", "C", 18, 382.80));
        }
    }




    public  void getFBSSpinner()
    {
        spinnerfbslight=new ArrayList<>();
        spinnerfbslight.add(15);
        spinnerfbslight.add(30);
        spinnerfbslight.add(45);
        spinnerfbslight.add(60);
        spinnerfbslight.add(75);
        spinnerfbslight.add(90);
        spinnerfbslight.add(120);

        adapter=new ArrayAdapter<Integer>(TotalCostActivity.this,android.R.layout.simple_list_item_1,spinnerfbslight);
        spinnerwattage.setAdapter(adapter);
    }
    public void getTPSpinner()
    {
     spinnertplight=new ArrayList<>();
        spinnertplight.add(3);
        spinnertplight.add(6);
        spinnertplight.add(9);
        spinnertplight.add(12);
        spinnertplight.add(15);
        spinnertplight.add(18);

        adapter=new ArrayAdapter<Integer>(TotalCostActivity.this,android.R.layout.simple_list_item_1,spinnertplight);
        spinnerwattage.setAdapter(adapter);
    }



    public double findCost(String light,String grade,int wattage)
    {
        double cost=0.0;
        for(AmledCost amledCost:amledCosts)
        {
            if(amledCost.getLight().equals(light) && amledCost.getGrade().equals(grade) && amledCost.getWattage() == wattage)
            {
                cost= (double) amledCost.getCost();
                Log.e("Cost","Cost  "+cost);
            }
        }
        return cost;
    }
    public void addingListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new WelcomeImageData(R.drawable.tubelight, "Tube Light"));
        arrayList.add(new WelcomeImageData(R.drawable.baylight, "Bay Light"));
        arrayList.add(new WelcomeImageData(R.drawable.floodlight, "Flood Light"));
        arrayList.add(new WelcomeImageData(R.drawable.streetlight, "Street Light"));
        arrayList.add(new WelcomeImageData(R.drawable.panellight, "Panel Light"));


    }


}
