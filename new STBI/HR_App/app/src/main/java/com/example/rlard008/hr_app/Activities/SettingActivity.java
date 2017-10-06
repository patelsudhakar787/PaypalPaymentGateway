package com.example.rlard008.hr_app.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.hr_app.R;

import org.json.JSONObject;

public class SettingActivity extends AppCompatActivity {

    LinearLayout linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,
        linearLayout8,linearLayout9,linearLayout10,linearLayout11,linearLayout12,linearLayout13,
        linearLayout14,linearLayout15;

    Button buttonAdd,buttonSubmit;
    EditText editTextId,editTextDesignation,editTextRole,editTextRole2,editTextRole3,editTextRole4
            ,editTextRole5,editTextRole6,editTextRole7,editTextRole8,editTextRole9,editTextRole10
            ,editTextRole11,editTextRole12,editTextRole13,editTextRole14,editTextRole15;

    int press=1;
    String personName,personEmail,empId,empDesignation,empRole,empRole2,empRole3,empRole4,empRole5,empRole6,empRole7,
            empRole8,empRole9,empRole10,empRole11,empRole12,empRole13,empRole14,empRole15=null;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        linearLayout2 = (LinearLayout) findViewById(R.id.linear2);
        linearLayout3 = (LinearLayout) findViewById(R.id.linear3);
        linearLayout4 = (LinearLayout) findViewById(R.id.linear4);
        linearLayout5 = (LinearLayout) findViewById(R.id.linear5);
        linearLayout6 = (LinearLayout) findViewById(R.id.linear6);
        linearLayout7 = (LinearLayout) findViewById(R.id.linear7);

        linearLayout8 = (LinearLayout) findViewById(R.id.linear8);
        linearLayout9 = (LinearLayout) findViewById(R.id.linear9);
        linearLayout10 = (LinearLayout) findViewById(R.id.linear10);
        linearLayout11 = (LinearLayout) findViewById(R.id.linear11);
        linearLayout12 = (LinearLayout) findViewById(R.id.linear12);
        linearLayout13 = (LinearLayout) findViewById(R.id.linear13);

        linearLayout14 = (LinearLayout) findViewById(R.id.linear14);
        linearLayout15 = (LinearLayout) findViewById(R.id.linear15);




        buttonAdd = (Button) findViewById(R.id.add_more);
        buttonSubmit = (Button) findViewById(R.id.Submit);

        editTextDesignation = (EditText) findViewById(R.id.emp_designation);
        editTextId = (EditText) findViewById(R.id.emp_id);
        editTextRole = (EditText) findViewById(R.id.emp_role);
        editTextRole2 = (EditText) findViewById(R.id.emp_role2);
        editTextRole3 = (EditText) findViewById(R.id.emp_role3);
        editTextRole4 = (EditText) findViewById(R.id.emp_role4);
        editTextRole5 = (EditText) findViewById(R.id.emp_role5);
        editTextRole6 = (EditText) findViewById(R.id.emp_role6);
        editTextRole7 = (EditText) findViewById(R.id.emp_role7);

        editTextRole8 = (EditText) findViewById(R.id.emp_role8);
        editTextRole9 = (EditText) findViewById(R.id.emp_role9);
        editTextRole10 = (EditText) findViewById(R.id.emp_role10);
        editTextRole11 = (EditText) findViewById(R.id.emp_role11);
        editTextRole12 = (EditText) findViewById(R.id.emp_role12);
        editTextRole13 = (EditText) findViewById(R.id.emp_role13);
        editTextRole14 = (EditText) findViewById(R.id.emp_role14);
        editTextRole15 = (EditText) findViewById(R.id.emp_role15);

        linearLayout2.setVisibility(View.GONE);
        linearLayout3.setVisibility(View.GONE);
        linearLayout4.setVisibility(View.GONE);
        linearLayout5.setVisibility(View.GONE);
        linearLayout6.setVisibility(View.GONE);
        linearLayout7.setVisibility(View.GONE);

        linearLayout8.setVisibility(View.GONE);
        linearLayout9.setVisibility(View.GONE);
        linearLayout10.setVisibility(View.GONE);
        linearLayout11.setVisibility(View.GONE);
        linearLayout12.setVisibility(View.GONE);
        linearLayout13.setVisibility(View.GONE);

