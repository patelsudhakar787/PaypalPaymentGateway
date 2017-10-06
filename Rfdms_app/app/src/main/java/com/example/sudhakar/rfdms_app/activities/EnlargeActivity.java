package com.example.sudhakar.rfdms_app.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhakar.rfdms_app.R;
import com.example.sudhakar.rfdms_app.api.ClearGraphData;
import com.example.sudhakar.rfdms_app.api.SetTimeFormat;
import com.example.sudhakar.rfdms_app.fragment.AnalayticFragment;
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

public class EnlargeActivity extends AppCompatActivity {

    private LineChart lineChart;
    private LineDataSet dataset;
    private LineData data;
    private EditText etcurrentvalue;
    private TextView tvcvalue;
    private TextView textvtoday;
    private TextView textyesterday;
    private TextView textvcustomdate;
    private ArrayList<String> arraylisttime;
    private ArrayList<Float>arraylistgraphdata;
    private ArrayList<Entry>arraylistentry;
    private String channel="";
    private String channeldata=null;
    private SharedPreferences sharedPreferences;
    private String sensor="";
    private LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enlarge);
        linearLayout=(LinearLayout)findViewById(R.id.linear);
        lineChart = (LineChart)findViewById(R.id.chart);
        tvcvalue=(TextView)findViewById(R.id.current_value);
        textvtoday = (TextView) findViewById(R.id.tvtoday);
        textyesterday = (TextView) findViewById(R.id.tvyesterday);
        textvcustomdate = (TextView) findViewById(R.id.tvcustomdate);
        etcurrentvalue=(EditText)findViewById(R.id.edittextvalue);
        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arraylistgraphdata=new ArrayList<>();

        //
        sharedPreferences=this.getSharedPreferences("ch",MODE_PRIVATE);


        //getting data from intent
        Intent intent=getIntent();
        channel=intent.getStringExtra("channel");
        Toast.makeText(EnlargeActivity.this,"ChannelName"+channel,Toast.LENGTH_LONG).show();


        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("chs",channel);
        editor.commit();



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
                        dataset = null;
                        data = null;
                    }

                });
            }
        };//end of timer task
        timer.schedule(task, 0, 5 * 60 * 1000); //calling schduler function to schdule the time interval







        //click Listeners on TexViews
        textvtoday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lineChart.setVisibility(View.GONE);
                etcurrentvalue.setVisibility(View.GONE);
                tvcvalue.setVisibility(View.GONE);
                loadingFragment();
            }
        });

        textyesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineChart.setVisibility(View.GONE);
                etcurrentvalue.setVisibility(View.GONE);
                tvcvalue.setVisibility(View.GONE);
                loadingFragment();
            }
        });

        textvcustomdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(EnlargeActivity.this);
                final DatePicker picker = new DatePicker(EnlargeActivity.this);
                picker.setCalendarViewShown(false);

                builder.setTitle("Create Year");
                builder.setView(picker);
                builder.setNegativeButton("Cancel", null);
                builder.setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        lineChart.setVisibility(View.GONE);
                        etcurrentvalue.setVisibility(View.GONE);
                        tvcvalue.setVisibility(View.GONE);
                        loadingFragment();

                    }
                });
                builder.show();
            }
        });
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
                            etcurrentvalue.setText(channeldata);
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


    public void loadingFragment()
    {
        AnalayticFragment analayticFragment=new AnalayticFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft= fragmentManager.beginTransaction();
        ft.replace(R.id.undertextview,analayticFragment);
        ft.commit();
    }



}