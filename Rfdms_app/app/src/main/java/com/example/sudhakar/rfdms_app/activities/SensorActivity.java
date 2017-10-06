package com.example.sudhakar.rfdms_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.sudhakar.rfdms_app.R;
import com.example.sudhakar.rfdms_app.api.ClearGraphData;
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

public class SensorActivity extends AppCompatActivity {

    private LineChart lineChart;
    private LineDataSet dataset;
    private LineData data;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String channel="";
    private TextView textViewchname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        lineChart = (LineChart)findViewById(R.id.chart);
        textViewchname=(TextView)findViewById(R.id.textviewchannel);

        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();



        //getting data from intent
        Intent intent=getIntent();
        channel=intent.getStringExtra("channel");
        textViewchname.setText(channel);

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
        timer.schedule(task, 0, 1*60 * 1000); //calling schduler function to schdule the time interval


    }



    public void refresh()
    {
        Log.e("RefilArrayListGraphdata",""+arraylistgraphdata);
        Log.e("RefilArrayListTime",""+arraylisttime);
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            arraylistentry.add(new Entry(arraylistgraphdata.get(i),i));
        }
        dataset=new LineDataSet(arraylistentry,"On X axis:TimeStamp \n On y axis:"+channel);
        data=new LineData(arraylisttime,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        lineChart.setData(data);
        lineChart.animateY(2000);
    }





    public void getRequest() {

        Call<MyPojo> response=service.getThingSpeak1Data();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                if(response.isSuccessful()) {
                    Log.e("reponse", "" + response);
                    ArrayList<Feeds> feeds = response.body().getFeeds();
                    Log.e("feeds", "" + feeds);
                    Feeds feed;
                    for (int i = 0; i < feeds.size(); i++) {
                        feed = feeds.get(i);
                        arraylisttime.add(feed.getCreated_at());
                        if(channel.equals("Temperature Sensor"))
                        {
                        arraylistgraphdata.add(Float.parseFloat(feed.getField6()));
                        }
                        if(channel.equals("Humidity Sensor"))
                        {
                            arraylistgraphdata.add(Float.parseFloat(feed.getField5()));
                        }
                        if(channel.equals("Light Sensor"))
                        {
                            arraylistgraphdata.add(Float.parseFloat(feed.getField7()));
                        }
                        if(channel.equals("Door Sensor"))
                        {
                            arraylistgraphdata.add(Float.parseFloat(feed.getField8()));
                        }


                    }

                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("CurrentError",""+t);
            }
        });
    }
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thingspeak.com/channels/").addConverterFactory(GsonConverterFactory.create()).build();
    apiInterface service = retrofit.create(apiInterface.class);

}
