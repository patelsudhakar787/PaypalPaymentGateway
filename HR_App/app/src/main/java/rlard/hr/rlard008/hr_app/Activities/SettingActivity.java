package rlard.hr.rlard008.hr_app.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Api.Api;
import rlard.hr.rlard008.hr_app.R;

public class SettingActivity extends AppCompatActivity {

    LinearLayout linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6,linearLayout7,
        linearLayout8,linearLayout9,linearLayout10,linearLayout11,linearLayout12,linearLayout13,
        linearLayout14,linearLayout15,linearLayout16;

    Button buttonAdd,buttonSubmit;
    EditText editTextId,editTextDesignation,editTextRole1,editTextRole2,editTextRole3,editTextRole4
            ,editTextRole5,editTextRole6,editTextRole7,editTextRole8,editTextRole9,editTextRole10
            ,editTextRole11,editTextRole12,editTextRole13,editTextRole14,editTextRole15,editTextRole16;

    int press=1;
    String personName,personEmail,empId,empDesignation,empRole,empRole2,empRole3,empRole4,empRole5,empRole6,empRole7,
            empRole8,empRole9,empRole10,empRole11,empRole12,empRole13,empRole14,empRole15,empRole16=null;

    private boolean id=false;
    private String url;
    private ArrayList<String>alempid=null;
    private static int checkempid=1;

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
        linearLayout16 = (LinearLayout) findViewById(R.id.linear16);




        buttonAdd = (Button) findViewById(R.id.add_more);
        buttonSubmit = (Button) findViewById(R.id.Submit);

        editTextDesignation = (EditText) findViewById(R.id.emp_designation);
        editTextId = (EditText) findViewById(R.id.emp_id);
        editTextRole1 = (EditText) findViewById(R.id.emp_role);
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
        editTextRole16 = (EditText) findViewById(R.id.emp_role16);


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
        linearLayout16.setVisibility(View.GONE);


        SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

        alempid=new ArrayList<>();

        personName = sharedPreferences.getString("personName","");
        personEmail = sharedPreferences.getString("personEmail","");



        //calling request function
        sendRequest();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(press==16)
                {
                    Toast.makeText(SettingActivity.this,"You can enter only 16 roles",Toast.LENGTH_LONG).show();
                }

