package com.petrolpump.rlard008.petrolpump;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.petrolpump.rlard008.petrolpump.fragment.CalenderFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<String>alpumpname=null;
    String selecturl="";
    private ActionBar actionbar=null;
    private ArrayAdapter<String>adapter=null;
    private SharedPreferences sharedPreferences;
//    private Button btn_calender;
//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        lv=(ListView)findViewById(R.id.lv);
//        btn_calender=(Button)findViewById(R.id.btn_date);
        alpumpname=new ArrayList<>();


        sharedPreferences=getSharedPreferences("admin", MODE_PRIVATE);
        Intent intent=getIntent();
        alpumpname=intent.getStringArrayListExtra("al");
        Log.e("arraylist",""+alpumpname);

            adapter = new ArrayAdapter<String>(AdminActivity.this, android.R.layout.simple_list_item_1, alpumpname);
            lv.setAdapter(adapter);
        actionbar=getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#82ade9")));

        actionBarTitleGravity();


//        btn_calender.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btn_calender.setVisibility(View.GONE);
//                lv.setVisibility(View.GONE);
//             loadCalenderFragment();
//            }
//        });


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String adminuname=sharedPreferences.getString("auname","");
                String pumpData=alpumpname.get(position);

                   selecturl = "http://10.10.0.220:8881/PatrolPump/SelectPumpDetail?date=2017-06-06&auname="+adminuname+"&pname="+pumpData;
                    Log.e("url", "" + selecturl);
                    sendAnotherRequest();

            }
        });


    }







    public void sendAnotherRequest()
    {
        StringRequest stringRequest=new StringRequest(selecturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {

                    Log.e("response", "" + response);
                    if(response.length() >18) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            String cmoney = jsonObject1.getString("cashpayment");
                                String cpay = jsonObject1.getString("cardpayment");
                                String preading = jsonObject1.getString("preading");
                                String dreading = jsonObject1.getString("dreading");
                                PumpData pumpData = new PumpData(cmoney, cpay, preading, dreading);
                                Log.e("PumpData", "" + pumpData);

                                AlertDialog.Builder builder1 = new AlertDialog.Builder(AdminActivity.this);
                                builder1.setMessage("Total Collection\n"+"Cash Payment is :" + pumpData.getCmoney() + " Rupees" + "\nCard Payment is :" + pumpData.getCpayment() + " Rupees\n" +"\nTotal Reading"+ "\nPetrol Reading is :" + pumpData.getPreading() + "\nDiesel Reading is :" + pumpData.getDreading());
                                builder1.setCancelable(true);
                                AlertDialog alert11 = builder1.create();
                                alert11.show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                    else {
                        Toast.makeText(AdminActivity.this, "No Data for this Pump", Toast.LENGTH_LONG).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
             Log.e("error",""+error);
            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("List Of Petrol Pumps");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionbar.setCustomView(textview);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        clearArray(alpumpname);
    }
public void clearArray(ArrayList<String>arrayList)
{
    for(int i=0;i<arrayList.size();i++)
    {
        alpumpname.clear();
    }
}


public void loadCalenderFragment()
{
    CalenderFragment calenderFragment=new CalenderFragment();
    FragmentManager fm=getSupportFragmentManager();
    FragmentTransaction ft=fm.beginTransaction();
    ft.replace(R.id.linear,calenderFragment);
    ft.commit();
}




}
