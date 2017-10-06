package com.example.sudhakar.mentormentee;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SchduleActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spin;
    private EditText editTextdate;
    private EditText editTextvenue;
    private EditText editTextpurpose;
    private TextView textViewpick;
    private TimePicker tpicker;
    private Button buttonclick;
    private String time="";
    private String schduleurl="";
    private ArrayAdapter<String>adapter;
    private ArrayList<String> arrayListData;
    String selectspinnerurl="";
    String empid="";
    String t_time="";
    String name="";
    String getnotiurl="";
    String message="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schdule2);
        spin=(Spinner)findViewById(R.id.dataspinner);
        editTextdate=(EditText)findViewById(R.id.edittextdate);
        editTextvenue=(EditText)findViewById(R.id.edittextvenue);
        editTextpurpose=(EditText)findViewById(R.id.edittextpurpose);
        textViewpick=(TextView)findViewById(R.id.timepick);
        tpicker=(TimePicker)findViewById(R.id.timepicker);
        buttonclick=(Button)findViewById(R.id.btn_click);
        arrayListData=new ArrayList<>();


        SharedPreferences sf =this.getSharedPreferences("param",MODE_PRIVATE);
        empid=sf.getString("empid","");

        //setting spinner
        setSpinner();




    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.edittextdate:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final DatePicker picker = new DatePicker(this);
                picker.setCalendarViewShown(false);

                builder.setTitle("Select Meeting Time");
                builder.setView(picker);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year = picker.getYear();
                        int month = picker.getMonth() + 1;
                        int day = picker.getDayOfMonth();
                        time=day+"/"+month+"/"+year;
                        editTextdate.setText(time);

                    }
                });
                builder.show();
                Toast.makeText(SchduleActivity.this,"Select Time",Toast.LENGTH_LONG).show();

                break;


            case R.id.btn_click:

                spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Log.e("pos",""+position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        Log.e("not","nothing");
                    }
                });

                //   name=arrayListData.get(pos);
                Log.e("name",""+name);

                Log.e("name",""+name);
                String AM_PM="";
                int hour=0;
                int minute=0;
                if(Build.VERSION.SDK_INT >=23) {
                    hour = tpicker.getHour();
                    minute=tpicker.getMinute();
                }
                if(hour>12){
                    AM_PM="PM";
                }
                else
                {
                    AM_PM="AM";
                }

                t_time=""+hour+":"+minute+""+AM_PM;
                textViewpick.setText(t_time);
                Log.e("time",""+time);
                schdule();
                getnotiurl="http://10.10.0.219:7070/MentorMentee/SendGCMToUser?eid="+name+"&msg="+message;
                Log.e("notiurl",""+getnotiurl);
                sendNotificationRequest();
                break;
        }
    }



    public void schdule()
    {

        try {

            String totaltime=time+"-"+t_time;
            String venue = editTextvenue.getText().toString();
            String purpose = editTextpurpose.getText().toString();

        schduleurl="http://10.10.0.219:7070/MentorMentee/SchduleServlet?eid="+empid+"&time="+totaltime+"&venue="+venue+"&purpose="+purpose+"&name="+name;
        Log.e("url",""+schduleurl);
        sendRequest();
            message="You_have_a_meeting_with-"+name+"On-"+totaltime;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendRequest()
    {
        StringRequest stringRequest=new StringRequest(schduleurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String status=jsonObject.getString("status");
                    Toast.makeText(SchduleActivity.this,""+status,Toast.LENGTH_LONG).show();
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

        public void setSpinner()
        {
            selectspinnerurl="http://10.10.0.219:7070/MentorMentee/SelectSpinnerServlet?eid="+empid;
            Log.e("url",""+selectspinnerurl);
            selectSpinnerRequest();
            adapter=new ArrayAdapter<String>(SchduleActivity.this,android.R.layout.simple_spinner_item, arrayListData);
            spin.setAdapter(adapter);

        }


        public void selectSpinnerRequest()
        {
            StringRequest stringRequest=new StringRequest(selectspinnerurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response",""+response);
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        JSONArray jsonArray=jsonObject.getJSONArray("data");
                        Log.e("arraylist",""+jsonArray);
                        JSONObject jsonObject1;
                        for(int i=0;i<jsonArray.length();i++)
                        {
                            jsonObject1=jsonArray.getJSONObject(i);
                            String empid=jsonObject1.getString("empid");
                          //  String empname=jsonObject1.getString("empname");
                        arrayListData.add(empid);
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
            RequestQueue requestQueue=Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }



        public void sendNotificationRequest()
        {
            StringRequest stringRequest=new StringRequest(getnotiurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response",""+response);

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