                if (press==15) {
                    linearLayout16.setVisibility(View.VISIBLE);
                    press =16;
                }
                if (press==14) {
                    linearLayout15.setVisibility(View.VISIBLE);
                    press =15;
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

                boolean network=isNetworkOnline();
                if(network ==true) {
                    getUserData();

                    if (TextUtils.isEmpty(empId)) {
                        editTextId.setError(getString(R.string.error_field_required));

                    } else if (TextUtils.isEmpty(empDesignation)) {
                        editTextDesignation.setError(getString(R.string.error_field_required));

                    } else {
                        if (id == false) {
                            editTextId.setError("Invalid EmployeeId");
                        } else {
                            saveUserData();

                            Intent intent = new Intent(SettingActivity.this, DrawerActivity.class);
                            startActivity(intent);

                        }
                    }
                }
                else{
                    Toast.makeText(SettingActivity.this,"Connection Problem",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    void getUserData() {


        personName = personName.replace(" ", "");

        Log.e("Ename", "" + personName);

        empId = editTextId.getText().toString();
        empId = empId.replace(" ", "");

        checkEmpId(empId);
        if (checkempid == 2) {
            editTextId.setError("Duplicate Entry");
            checkempid = 1;
        } else {
            id = Api.isInteger(empId);


            empDesignation = editTextDesignation.getText().toString();
            empDesignation = empDesignation.replace(" ", "");

            empRole = editTextRole1.getText().toString();
            empRole = empRole.replace(" ", "_");

            if (empRole == null) {
                empRole = "Not_Defined";
            }

            empRole2 = editTextRole2.getText().toString();
            empRole2 = empRole2.replace(" ", "_");
            if (empRole2 == null) {
                empRole2 = "Not_Defined";
            }


            empRole3 = editTextRole3.getText().toString();
            empRole3 = empRole3.replace(" ", "_");
            if (empRole3 == null) {
                empRole3 = "Not_Defined";
            }

            empRole4 = editTextRole4.getText().toString();
            empRole4 = empRole4.replace(" ", "_");
            if (empRole4 == null) {
                empRole4 = "Not_Defined";
            }

            empRole5 = editTextRole5.getText().toString();
            empRole5 = empRole5.replace(" ", "_");
            if (empRole5 == null) {
                empRole5 = "Not_Defined";
            }

            empRole6 = editTextRole6.getText().toString();
            empRole6 = empRole6.replace(" ", "_");
            if (empRole6 == null) {
                empRole6 = "Not_Defined";
            }


            empRole7 = editTextRole7.getText().toString();
            empRole7 = empRole7.replace(" ", "_");
            if (empRole7 == null) {
                empRole7 = "Not_Defined";
            }

            empRole8 = editTextRole8.getText().toString();
            empRole8 = empRole8.replace(" ", "_");
            if (empRole8 == null) {
                empRole8 = "Not_Defined";
            }


            empRole9 = editTextRole9.getText().toString();
            empRole9 = empRole9.replace(" ", "_");
            if (empRole9 == null) {
                empRole9 = "Not_Defined";
            }


            empRole10 = editTextRole10.getText().toString();
            empRole10 = empRole10.replace(" ", "_");
            if (empRole10 == null) {
                empRole10 = "Not_Defined";
            }


            empRole11 = editTextRole11.getText().toString();
            empRole11 = empRole11.replace(" ", "_");
            if (empRole11 == null) {
                empRole11 = "Not_Defined";
            }


            empRole12 = editTextRole12.getText().toString();
            empRole12 = empRole12.replace(" ", "_");
            if (empRole12 == null) {
                empRole12 = "Not_Defined";
            }


            empRole13 = editTextRole13.getText().toString();
            empRole13 = empRole13.replace(" ", "_");
            if (empRole13 == null) {
                empRole13 = "Not_Defined";
            }

            empRole14 = editTextRole14.getText().toString();
            empRole14 = empRole14.replace(" ", "_");
            if (empRole14 == null) {
                empRole14 = "Not_Defined";
            }

            empRole15 = editTextRole15.getText().toString();
            empRole15 = empRole15.replace(" ", "_");
            if (empRole15 == null) {
                empRole15 = "Not_Defined";
            }

            empRole16 = editTextRole15.getText().toString();
            empRole16 = empRole15.replace(" ", "_");
            if (empRole16 == null) {
                empRole16 = "Not_Defined";
            }

            SharedPreferences sharedPreferences1 = getSharedPreferences("data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences1.edit();

            editor.putString("empId", empId);
            editor.commit();


            url = "http://139.59.78.52:8080/HR_Application/SettingRegServlet?empid=" + empId + "&name=" + personName + "&email=" + personEmail +
                    "&designation=" + empDesignation + "&role1=" + empRole + "&role2=" + empRole2 + "&role3=" + empRole3 + "&role4=" + empRole4 +
                    "&role5=" + empRole5 + "&role6=" + empRole6 + "&role7=" + empRole7 + "&role8=" + empRole8 + "&role9=" + empRole9 + "&role10=" + empRole10
                    + "&role11=" + empRole11 + "&role12=" + empRole12 + "&role13=" + empRole13 + "&role14=" + empRole14 + "&role15=" + empRole15 + "&role16=" + empRole16;

            Log.e("Setting_url", "" + url);
        }
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

    public void sendRequest() {

        String requesturl = "http://139.59.78.52:8080/HR_Application/ValidateEmpServlet";
        Log.e("mainAct_requesturl",""+requesturl);
        StringRequest stringRequest = new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=null;

                    for(int i=0;i<jsonArray.length();i++)
                    {
                        jsonObject1=jsonArray.getJSONObject(i);
                        String empname=jsonObject1.getString("empid");
                        alempid.add(empname);
                    }




                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error_MainActivity", "" + error);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



public void checkEmpId(String empid)
{
    for(String emp:alempid)
    {
        if(emp.equals(empid))
        {
            checkempid=2;
            break;
        }
        else
        {
            checkempid=1;

        }
    }

}
    public boolean isNetworkOnline() {
        boolean status=false;
        try{
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getNetworkInfo(0);
            if (netInfo != null && netInfo.getState()==NetworkInfo.State.CONNECTED) {
                status= true;
            }else {
                netInfo = cm.getNetworkInfo(1);
                if(netInfo!=null && netInfo.getState()==NetworkInfo.State.CONNECTED)
                    status= true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return status;

    }

}
