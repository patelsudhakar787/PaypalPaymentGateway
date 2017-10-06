package com.example.rlard008.monitoringapp.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rlard008.monitoringapp.R;
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

import static com.example.rlard008.monitoringapp.codeandReason.Rejection.getRejection;

//Rejection and DownTime enlarge activity
public class RejectionDownTimeActivity extends AppCompatActivity {
    LineChart lineChart;
    LineDataSet dataset;
    LineData data;
    ArrayList<String>arraylisttime;
    ArrayList<Float>arraylistgraphdata;
    ArrayList<Entry>arraylistentry;
    String channel_name="";
    ArrayList<CodeReason>arraylistcodereason = null;
    String fielddata=null;
    ArrayList<CodeReason> arrayListadapter;
    TextView textViewcode;
    TextView textViewreason;
    TextView textViewmsg;
    int count = 0;
    ListView listViewadapter;
    ProgressDialog dialog;
    ProductAdapter adapter;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context mContext = getApplicationContext();
        setContentView(R.layout.activity_rejectiondowntime);
        lineChart = (LineChart) findViewById(R.id.chart);
        textViewcode=(TextView)findViewById(R.id.textviewcode);
        textViewreason=(TextView)findViewById(R.id.textviewreason);
        textViewmsg=(TextView)findViewById(R.id.textviewmsg);
        listViewadapter=(ListView)findViewById(R.id.listView);


        arraylistgraphdata = new ArrayList<>();
        arraylisttime = new ArrayList<>();
        arraylistentry = new ArrayList<>();
        arrayListadapter = new ArrayList<>();
        adapter=new ProductAdapter();
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading Data On Graph...");
        dialog.setProgress(ProgressDialog.STYLE_SPINNER);
        dialog.show();

        Intent intent = getIntent();
        channel_name = intent.getStringExtra("channel");
        flag=intent.getIntExtra("flag",0);
        Log.e("flag",""+flag);


        if (channel_name.equals("RejectionCode")) {
            arraylistcodereason = getRejection();
            textViewmsg.setText("Rejected Product for last Hour");
            textViewcode.setText("RejectedProduct");
            textViewreason.setText("Reason");
        }
        if (channel_name.equals("DownTime")) {
            arraylistcodereason = DownTime.getDownTime();
            textViewcode.setText("DownTime");
            textViewreason.setText("Reason");
            textViewmsg.setText("Downtime for last Hour");

        }

        final Handler handler = new Handler();
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        count=0;

                        if (channel_name.equals("RejectionCode")) {

                            getRejectedRequest();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(flag==1) {
                                        RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                                    }
                                    Log.e("in","handler");

                                }
                            },2000);

                        }
                        if (channel_name.equals("DownTime")) {

                            getDowntime();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    if(flag==1) {
                                        RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                                    }

                                }
                            },2000);


                        }

                        Log.e("out","handler");
                        RefreshGraph.clearData(arraylistgraphdata,arraylisttime,arraylistentry);
                        RefreshGraph.clearAdapter(arrayListadapter);
                        dataset=null;
                        data=null;
                        flag=0;


                    }

                });
            }
        };//end of timer task
        timer.schedule(task, 0, 5*60*1000); //calling schduler f
    }




    //On BackPressed Method
    @Override
    public void onBackPressed() {
        arraylisttime = null;
        arraylistgraphdata = null;
        arraylistentry=null;
        arrayListadapter=null;
        super.onBackPressed();
    }







    public void getRejectedRequest()  {

        Call<MyPojo> response=service.get20RandDdata();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> feeds = response.body().getFeeds();

                    Feeds f;
                    for (int i = 0; i < feeds.size(); i++) {
                        f = feeds.get(i);
                        if(channel_name.equals("RejectionCode"))
                        {

                            fielddata = f.getField7();

                            if(fielddata !=null)
                            {
                                flag=1;
                                float data=Float.parseFloat(fielddata);
                                arraylistgraphdata.add(data);
                                String actualtime=f.getCreated_at();
                                String actual_time=SetTimeFormat.setTimeFormat(actualtime);
                                arraylisttime.add(actual_time);
                                for(CodeReason codeReason:arraylistcodereason)
                                {
                                    if(codeReason.getCode().equals(fielddata))
                                    {
                                        arrayListadapter.add(new CodeReason("Product:"+ ++count,codeReason.getReason()));
                                    }
                                }
                            }



                        }


                    }
                    Log.e("ArrayListFieldData",""+arraylistgraphdata);
                    Log.e("ArrayListTime",""+arraylisttime);
                    if(arraylistgraphdata.size()==0) {
                        dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
                        dialog.setMessage("Nothing to Show Try After Some Time \n Press back Two Times");
                    }
                    else {
                        dialog.cancel();
                    }
                    listViewadapter.setAdapter(adapter);
                }
                catch (Exception e)
                {
                    Log.e("RejectionExcep",""+e);
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("RejectionError",""+t);
                dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMessage("Please Go Back and try Again!!!!");

            }
        });
    }

    public void getDowntime()
    {

        Call<MyPojo> response=service.get20RandDdata();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> feeds = response.body().getFeeds();

                    Feeds f;
                    for (int i = 0; i < feeds.size(); i++) {
                        f = feeds.get(i);
                        if(channel_name.equals("DownTime"))
                        {

                            fielddata = f.getField8();
                            if(fielddata != null)
                            {
                                flag=1;
                                float data=Float.parseFloat(fielddata);
                                arraylistgraphdata.add(data);
                                String actualtime=f.getCreated_at();
                                String actual_time=SetTimeFormat.setTimeFormat(actualtime);
                                arraylisttime.add(actual_time);
                                for(CodeReason codeReason:arraylistcodereason)
                                {
                                    if(codeReason.getCode().equals(fielddata))
                                    {
                                        arrayListadapter.add(new CodeReason(actual_time,codeReason.getReason()));
                                    }
                                }

                            }
                        }

                    }
                    Log.e("ArrayListFieldData",""+arraylistgraphdata);
                    Log.e("ArrayListTime",""+arraylisttime);
                    if(arraylistgraphdata.size()==0) {
                        dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
                        dialog.setMessage("Nothing to Show Try After Some Time \n Press back Two Times");
                    }
                    else {
                        dialog.cancel();
                    }
                    listViewadapter.setAdapter(adapter);
                }
                catch (Exception e)
                {
                    Log.e("RejectionExcep",""+e);
                    e.printStackTrace();                }

            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("RejectionError",""+t);
                dialog.setProgress(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMessage("Please Go Back and try Again!!!!");

            }
        });

    }
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thingspeak.com/channels/").addConverterFactory(GsonConverterFactory.create()).build();
    ApIInterface service = retrofit.create(ApIInterface.class);


    //setting customized Adapter
    class ProductAdapter extends ArrayAdapter<CodeReason> {

        public ProductAdapter() {
            super(RejectionDownTimeActivity.this,R.layout.rejectionlistview,arrayListadapter);

        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View itemView=inflater.inflate(R.layout.rejectionlistview,null);
            TextView textViewpname=(TextView)itemView.findViewById(R.id.productname);
            TextView textViewpreason=(TextView)itemView.findViewById(R.id.rejectionreason);
            CodeReason codeReason=arrayListadapter.get(position);
            textViewpname.setText(""+codeReason.getCode());
            textViewpreason.setText(""+codeReason.getReason());
            return itemView;
        }//eof getView
    } //eof Adapter
}


