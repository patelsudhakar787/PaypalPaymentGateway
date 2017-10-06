package com.petrolpump.rlard008.petrolpump;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    CardView cardViewAdmin,cardViewMgr1,cardViewMgr2,cardViewMgr3,cardViewMgr4,cardViewMgr5,cardViewMgr6,cardViewMgr7,cardViewMgr8;
    Button buttonSubmit,buttonAdd;

    EditText adminPhone,adminId,adminPassword;

    EditText pumpName1,pumpName2,pumpName3,pumpName4,pumpName5,pumpName6,pumpName7,pumpName8;
    EditText mrgPhone1,mrgPhone2,mrgPhone3,mrgPhone4,mrgPhone5,mrgPhone6,mrgPhone7,mrgPhone8;
    EditText mgrId1,mgrId2,mgrId3,mgrId4,mgrId5,mgrId6,mgrId7,mgrId8;
    EditText mgrPassword1,mgrPassword2,mgrPassword3,mgrPassword4,mgrPassword5,mgrPassword6,mgrPassword7,mgrPassword8;

    static int press = 0;

    String admin_Phone,admin_Id,admin_Password;

     String pump_Name1,pump_Name2,pump_Name3,pump_Name4,pump_Name5,pump_Name6,pump_Name7,pump_Name8;
    static String pump_Name="";
    static String mrg_Phone="",mrg_Phone1;//,mrg_Phone3,mrg_Phone4,mrg_Phone5,mrg_Phone6,mrg_Phone7,mrg_Phone8;
    static String mgr_Id="",mgr_Id1;//,mgr_Id3,mgr_Id4,mgr_Id5,mgr_Id6,mgr_Id7,mgr_Id8;
    static String mgr_Password="",mgr_Password1;//,mgr_Password3,mgr_Password4,mgr_Password5,mgr_Password6,mgr_Password7,mgr_Password8;

    String addUrl,submitUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonAdd = (Button) findViewById(R.id.btn_RegAdd);
        buttonSubmit = (Button) findViewById(R.id.btn_RegSubmit);

        cardViewAdmin = (CardView) findViewById(R.id.linearAdmin);
        cardViewMgr1 = (CardView) findViewById(R.id.linear1);
        cardViewMgr2 = (CardView) findViewById(R.id.linear2);
        cardViewMgr3 = (CardView) findViewById(R.id.linear3);
        cardViewMgr4 = (CardView) findViewById(R.id.linear4);
        cardViewMgr5 = (CardView) findViewById(R.id.linear5);
        cardViewMgr6 = (CardView) findViewById(R.id.linear6);
        cardViewMgr7 = (CardView) findViewById(R.id.linear7);
        cardViewMgr8 = (CardView) findViewById(R.id.linear8);

        adminId = (EditText) findViewById(R.id.adminId);
        adminPassword = (EditText) findViewById(R.id.adminPassword);
        adminPhone = (EditText) findViewById(R.id.adminPhone);

        mrgPhone1 = (EditText) findViewById(R.id.mgrPhone1);
        mrgPhone2 = (EditText) findViewById(R.id.mgrPhone2);
        mrgPhone3 = (EditText) findViewById(R.id.mgrPhone3);
        mrgPhone4 = (EditText) findViewById(R.id.mgrPhone4);
        mrgPhone5 = (EditText) findViewById(R.id.mgrPhone5);
        mrgPhone6 = (EditText) findViewById(R.id.mgrPhone6);
        mrgPhone7 = (EditText) findViewById(R.id.mgrPhone7);
        mrgPhone8 = (EditText) findViewById(R.id.mgrPhone8);



        mgrId1 = (EditText) findViewById(R.id.mgrId1);
        mgrId2 = (EditText) findViewById(R.id.mgrId2);
        mgrId3 = (EditText) findViewById(R.id.mgrId3);
        mgrId4 = (EditText) findViewById(R.id.mgrId4);
        mgrId5 = (EditText) findViewById(R.id.mgrId5);
        mgrId6 = (EditText) findViewById(R.id.mgrId6);
        mgrId7 = (EditText) findViewById(R.id.mgrId7);
        mgrId8 = (EditText) findViewById(R.id.mgrId8);

        mgrPassword1 = (EditText) findViewById(R.id.mgrPassword1);
        mgrPassword2 = (EditText) findViewById(R.id.mgrPassword2);
        mgrPassword3 = (EditText) findViewById(R.id.mgrPassword3);
        mgrPassword4 = (EditText) findViewById(R.id.mgrPassword4);
        mgrPassword5 = (EditText) findViewById(R.id.mgrPassword5);
        mgrPassword6 = (EditText) findViewById(R.id.mgrPassword6);
        mgrPassword7 = (EditText) findViewById(R.id.mgrPassword7);
        mgrPassword8 = (EditText) findViewById(R.id.mgrPassword8);

        pumpName1 = (EditText) findViewById(R.id.mgrPump1);
        pumpName2 = (EditText) findViewById(R.id.mgrPump2);
        pumpName3 = (EditText) findViewById(R.id.mgrPump3);
        pumpName4 = (EditText) findViewById(R.id.mgrPump4);
        pumpName5 = (EditText) findViewById(R.id.mgrPump5);
        pumpName6 = (EditText) findViewById(R.id.mgrPump6);
        pumpName7 = (EditText) findViewById(R.id.mgrPump7);
        pumpName8 = (EditText) findViewById(R.id.mgrPump8);


        cardViewMgr2.setVisibility(View.GONE);
        cardViewMgr3.setVisibility(View.GONE);
        cardViewMgr4.setVisibility(View.GONE);
        cardViewMgr5.setVisibility(View.GONE);
        cardViewMgr6.setVisibility(View.GONE);
        cardViewMgr7.setVisibility(View.GONE);
        cardViewMgr8.setVisibility(View.GONE);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                admin_Phone = adminPhone.getText().toString();
                admin_Id = adminId.getText().toString();
                admin_Password = adminPassword.getText().toString();

                if (press==7) {
                    cardViewMgr8.setVisibility(View.VISIBLE);

                    pump_Name = pumpName8.getText().toString();
                    mgr_Id = mgrId8.getText().toString();
                    mgr_Password = mgrPassword8.getText().toString();
                    mrg_Phone = mrgPhone8.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);


                }
                if (press==6) {
                    cardViewMgr7.setVisibility(View.VISIBLE);
                    press = 7;

                    pump_Name = pumpName7.getText().toString();
                    mgr_Id = mgrId7.getText().toString();
                    mgr_Password = mgrPassword7.getText().toString();
                    mrg_Phone = mrgPhone7.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);
                }
                if (press==5) {
                    cardViewMgr6.setVisibility(View.VISIBLE);
                    press = 6;

                    pump_Name = pumpName6.getText().toString();
                    mgr_Id = mgrId6.getText().toString();
                    mgr_Password = mgrPassword6.getText().toString();
                    mrg_Phone = mrgPhone6.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);

                }

                if (press==4) {
                    cardViewMgr5.setVisibility(View.VISIBLE);
                    press = 5;

                    pump_Name = pumpName5.getText().toString();
                    mgr_Id = mgrId5.getText().toString();
                    mgr_Password = mgrPassword5.getText().toString();
                    mrg_Phone = mrgPhone5.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);

                }
                if (press==3) {
                    cardViewMgr4.setVisibility(View.VISIBLE);
                    press=4;

                    pump_Name = pumpName4.getText().toString();
                    mgr_Id = mgrId4.getText().toString();
                    mgr_Password = mgrPassword4.getText().toString();
                    mrg_Phone = mrgPhone4.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);
                }
                if (press==2) {
                    cardViewMgr3.setVisibility(View.VISIBLE);
                    press = 3;

                    pump_Name = pumpName3.getText().toString();
                    mgr_Id = mgrId3.getText().toString();
                    mgr_Password = mgrPassword3.getText().toString();
                    mrg_Phone = mrgPhone3.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);
                }

                if (press==1) {
                    cardViewMgr2.setVisibility(View.VISIBLE);
                    press = 2;

                    pump_Name = pumpName2.getText().toString();
                    mgr_Id = mgrId2.getText().toString();
                    mgr_Password = mgrPassword2.getText().toString();
                    mrg_Phone = mrgPhone2.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);


                }

                if (press==0) {
                    //cardViewMgr2.setVisibility(View.VISIBLE);
                    press = 1;

                    pump_Name = pumpName1.getText().toString();
                    mgr_Id = mgrId1.getText().toString();
                    mgr_Password = mgrPassword1.getText().toString();
                    mrg_Phone = mrgPhone1.getText().toString();
                    Log.e("pump1name",""+pump_Name);
                    Log.e("manager1",""+mgr_Id);
                    Log.e("password",""+mgr_Password);
                    Log.e("contact",""+mrg_Phone);


                }
                addUrl = "http://10.10.0.220:8881/PatrolPump/LoginDetails?auname="+admin_Id+"&muname="+mgr_Id+
                        "&pname="+pump_Name+"&mcontact="+mrg_Phone+"&mpassword="+mgr_Password;

                //getUserData();

                Log.e("url",""+addUrl);
                addRequestData();
                pump_Name="";
                mgr_Id="";
                mgr_Password="";
                mrg_Phone="";
            }
        });


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSubmitData();
            }
        });

    }//// eof onCreate


    void addRequestData() {

        StringRequest stringRequest = new StringRequest(addUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String result=jsonObject.getString("data");
                    Toast.makeText(RegisterActivity.this,result,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("addData Error", ""+error);

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    void getSubmitData() {

        admin_Phone = adminPhone.getText().toString();
        admin_Id = adminId.getText().toString();
        admin_Password = adminPassword.getText().toString();

        pump_Name1 = pumpName1.getText().toString();
        pump_Name1 = pump_Name1.replace(" ","_");

        pump_Name2 = pumpName2.getText().toString();
        pump_Name2 = pump_Name2.replace(" ","_");

        pump_Name3 = pumpName3.getText().toString();
        pump_Name3 = pump_Name3.replace(" ","_");

        pump_Name4 = pumpName4.getText().toString();
        pump_Name4 = pump_Name4.replace(" ","_");

        pump_Name5 = pumpName5.getText().toString();
        pump_Name5 = pump_Name5.replace(" ","_");

        pump_Name6 = pumpName6.getText().toString();
        pump_Name6 = pump_Name6.replace(" ","_");

        pump_Name7 = pumpName7.getText().toString();
        pump_Name7 = pump_Name7.replace(" ","_");

        pump_Name8 = pumpName8.getText().toString();
        pump_Name8 = pump_Name8.replace(" ","_");

        addRequestData();

        submitUrl = "http://10.10.0.220:8881/PatrolPump/AdminRegistration?auname="+admin_Id+"&acontact="+admin_Phone+
                "&apass="+admin_Password+"&p1name="+pump_Name1+"&p2name="+pump_Name2+"&p3name"+pump_Name3+
                "&p4name="+pump_Name4+"&p5name="+pump_Name5+"&p6name="+pump_Name6+"&p7name="+pump_Name7;
        Log.e("url","url");

        submitRequestData();
    }


    void submitRequestData() {

        StringRequest stringRequest = new StringRequest(submitUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String result=jsonObject.getString("data");
                    Toast.makeText(RegisterActivity.this,result,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("submitData Error", ""+error);

            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
