package com.example.sudhakar.mentormentee;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{
    EditText editTextempid;
    EditText editTextempfname;
    EditText editTextemplname;
    EditText editTextempemailid;
    EditText editTextemppassword;
    String registrationurl="";
    String regtokenurl="";
    String token="";
    String empid="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editTextempid=(EditText)findViewById(R.id.employeeid);
        editTextempfname=(EditText)findViewById(R.id.empfirstname);
        editTextemplname=(EditText)findViewById(R.id.emplastname);
        editTextempemailid=(EditText)findViewById(R.id.empemailid);
        editTextemppassword=(EditText)findViewById(R.id.emppassword);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_register:
                 empRegistration();
                 token= FirebaseInstanceId.getInstance().getToken();
                 inserttoken();
                 break;
        }
    }


    public void empRegistration()
    {
         empid=editTextempid.getText().toString();
         String empfname=editTextempfname.getText().toString();
         String emplname=editTextemplname.getText().toString();
         String empemailid=editTextempemailid.getText().toString();
         String password=editTextemppassword.getText().toString();
         registrationurl="http://10.10.0.219:7070/MentorMentee/RegistrationServlet?eid="+empid+"&efname="+empfname+"&elname="+emplname+"&eemailid="+empemailid+"&emppassword="+password;
         sendRequest();
    }

    //request for data registration
    public void sendRequest()
    {
        StringRequest stringRequest=new StringRequest(registrationurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String status=jsonObject.getString("status");
                    Toast.makeText(RegistrationActivity.this,""+status,Toast.LENGTH_LONG).show();
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


    public void inserttoken()
    {


        regtokenurl="http://10.10.0.219:7070/MentorMentee/TokenRegistrationServlet?eid="+empid+"&tokenid="+token;
        tokenregrequest();

    }

    public void tokenregrequest()
    {
        StringRequest stringRequest=new StringRequest(regtokenurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String status=jsonObject.getString("status");
                    Toast.makeText(RegistrationActivity.this,""+status,Toast.LENGTH_LONG).show();
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
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}
