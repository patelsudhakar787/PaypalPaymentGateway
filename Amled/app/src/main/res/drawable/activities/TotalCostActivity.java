package com.example.sudhakar.amled.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhakar.amled.R;

import java.util.ArrayList;

import static com.example.sudhakar.amled.R.id.qty;

public class TotalCostActivity extends AppCompatActivity{


    private TextView textViewmaterial;
    private TextView textviewlabour;
    private TextView textViewquality;
    private EditText etquantity;
    private Button btn_generate;
    private float totalcost=0f;
    private ArrayList<com.example.sudhakar.amled.pojo.CalCost>arrayList;
    private int quatity=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_total_cost);
    textViewmaterial=(TextView)findViewById(R.id.material);
    textviewlabour=(TextView)findViewById(R.id.labour);
    textViewquality=(TextView)findViewById(R.id.quality);
    btn_generate=(Button)findViewById(R.id.btn_gen);

    etquantity=(EditText) findViewById(qty);

    arrayList=new ArrayList<>();
    SharedPreferences sharedPreferences1=getSharedPreferences("cledcost1",MODE_PRIVATE);
    float cost1=sharedPreferences1.getFloat("cost1",0);
        Log.e("cost1","--"+cost1);

    SharedPreferences sharedPreferences2=getSharedPreferences("cledcost2",MODE_PRIVATE);
    float cost2=sharedPreferences2.getFloat("cost2",0);
        Log.e("cost2","--"+cost2);

    SharedPreferences sharedPreferences3=getSharedPreferences("cledcost3",MODE_PRIVATE);
    float cost3=sharedPreferences3.getFloat("cost3",0);
        Log.e("cost3","--"+cost3);

    SharedPreferences sharedPreferences4=getSharedPreferences("cledcost4",MODE_PRIVATE);
    float cost4=sharedPreferences4.getFloat("cost4",0);
        Log.e("cost4","--"+cost4);

    SharedPreferences sharedPreferences5=getSharedPreferences("cledcost5",MODE_PRIVATE);
    float cost5=sharedPreferences5.getFloat("cost5",0);
        Log.e("cost5","--"+cost5);


        totalcost=cost1+cost2+cost3+cost4+cost5;


        Log.e("TotalCost----",""+totalcost);

        calculatingCost();


        //click listener on Button
        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=0;
                String qty=etquantity.getText().toString();
                if(qty.length()==0)
                {
                    Toast.makeText(com.example.sudhakar.amled.activities.TotalCostActivity.this,"Please Enter Your Quantity",Toast.LENGTH_LONG).show();
                }
                else {
                    quatity=Integer.parseInt(qty);
                    Log.e("Quantity", "" + quatity);
                    if (quatity <= 10) {
                        i = 0;

                    }
                    if (quatity > 10 && quatity <= 50) {
                        i = 1;

                    }
                    if (quatity > 50 && quatity <= 100) {
                        i = 2;
                    }
                    if (quatity > 100) {
                        i = 3;
                    }

                    com.example.sudhakar.amled.pojo.CalCost calCost = arrayList.get(i);
                    textviewlabour.setText("" + calCost.getLabourcost());
                    textViewmaterial.setText("" + calCost.getMaterialcost());
                    textViewquality.setText("" + calCost.getQualitycheckcost());

                    totalcost = quatity*(totalcost + calCost.getMaterialcost() + calCost.getLabourcost() + calCost.getQualitycheckcost());
                    totalcost = (totalcost * (100f - calCost.getDiscount())) / 100;
                    Log.e("TotalCost", "" + totalcost);
                    alert();
                }

            }
        });



}//eof on create

    public void calculatingCost()
        {
            arrayList.add(new com.example.sudhakar.amled.pojo.CalCost(10,10f,15f,20f,20f));
            arrayList.add(new com.example.sudhakar.amled.pojo.CalCost(50,20f,25f,30f,25f));
            arrayList.add(new com.example.sudhakar.amled.pojo.CalCost(100,30f,35f,40f,30f));
            arrayList.add(new com.example.sudhakar.amled.pojo.CalCost(200,40f,45f,50f,35f));
        }


        public void alert()
        {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setMessage("Your Total Cost is "+totalcost+" Rs");
            builder.show();
        }


}

// totalcost=totalcost+calCost.getLabourcost()+calCost.getMaterialcost()+calCost.getLabourcost();
//                    totalcost=qty*(totalcost*(100f-calCost.getDiscount())/100);
//                    Log.e("discount",""+calCost.getDiscount());