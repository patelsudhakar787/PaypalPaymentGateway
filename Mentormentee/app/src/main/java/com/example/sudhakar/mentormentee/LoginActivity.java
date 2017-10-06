package com.example.sudhakar.mentormentee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.sudhakar.mentormentee.R.id.email;
import static com.example.sudhakar.mentormentee.R.id.login;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextemail;
    EditText editTextpassword;
    Button btnlogin;
    String loginurl="";
    String empid="";
    String updatetokenurl="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextemail=(EditText)findViewById(email);
        editTextpassword=(EditText)findViewById(R.id.password);
        btnlogin=(Button)findViewById(login);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case login:
                loginAuth();
                break;

            case R.id.register:
                Log.e("selected","1");
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                break;
        }

    }


         //function for login
    public void loginAuth()
    {
         empid = editTextemail.getText().toString();
        String password = editTextpassword.getText().toString();
        loginurl="http://10.10.0.219:7070/MentorMentee/LoginServlet?eid="+empid+"&pass="+password;
        sendRequest();
        String token= FirebaseInstanceId.getInstance().getToken();
        updatetokenurl="http://10.10.0.219:7070/MentorMentee/UpdateTokenServlet?eid="+empid+"&tokenid="+token;
    }


        //function for sending notification
    public void sendRequest()
    {
        StringRequest stringRequest=new StringRequest(loginurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String status=jsonObject.getString("status");
                    String name=jsonObject.getString("data");

                    if(status.equals("true"))
                    {
                        sendUpdateRequest();
                        SharedPreferences sp = getSharedPreferences("param", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("empid",empid);
                        editor.putString("name",name);
                        editor.commit();
                        Intent intent=new Intent(LoginActivity.this,SchduleListActivity.class);
                        startActivity(intent);
                        //do Intent
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



    public void sendUpdateRequest()
    {
        StringRequest stringRequest=new StringRequest(updatetokenurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String result=jsonObject.getString("data");
                    Toast.makeText(LoginActivity.this,""+result,Toast.LENGTH_LONG).show();
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
