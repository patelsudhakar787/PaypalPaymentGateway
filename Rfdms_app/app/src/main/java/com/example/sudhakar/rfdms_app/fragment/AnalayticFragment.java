package com.example.sudhakar.rfdms_app.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sudhakar.rfdms_app.R;
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
 * Created by sudhakar on 7/5/17.
 */

public class AnalayticFragment extends Fragment {

    private LineChart lineChart;
    private LineDataSet dataset;
    private LineData data;
    private TextView textViewChannelName;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String current=null;

    private SharedPreferences sharedPreferences;
    private String channel="";
    private String channeldata=null;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView=inflater.inflate(R.layout.fragment_analytic,container,false);
        lineChart = (LineChart)itemView.findViewById(R.id.chart);
        textViewChannelName=(TextView)itemView.findViewById(R.id.textviewchannel);

        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();


        //
        sharedPreferences=getContext().getSharedPreferences("ch", Context.MODE_PRIVATE);
        channel=sharedPreferences.getString("chs","");
        textViewChannelName.setText(channel);



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


        return itemView;
    }



    public void getRequest() {

        Call<MyPojo> response=service.getThingSpeak24Data();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                if(response.isSuccessful()) {
                    ArrayList<Feeds> feeds = response.body().getFeeds();
                    Log.e("feeds", "" + feeds);
                    Feeds feeds1;
                    for (int i = 0; i < feeds.size(); i++) {
                        feeds1 = feeds.get(i);

                        if(channel.equals("Current")) {
                            channeldata = feeds1.getField2();
                        }
                        if(channel.equals("Voltage")) {
                            channeldata = feeds1.getField1();

                        }
                        if(channel.equals("Power")) {
                            channeldata = feeds1.getField3();

                        }
                        if(channel.equals("PowerFactor")) {
                            channeldata = feeds1.getField4();

                        }
                        if (channeldata != null) {
                            arraylistgraphdata.add(Float.parseFloat(channeldata));
                            String created_time = feeds1.getCreated_at();
                            String time = SetTimeFormat.setTimeFormat(created_time);
                            arraylisttime.add(time);
                            Log.e("Time", "" + time);
                        }
                    }
                }


            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("PowerFactorError",""+t);
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
        dataset=new LineDataSet(arraylistentry,"On X axis:TimeStamp \n On y axis:"+channel);
        data=new LineData(arraylisttime,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        lineChart.setData(data);
        lineChart.animateY(2000);
    }




}
