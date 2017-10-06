package com.rlard.tubelighttestingrack.fragment;

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
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.rlard.tubelighttestingrack.R;
import com.rlard.tubelighttestingrack.pojo.ClearGraphData;
import com.rlard.tubelighttestingrack.pojo.SetTimeFormat;
import com.rlard.tubelighttestingrack.retrofit.Feeds;
import com.rlard.tubelighttestingrack.retrofit.MyPojo;
import com.rlard.tubelighttestingrack.services.apiInterface;

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

public class PowerGraphFragment extends Fragment {

    private LineChart lineChart;
    private LineDataSet dataset;
    private ImageView imageView;
    private LineData data;
    private TextView textViewChannelName;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String power=null;
    private TextView tvctime;
    private TextView tvcvalue;

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
        textViewChannelName.setText("Power");
        tvctime=(TextView)itemView.findViewById(R.id.tvtimevalue);
        tvcvalue=(TextView)itemView.findViewById(R.id.tvcvalue);

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
                                try {

                                    refresh();
                                }
                                catch (Exception e)
                                {
                                    Toast.makeText(getContext(),"Graph issue",Toast.LENGTH_LONG).show();
                                }

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
        timer.schedule(task, 0, 20 * 1000); //calling schduler function to schdule the time interval


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

                         power = feeds1.getField3();
                         Log.e("voltage", "" + power);
                         if (power != null) {
                             float pw=Float.parseFloat(power);
                             arraylistgraphdata.add(pw);
                             String created_time = feeds1.getCreated_at();
                             String time = SetTimeFormat.setTimeFormat(created_time);
                             arraylisttime.add(time);
                             Log.e("Time", "" + time);
                             tvctime.setText(time);
                             tvcvalue.setText(""+pw);
                         }
                     }
                 }


            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("PowerError",""+t);
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
        dataset=new LineDataSet(arraylistentry,"On X axis:TimeStamp \n On y axis:Power");
        data=new LineData(arraylisttime,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        lineChart.setData(data);
        lineChart.animateY(2000);
    }
}
