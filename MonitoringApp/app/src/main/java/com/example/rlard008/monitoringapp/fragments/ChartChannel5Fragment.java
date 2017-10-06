package com.example.rlard008.monitoringapp.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.monitoringapp.R;
import com.example.rlard008.monitoringapp.activities.RejectionDownTimeActivity;
import com.example.rlard008.monitoringapp.api.RefreshGraph;
import com.example.rlard008.monitoringapp.api.SetTimeFormat;
import com.example.rlard008.monitoringapp.codeandReason.CodeReason;
import com.example.rlard008.monitoringapp.codeandReason.DownTime;
import com.example.rlard008.monitoringapp.interfaceretrofit.ApIInterface;
import com.example.rlard008.monitoringapp.pojo.Feeds;
import com.example.rlard008.monitoringapp.pojo.MyPojo;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;



//Fragment for DownTime in Realtime , it will show last one hour data
public class ChartChannel5Fragment extends Fragment {

    LineChart lineChart;
    LineDataSet dataset;
    LineData data;
    TextView textViewChannelName;
    Button buttonenlarge;
    ArrayList<String>arraylisttime;
    ArrayList<Float>arraylistgraphdata;
    ArrayList<Entry>arraylistentry;
    ArrayList<CodeReason>arraylistcodereason;
    String field1=null;
    String field8=null;
    String downtimeurl="";
    String clientId="";
   static int flag=0;
    String channel_name = "DownTime";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.layout_graph2, container, false);
        lineChart = (LineChart)itemView.findViewById(R.id.chart);
        textViewChannelName=(TextView)itemView.findViewById(R.id.textviewchannel);
        buttonenlarge=(Button)itemView.findViewById(R.id.btnenlarge);
        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();
        arraylistcodereason= DownTime.getDownTime();
        Log.e("codereason",""+arraylistcodereason);
        textViewChannelName.setText("Down_Time     ");


        SharedPreferences sf =getContext().getSharedPreferences("param",MODE_PRIVATE);
        clientId = sf.getString("clientId", "");



        final Handler handler = new Handler();
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {

                        getRequest();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                if(flag==1) {
                                    RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);

                                }


                            }
                        },2000);

                        RefreshGraph.clearData(arraylistgraphdata,arraylisttime,arraylistentry);
                        dataset=null;
                        data=null;
                        flag=0;

                    }

                });
            }
        };//end of timer task
        timer.schedule(task, 0, 5*60 * 1000); //calling schduler function to schdule the time interval

        buttonenlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent in = new Intent(getContext(), RejectionDownTimeActivity.class);
                in.putExtra("min", arraylisttime);
                in.putExtra("val", arraylistgraphdata);
                in.putExtra("channel",channel_name);
                startActivity(in);

            }
        });

        return itemView;
    }

    public void getRequest() {

        Call<MyPojo>response=service.getRejectedData();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> arrayListfeeds = response.body().getFeeds();
                    Feeds feeds;
                    for (int i = 0; i < arrayListfeeds.size(); i++) {
                        feeds = arrayListfeeds.get(i);
                        field1=feeds.getField5();
                        String created_at=feeds.getCreated_at();
                        if(field1 != null)
                        {
                            flag=1;
                            float data=Float.parseFloat(field1);
                            arraylistgraphdata.add(data);
                            String actual_time= SetTimeFormat.setTimeFormat(created_at);
                            arraylisttime.add(actual_time);

                        }
                         field8=feeds.getField8();
                        if(field8 !=null) {

                            Log.e("DownTime", "" + field8);
                            for (CodeReason check : arraylistcodereason) {
                                if (check.getCode().equals(field8)) {
                                    downtimeurl = "http://1-dot-vibescope-158106.appspot.com/SendGCMToUser?id=" + clientId + "&msg=" + check.getReason();
                                    sendNotificationRequest();

                                }
                            }
                        }

                    }
                    Log.e("DowntimeListGraphdata",""+arraylistgraphdata);
                    Log.e("downtimeListTime",""+arraylisttime);
                }
                catch (Exception e)
                {
                    Log.e("DownTimeExcep",""+e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("downTimeError",""+t);
            }
        });
    }

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thingspeak.com/channels/").addConverterFactory(GsonConverterFactory.create()).build();
    ApIInterface service = retrofit.create(ApIInterface.class);




//sending notification

    public void sendNotificationRequest()
    {
        StringRequest stringRequest=new StringRequest(downtimeurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("DowntimeNotification",response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("DT->NotificatioError",""+error);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }



}
