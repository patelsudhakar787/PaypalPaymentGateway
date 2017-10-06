package com.petrolpump.rlard008.petrolpump;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.petrolpump.rlard008.petrolpump.pojo.AdminLoginData;
import com.petrolpump.rlard008.petrolpump.pojo.ManagerLoginData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText etlogin;
    private EditText etpassword;
    private Button btnlogin;

    RadioGroup radioGroup;
    RadioButton radioButtonAdmin, radioButtonmanager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferencesadmin;


    private String loginId = "";
    private String password = "";
    private static String loginurl = "";
    String radioData = "";
    private AdminLoginData adminLoginData=null;
    private ManagerLoginData managerLoginData=null;
    private ArrayList<String>alpumpname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etlogin = (EditText) findViewById(R.id.etloginid);
        etpassword = (EditText) findViewById(R.id.etpassword);
        btnlogin = (Button) findViewById(R.id.btn_login);

        sharedPreferences=getSharedPreferences("manager",MODE_PRIVATE);
        sharedPreferencesadmin=getSharedPreferences("admin",MODE_PRIVATE);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupLogin);
        radioButtonAdmin = (RadioButton) findViewById(R.id.radioAdmin);
        radioButtonmanager = (RadioButton) findViewById(R.id.radioManager);

        alpumpname=new ArrayList<>();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginId = etlogin.getText().toString();
                password = etpassword.getText().toString();

                getRadioData();

                if (radioData.equals("Admin")) {

                    loginurl = "http://10.10.0.220:8881/PatrolPump/AdminLogin?uname=" + loginId + "&pass=" + password;

                    sendAdminLoginRequest();
                }

                if (radioData.equals("Manager")) {

                    loginurl = "http://10.10.0.220:8881/PatrolPump/ManagerLogin?uname=" + loginId + "&pass=" + password;

                    sendManagerLoginRequest();
                }



            }
        });
    }


    void getRadioData() {

        int selected_id = radioGroup.getCheckedRadioButtonId();
        if (selected_id == R.id.radioAdmin) {

            radioData = "Admin";
        }

        if (selected_id == R.id.radioManager) {

            radioData = "Manager";
        }
    }

    public void sendAdminLoginRequest() {
        clearArray(alpumpname);
        StringRequest stringRequest = new StringRequest(loginurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


               Log.e("reponse",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    String adminname=jsonObject1.getString("adminuname");
                    String admincontact=jsonObject1.getString("admincontact");
                    String adminpass=jsonObject1.getString("adminpassword");
                    String pump1=jsonObject1.getString("m1pname");
                    String pump2=jsonObject1.getString("m2pname");
                    String pump3=jsonObject1.getString("m3pname");
                    String pump4=jsonObject1.getString("m4pname");
                    String pump5=jsonObject1.getString("m5pname");
                    String pump6=jsonObject1.getString("m6pname");
                    String pump7=jsonObject1.getString("m7pname");
                    alpumpname.add(pump1);
                    alpumpname.add(pump2);
                    alpumpname.add(pump3);
                    alpumpname.add(pump4);
                    alpumpname.add(pump5);
                    alpumpname.add(pump6);
                    alpumpname.add(pump7);
                    adminLoginData=new AdminLoginData(adminname,admincontact,adminpass,pump1,pump2,pump3,pump4,pump5,pump6,pump7);

                    SharedPreferences.Editor editor=sharedPreferencesadmin.edit();
                    editor.putString("auname",adminLoginData.getAdminname());
                    editor.commit();
                    if(loginId.equals(adminLoginData.getAdminname()) && password.equals(adminLoginData.getAdminpassword()))
                    {
                        Intent intent=new Intent(LoginActivity.this,AdminActivity.class);
                        intent.putStringArrayListExtra("al",alpumpname);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid UserName or Password",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("error", "" + error);

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void sendManagerLoginRequest()
    {
        StringRequest stringRequest = new StringRequest(loginurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("reponse",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONObject jsonObject1=jsonObject.getJSONObject("data");
                    String adminuname=jsonObject1.getString("adminuname");
                    String manageruname=jsonObject1.getString("muname");
                    String pumpname=jsonObject1.getString("pumpname");
                    String managercontact=jsonObject1.getString("mcontact");
                    String managerpassword=jsonObject1.getString("mpassword");

                    managerLoginData=new ManagerLoginData(adminuname,manageruname,pumpname,managercontact,managerpassword);

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("admin",adminuname);
                    editor.putString("pump",pumpname);
                    editor.putString("manager",manageruname);
                    editor.commit();
                    if(loginId.equals(managerLoginData.getMusername()) && password.equals(managerLoginData.getMpassword()))
                    {
                        Intent intent=new Intent(LoginActivity.this,MoneyActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid UserName or Password",Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("error", "" + error);

            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    public void clearArray(ArrayList<String>arrayList)
    {
        for(int i=0;i<arrayList.size();i++)
        {
            arrayList.clear();
        }
    }


}