package com.example.rlard008.hr_app.Fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.hr_app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateRolesFragment extends Fragment {


    EditText editTextrole1;
    EditText editTextrole2;
    EditText editTextrole3;
    EditText editTextrole4;
    EditText editTextrole5;
    EditText editTextrole6;
    EditText editTextrole7;
    EditText editTextrole8;
    EditText editTextrole9;
    EditText editTextrole10;
    EditText editTextrole11;
    EditText editTextrole12;
    EditText editTextrole13;
    EditText editTextrole14;
    EditText editTextrole15;
    EditText editTextrole16;

    String role1="";
    String role2="";
    String role3="";
    String role4="";
    String role5="";
    String role6="";
    String role7="";
    String role8="";
    String role9="";
    String role10="";
    String role11="";
    String role12="";
    String role13="";
    String role14="";
    String role15="";
    String role16="";

    Button buttonSubmit;


    String updateurl="";
    String empid="";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_update_roles,container,false);

        editTextrole1 = (EditText) itemview.findViewById(R.id.etrole1);
        editTextrole2 = (EditText) itemview.findViewById(R.id.etrole2);
        editTextrole3 = (EditText) itemview.findViewById(R.id.etrole3);
        editTextrole4 = (EditText) itemview.findViewById(R.id.etrole4);
        editTextrole5 = (EditText) itemview.findViewById(R.id.etrole5);
        editTextrole6 = (EditText) itemview.findViewById(R.id.etrole6);
        editTextrole7 = (EditText) itemview.findViewById(R.id.etrole7);
        editTextrole8 = (EditText) itemview.findViewById(R.id.etrole8);
        editTextrole9 = (EditText) itemview.findViewById(R.id.etrole9);
        editTextrole10 = (EditText) itemview.findViewById(R.id.etrole10);
        editTextrole11 = (EditText) itemview.findViewById(R.id.etrole11);
        editTextrole12 = (EditText) itemview.findViewById(R.id.etrole12);
        editTextrole13 = (EditText) itemview.findViewById(R.id.etrole13);
        editTextrole14 = (EditText) itemview.findViewById(R.id.etrole14);
        editTextrole15 = (EditText) itemview.findViewById(R.id.etrole15);
        editTextrole16 = (EditText) itemview.findViewById(R.id.etrole16);
        buttonSubmit = (Button) itemview.findViewById(R.id.updateSubmit);

        SharedPreferences sharedPreferences1 = getContext().getSharedPreferences("data",MODE_PRIVATE);
        empid = sharedPreferences1.getString("empId","");

        sendRequest();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                role1=editTextrole1.getText().toString();
                role1=role1.replace(" ","");
                role2=editTextrole2.getText().toString();
                role2=role2.replace(" ","");
                role3=editTextrole3.getText().toString();
                role3=role3.replace(" ","");
                role4=editTextrole4.getText().toString();
                role4=role4.replace(" ","");
                role5=editTextrole5.getText().toString();
                role5=role5.replace(" ","");
                role6=editTextrole6.getText().toString();
                role6=role6.replace(" ","");
                role7=editTextrole7.getText().toString();
                role7=role7.replace(" ","");
                role8=editTextrole8.getText().toString();
                role8=role8.replace(" ","");
                role9=editTextrole9.getText().toString();
                role9=role9.replace(" ","");
                role10=editTextrole10.getText().toString();
                role10=role10.replace(" ","");
                role11=editTextrole11.getText().toString();
                role11=role11.replace(" ","");
                role12=editTextrole12.getText().toString();
                role12=role12.replace(" ","");
                role13=editTextrole13.getText().toString();
                role13=role13.replace(" ","");
                role14=editTextrole14.getText().toString();
                role14=role14.replace(" ","");
                role15=editTextrole15.getText().toString();
                role15=role15.replace(" ","");
                role16=editTextrole16.getText().toString();
                role16=role16.replace(" ","");
        updateurl="http://139.59.78.52:8080/HR_Application/Update_Employee_Roles?empid="+empid+"&role1="+role1+"&role2="+role2+"&role3="+role3+"&role4="+role4+"&role5="+role5+"&role6="+role6+"&role7="+role7+"&role8="+role8+"&role9="+role9+"&role10="+role10+"&role11="+role11+"&role12="+role12+"&role13="+role13+"&role14="+role14+"&role15="+role15+"&role16="+role16;

                updateRequest();
            }
        });

        return itemview;


    }


    void updateRequest() {

        StringRequest jsonObjectRequest = new StringRequest(updateurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String result=jsonObject.getString("data");
                    Toast.makeText(getContext(),""+result,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //Toast.makeText(SettingActivity.this,"Inserted",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Update Error", ""+error);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);



    }

    //sending request
    public void sendRequest() {

        SharedPreferences sharedPreferences1 =getContext().getSharedPreferences("data",MODE_PRIVATE);

        String empID = sharedPreferences1.getString("empId","");

        Log.e("mainAct_EmpID",""+empID);

        String requesturl = "http://139.59.78.52:8080/HR_Application/SelectRoleServlet?empid="+empID;//+13;
        Log.e("mainAct_requesturl",""+requesturl);
        StringRequest stringRequest = new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    role1 = jsonObject1.getString("role1");
                    if(role1.isEmpty())
                    {
                        role1="Not Defined";
                    }
                    role1.replace(" ","_");
                    role2 = jsonObject1.getString("role2");
                    if(role2.isEmpty())
                    {
                        role2="Not Defined";
                    }
                    role2.replace(" ","_");
                    role3 = jsonObject1.getString("role3");
                    if(role3.isEmpty())
                    {
                        role3="Not Defined";
                    }
                    role3.replace(" ","_");
                    role4 = jsonObject1.getString("role4");
                    if(role4.isEmpty())
                    {
                        role4="Not Defined";
                    }
                    role4.replace(" ","_");
                    role5 = jsonObject1.getString("role5");
                    if(role5.isEmpty())
                    {
                        role5="Not Defined";
                    }
                    role5.replace(" ","_");
                    role6 = jsonObject1.getString("role6");

                    if(role6.isEmpty())
                    {
                        role6="Not Defined";
                    }
                    role6.replace(" ","_");
                    role7 = jsonObject1.getString("role7");
                    if(role7.isEmpty())
                    {
                        role7="Not Defined";
                    }
                    role7.replace(" ","_");
                    role8 = jsonObject1.getString("role8");
                    if(role8.isEmpty())
                    {
                        role8="Not Defined";
                    }
                    role8.replace(" ","_");
                    // role9 = jsonObject1.getString("role9");
                    role10 = jsonObject1.getString("role10");
                    if(role10.isEmpty())
                    {
                        role10="Not Defined";
                    }
                    role10.replace(" ","_");
                    role11 = jsonObject1.getString("role11");
                    if(role11.isEmpty())
                    {
                        role11="Not Defined";
                    }
                    role11.replace(" ","_");
                    role12 = jsonObject1.getString("role12");
                    if(role12.isEmpty())
                    {
                        role12="Not Defined";
                    }
                    role12.replace(" ","_");
                    role13 = jsonObject1.getString("role13");
                    if(role13.isEmpty())
                    {
                        role13="Not Defined";
                    }
                    role13.replace(" ","_");
                    role14 = jsonObject1.getString("role14");
                    if(role14.isEmpty())
                    {
                        role14="Not Defined";
                    }
                    role14.replace(" ","_");
                    role15 = jsonObject1.getString("role15");
                    if(role15.isEmpty())
                    {
                        role15="Not Defined";
                    }
                    role15.replace(" ","_");
                    // role16 = jsonObject1.getString("role16");



                    if(role16.isEmpty())
                    {
                        role16="Not Defined";
                    }
                    editTextrole1.setText(""+role1);
                    editTextrole2.setText(""+role2);

                    editTextrole3.setText(""+role3);

                    editTextrole4.setText(""+role4);

                    editTextrole5.setText(""+role5);

                    editTextrole6.setText(""+role6);
                    editTextrole7.setText(""+role7);
                    editTextrole8.setText(""+role8);
                    editTextrole9.setText(""+role9);
                    editTextrole10.setText(""+role10);
                    editTextrole11.setText(""+role11);
                    editTextrole12.setText(""+role12);
                    editTextrole13.setText(""+role13);
                    editTextrole14.setText(""+role14);
                    editTextrole15.setText(""+role15);
                    editTextrole16.setText(""+role16);




                    Log.e("Role1",""+role1);
                    Log.e("Role2",""+role2);
                    Log.e("Role3",""+role3);
                    Log.e("Role4",""+role4);
                    Log.e("Role5",""+role5);
                    Log.e("Role6",""+role6);
                    Log.e("Role7",""+role7);



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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}
