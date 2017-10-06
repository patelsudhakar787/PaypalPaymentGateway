package com.example.sudhakar.rfdms_app.fragment;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sudhakar.rfdms_app.R;
import com.example.sudhakar.rfdms_app.activities.EnlargeActivity;
import com.example.sudhakar.rfdms_app.api.ClearGraphData;
import com.example.sudhakar.rfdms_app.api.SetTimeFormat;
import com.example.sudhakar.rfdms_app.retrofit.Feeds;
import com.example.sudhakar.rfdms_app.retrofit.MyPojo;
import com.example.sudhakar.rfdms_app.services.apiInterface;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sudhakar on 5/16/17.
 */

public class VoltageGraphFragment extends Fragment {

    private LineChart lineChart;
    private LineDataSet dataset;
    private LineData data;
    private TextView textViewChannelName;
    private ImageView imageView;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String voltage=null;
    private SharedPreferences sharedPreferences;
    private String clientId=null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView=inflater.inflate(R.layout.fragment_graph,container,false);
        lineChart = (LineChart)itemView.findViewById(R.id.chart);
        textViewChannelName=(TextView)itemView.findViewById(R.id.textviewchannel);
        imageView=(ImageView)itemView.findViewById(R.id.image);
        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();
        textViewChannelName.setText("Voltage");

        sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        clientId=sharedPreferences.getString("clientId","");



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
                                refresh();

                            }
                        },2000);
                        ClearGraphData.clearTime(arraylisttime);
                        ClearGraphData.clearGraphData(arraylistgraphdata);
                        ClearGraphData.clearEntry(arraylistentry);
                        dataset=null;
                        data=null;
                    }

                });
            }
        };//end of timer task
        timer.schedule(task, 0, 5*60 * 1000); //calling schduler function to schdule the time interval

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), EnlargeActivity.class);
                intent.putExtra("channel","Voltage");
                startActivity(intent);

            }
        });

        return itemView;
    }



    public void getRequest() {

        Call<MyPojo> response=service.getThingSpeakData();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                if(response.isSuccessful()) {
                    ArrayList<Feeds> feeds = response.body().getFeeds();
                    Log.e("feeds", "" + feeds);
                    Feeds feeds1;
                    for (int i = 0; i < feeds.size(); i++) {
                        feeds1 = feeds.get(i);

                        voltage = feeds1.getField1();
                        Log.e("voltage", "" + voltage);
                        if (voltage != null) {
                            arraylistgraphdata.add(Float.parseFloat(voltage));
                            String created_time = feeds1.getCreated_at();
                            String time = SetTimeFormat.setTimeFormat(created_time);
                            arraylisttime.add(time);
                            Log.e("Time", "" + time);
//                            if (Float.parseFloat(voltage) > 239f) {
//
//                            }
                        }
                    }
                  //  sendNotification();
                }

            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("VoltageError",""+t);
            }
        });
    }
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thingspeak.com/channels/").addConverterFactory(GsonConverterFactory.create()).build();
    apiInterface service = retrofit.create(apiInterface.class);


    public void refresh()
    {
        Log.e("RefilArrayListGraphdata",""+arraylistgraphdata);
        Log.e("RefilArrayListTime",""+arraylisttime);
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            arraylistentry.add(new Entry(arraylistgraphdata.get(i),i));
        }
        dataset=new LineDataSet(arraylistentry,"On X axis:TimeStamp \n On y axis:Voltage");
        data=new LineData(arraylisttime,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        lineChart.setData(data);
        lineChart.animateY(2000);
    }


//    public void sendNotification()
//    {
//        String message="Voltage_crosses_threshold";
//        String notificationurl="http://139.59.79.196:8080/RFDMS/SendGCMToUser?id="+clientId+"&msg="+message;
//        StringRequest stringRequest=new StringRequest(notificationurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("responseFcm",""+response);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("errorfcm",""+error);
//
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
//        requestQueue.add(stringRequest);
//
//
//    }
}