        linearLayout14.setVisibility(View.GONE);
        linearLayout15.setVisibility(View.GONE);


        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);


        personName = sharedPreferences.getString("personName","");
        personEmail = sharedPreferences.getString("personEmail","");

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (press==15) {
//                    linearLayout16.setVisibility(View.VISIBLE);
//                //    press =9;
//                }
                if (press==14) {
                    linearLayout15.setVisibility(View.VISIBLE);
                    //press =15;
                }
                if (press==13) {
                    linearLayout14.setVisibility(View.VISIBLE);
                    press =14;
                }
                if (press==12) {
                    linearLayout13.setVisibility(View.VISIBLE);
                    press =13;
                }
                if (press==11) {
                    linearLayout12.setVisibility(View.VISIBLE);
                    press =12;
                }
                if (press==10) {
                    linearLayout11.setVisibility(View.VISIBLE);
                    press =11;
                }
                if (press==9) {
                    linearLayout10.setVisibility(View.VISIBLE);
                    press =10;
                }

                if (press==8) {
                    linearLayout9.setVisibility(View.VISIBLE);
                    press =9;
                }
                if (press==7) {
                    linearLayout8.setVisibility(View.VISIBLE);
                    press =8;
                }
                if (press==6) {
                    linearLayout7.setVisibility(View.VISIBLE);
                    press = 7;
                }
                if (press==5) {
                    linearLayout6.setVisibility(View.VISIBLE);
                    press = 6;
                }

                if (press==4) {
                    linearLayout5.setVisibility(View.VISIBLE);
                    press = 5;
                }
                if (press==3) {
                    linearLayout4.setVisibility(View.VISIBLE);
                    press=4;
                }
                if (press==2) {
                    linearLayout3.setVisibility(View.VISIBLE);
                    press = 3;
                }

                if (press==1) {
                    linearLayout2.setVisibility(View.VISIBLE);
                    press = 2;
                }

            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getUserData();

                if (TextUtils.isEmpty(empId)) {
                    editTextId.setError(getString(R.string.error_field_required));

                }
                else if (TextUtils.isEmpty(empDesignation)) {
                    editTextDesignation.setError(getString(R.string.error_field_required));

                }
                else {
                    saveUserData();

                    Intent intent = new Intent(SettingActivity.this, DrawerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    void getUserData() {


        personName = personName.replace(" ", "");

        Log.e("Ename", ""+personName);

        empId = editTextId.getText().toString();
        empDesignation = editTextDesignation.getText().toString();
        empRole = editTextRole.getText().toString();

        empDesignation = empDesignation.replace(" ", "");
        empRole = empRole.replace(" ", "_");
        empId = empId.replace(" ", "");


        empRole2 = editTextRole2.getText().toString();
        empRole2 = empRole2.replace(" ", "_");




        empRole3 = editTextRole3.getText().toString();
        empRole3 = empRole3.replace(" ", "_");


        empRole4 = editTextRole4.getText().toString();
        empRole4 = empRole4.replace(" ", "_");


        empRole5 = editTextRole5.getText().toString();
        empRole5 = empRole5.replace(" ", "_");


        empRole6 = editTextRole6.getText().toString();
        empRole6 = empRole6.replace(" ", "_");



        empRole7 = editTextRole7.getText().toString();
        empRole7 = empRole7.replace(" ", "_");


        empRole8 = editTextRole8.getText().toString();
        empRole8 = empRole8.replace(" ", "_");



        empRole9 = editTextRole9.getText().toString();
        empRole9 = empRole9.replace(" ", "_");




        empRole10 = editTextRole10.getText().toString();
        empRole10 = empRole10.replace(" ", "_");




        empRole11 = editTextRole11.getText().toString();
        empRole11 = empRole11.replace(" ", "_");



        empRole12 = editTextRole12.getText().toString();
        empRole12 = empRole12.replace(" ", "_");




        empRole13 = editTextRole13.getText().toString();
        empRole13 = empRole13.replace(" ", "_");

        empRole14 = editTextRole14.getText().toString();
        empRole14 = empRole14.replace(" ", "_");

        empRole15 = editTextRole15.getText().toString();
        empRole15 = empRole15.replace(" ", "_");

        SharedPreferences sharedPreferences1 = getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences1.edit();

        editor.putString("empId",empId);
        editor.commit();


        url = "http://139.59.78.52:8080/HR_Application/SettingRegServlet?empid="+empId+"&name="+personName+"&email="+personEmail+
                "&designation="+empDesignation+"&role1="+empRole+"&role2="+empRole2+"&role3="+empRole3+"&role4="+empRole4+
                "&role5="+empRole5+"&role6="+empRole6+"&role7="+empRole7+"&role8="+empRole9+"&role10="+empRole10
                +"&role11="+empRole11+"&role12="+empRole12+"&role13="+empRole13+"&role14="+empRole14+"&role15="+empRole15;

        Log.e("Setting_url", ""+url);
    }

    void saveUserData() {

        //Toast.makeText(SettingActivity.this," "+personName+" "+personEmail+" "+" "+empId+" "+empDesignation+" "+empRole,Toast.LENGTH_LONG).show();

       // Toast.makeText(SettingActivity.this," "+empRole2+" "+empRole3+" "+" "+empRole4+" "+empRole5+" "+empRole6+" "+empRole7,Toast.LENGTH_LONG).show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(SettingActivity.this,"Inserted",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Setting Error", ""+error);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);



    }

    @Override
    protected void onStart() {
        super.onStart();

        // Store our shared preference
        SharedPreferences sp = getSharedPreferences("OURINFO", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("active", "true");
        ed.commit();
    }


}
