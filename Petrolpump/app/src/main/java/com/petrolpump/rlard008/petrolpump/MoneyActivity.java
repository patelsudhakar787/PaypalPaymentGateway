package com.petrolpump.rlard008.petrolpump;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MoneyActivity extends AppCompatActivity {

    private String addurl="";
    private EditText etmoney;
    private EditText etcardpayment;
    private EditText etpetrolreading;
    private EditText etdiselreading;
    private Button btn_enter;
    private ActionBar actionbar=null;
    private SharedPreferences sharedPreferences;
    private String adminusername="";
    private String managerusername="";
    private String pumpname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        etmoney=(EditText)findViewById(R.id.etmoney);
        etcardpayment=(EditText)findViewById(R.id.cardpayment);
        etpetrolreading=(EditText)findViewById(R.id.etpreading);
        etdiselreading=(EditText)findViewById(R.id.etdreading);
        btn_enter=(Button)findViewById(R.id.btnenter);

        sharedPreferences=getSharedPreferences("manager",MODE_PRIVATE);

        adminusername=sharedPreferences.getString("admin","");
        managerusername=sharedPreferences.getString("pump","");
        pumpname=sharedPreferences.getString("manager","");
        actionbar=getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#82ade9")));
        actionBarTitleGravity();



        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money=etmoney.getText().toString();
                String cardpayment=etcardpayment.getText().toString();
                String preading=etpetrolreading.getText().toString();
                String dreading=etdiselreading.getText().toString();

                addurl="http://10.10.0.220:8881/PatrolPump/EnterCollectedMoneyServlet?auname="+adminusername+"&pname="+pumpname+"&mname="+managerusername+"&cardp="+cardpayment+"&cashp="+money+"&pr="+preading+"&dr="+dreading;
                Log.e("url",""+addurl);
                sendRequest();
                etmoney.setText("");
                etcardpayment.setText("");
                etpetrolreading.setText("");
                etdiselreading.setText("");
            }
        });


    }


    public void sendRequest()
    {
        StringRequest stringRequest=new StringRequest(addurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("responsengjhgv",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String data=jsonObject.getString("data");
                    if(data.equals("Inserted"))
                    {
                        Toast.makeText(MoneyActivity.this,"Your Detail hasBeen Submitted To Authority",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(MoneyActivity.this,"Server Problem",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("error",""+error);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("Petrol Pump Details");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionbar.setCustomView(textview);

    }
}
