package com.rlard.tubelighttestingrack.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

public class CurrentGraphFragment extends Fragment {
    private LineChart lineChart;
    private LineDataSet dataset;
    private LineData data;
    private TextView textViewChannelName;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String current=null;
    private TextView tvtime;
    private TextView tvcvalue;
    private static String message="";


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView=inflater.inflate(R.layout.fragment_graph,container,false);
        lineChart = (LineChart)itemView.findViewById(R.id.chart);
        textViewChannelName=(TextView)itemView.findViewById(R.id.textviewchannel);
        tvtime=(TextView)itemView.findViewById(R.id.tvtimevalue);
        tvcvalue=(TextView)itemView.findViewById(R.id.tvcvalue);

        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();
        textViewChannelName.setText("Current");




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
                    Log.e("reponse", "" + response);
                    ArrayList<Feeds> feeds = response.body().getFeeds();
                    Log.e("feeds", "" + feeds);
                    Feeds feeds1;
                    for (int i = 0; i < feeds.size(); i++) {
                        feeds1 = feeds.get(i);


                        current = feeds1.getField2();

                        Log.e("voltage", "" + current);
                        if (current != null) {
                            float cu=Float.parseFloat(current);

                            //notidfication
//                            if(cu > 0.090)
//                            {
                                message="Stop Cycle Power inside the Rack is High";
                            message=message.replace(" ","");
                              //  sendNotification();
                         //   }
                            arraylistgraphdata.add(cu);
                            String created_time = feeds1.getCreated_at();
                            String time = SetTimeFormat.setTimeFormat(created_time);
                            arraylisttime.add(time);
                            tvtime.setText(time);
                            tvcvalue.setText(""+cu);
                            Log.e("Time", "" + time);
                        }
                        else
                        {
                            tvcvalue.setText("No Data");
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


    public void refresh()
    {
        Log.e("RefilArrayListGraphdata",""+arraylistgraphdata);
        Log.e("RefilArrayListTime",""+arraylisttime);
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            arraylistentry.add(new Entry(arraylistgraphdata.get(i),i));
        }
        dataset=new LineDataSet(arraylistentry,"On X axis:TimeStamp \n On y axis:Current");
        data=new LineData(arraylisttime,dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);
        lineChart.setData(data);
        lineChart.animateY(2000);
    }

    public void sendNotification()
    {
        String notificationurl="http://139.59.78.30:8080/TestingRack/NotificationServlet?id=test1&msg="+message;
        StringRequest stringRequest=new StringRequest(notificationurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response",""+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),"Server Error",Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}
