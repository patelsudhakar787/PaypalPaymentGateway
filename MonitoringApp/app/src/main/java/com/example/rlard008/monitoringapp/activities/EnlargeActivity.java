package com.example.rlard008.monitoringapp.activities;

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


//enlarge activity to show the data in largeView for rifiltime,injectiontime and cycletime and their listViews
public class EnlargeActivity extends AppCompatActivity {
    LineChart lineChart;
    LineDataSet dataset;
    LineData data;
    TextView textViewcode;
    TextView textViewreason;
    TextView textViewmsg;
    ArrayList<String> arraylisttime;
    ArrayList<Float>arraylistgraphdata;
    ArrayList<Entry>arraylistentry;
    String field1=null;
    String channel_name="";

    ListView listViewadapter;
    ArrayList<CodeReason> arrayListadapter;
    ProductAdapter adapter;
    static int flag3=0;
    int flag2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rejectiondowntime);
        lineChart=(LineChart)findViewById(R.id.chart);
        textViewcode=(TextView)findViewById(R.id.textviewcode);
        textViewreason=(TextView)findViewById(R.id.textviewreason);
        textViewmsg=(TextView)findViewById(R.id.textviewmsg);
        listViewadapter=(ListView)findViewById(R.id.listView);
        arraylistgraphdata=new ArrayList<>();
        arraylisttime=new ArrayList<>();
        arraylistentry=new ArrayList<>();
        arrayListadapter=new ArrayList<>();

        textViewcode.setText("Products");

        //getting data from refil,injection and cycle fragmants
        Intent intent = getIntent();
        channel_name = intent.getStringExtra("channel");  //getting channel name
        arraylistgraphdata=(ArrayList<Float>)intent.getSerializableExtra("val");  //getting value in arraylist graph data
        arraylisttime=(ArrayList<String>)intent.getSerializableExtra("min");
        flag2=intent.getIntExtra("flag",0);
        adapter=new ProductAdapter();
        Log.e("flag2",""+flag2);
        Log.e("channel_name",""+channel_name);



        if (channel_name.equals("RefilTime")) {
            textViewreason.setText("Refil_time");
            textViewcode.setText("Refil");
            textViewmsg.setText("Refil time for last hour");

            if(flag2==1)
            {
                setRifilAdapter();
                RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
            }

             }

        if (channel_name.equals("InjectionTime")) {

            textViewreason.setText("Injection_time");
            textViewmsg.setText("Injection time for last hour");
            if(flag2==1) {
              setInjectionAdapter();
                RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
            }
        }

        if (channel_name.equals("CycleTime")) {
            textViewreason.setText("Average_Cycletime");
            textViewmsg.setText("Average Cycle time for last hour");

            Log.e("flag",""+flag3);
               getCycleRequest();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                        }
                    },2000);



        }



            final Handler handler = new Handler();
            final Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {
                            RefreshGraph.clearData(arraylistgraphdata,arraylisttime,arraylistentry);
                            RefreshGraph.clearAdapter(arrayListadapter);
                            dataset = null;
                            data = null;
                            flag3=0;


                            if (channel_name.equals("RefilTime")) {

                                getRefilRequest();

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(flag3==1) {
                                            RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                                        }
                                        Log.e("in","handler");

                                    }
                                },2000);

                            }
                            if (channel_name.equals("InjectionTime")) {

                                getInjectionRequest();

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(flag3==1) {
                                            RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                                        }

                                    }
                                },2000);


                            }
                            if (channel_name.equals("CycleTime")) {


                                getCycleRequest();

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {

                                        if(flag3==1) {
                                            RefreshGraph.refresh(arraylistgraphdata,arraylisttime,arraylistentry,dataset,data,lineChart,channel_name);
                                        }
                                    }
                                },2000);


                            }
                            Log.e("out","handler");


                        }

                    });
                }
            };//end of timer task
            timer.schedule(task, 5*60*1000, 5*60*1000); //calling schduler f
        }


    public void getRefilRequest() {
        Call<MyPojo> response=service.getDataRefill();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> arrayListfeeds = response.body().getFeeds();
                    Feeds feeds;
                    for (int i = 0; i < arrayListfeeds.size(); i++) {
                        feeds = arrayListfeeds.get(i);
                        field1=feeds.getField1();
                        String created_at=feeds.getCreated_at();
                        if(field1 != null)
                        {
                            flag3=1;
                            float data=Float.parseFloat(field1);
                            arraylistgraphdata.add(data);
                            String actual_time=SetTimeFormat.setTimeFormat(created_at);
                            arraylisttime.add(actual_time);
                        }

                    }

                    setRifilAdapter();


                }
                catch (Exception e)
                {
                    Log.e("enlarge_R_Excep",""+e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("enlarge_R_Error",""+t);
            }
        });
    }

    public void getInjectionRequest() {
        Call<MyPojo> response=service.getDataInjuction();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> arrayListfeeds = response.body().getFeeds();
                    Feeds feeds;
                    for (int i = 0; i < arrayListfeeds.size(); i++) {
                        feeds = arrayListfeeds.get(i);
                        Log.e("Feeds",""+feeds);
                        field1=feeds.getField1();
                        Log.e("Injection",""+field1);
                        String created_at=feeds.getCreated_at();
                       // CodeReason codeReason;
                        if(field1 != null)
                        {
                            flag3=1;
                            float data=Float.parseFloat(field1);
                            arraylistgraphdata.add(data);
                            String actual_time=SetTimeFormat.setTimeFormat(created_at);
                            arraylisttime.add(actual_time);
                        }

                    }
                    setInjectionAdapter();
                }
                catch (Exception e)
                {
                    Log.e("enlarge_I_Excep",""+e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("enlarge_I_Error",""+t);
            }
        });
    }

    public void getCycleRequest() {
        Call<MyPojo> response=service.getCycle12Data();
        response.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, retrofit2.Response<MyPojo> response) {
                try {
                    ArrayList<Feeds> arrayListfeeds = response.body().getFeeds();
                    Feeds feeds;
                    for (int i = 0; i < arrayListfeeds.size(); i++) {
                        feeds = arrayListfeeds.get(i);
                        Log.e("Feeds",""+feeds);
                        field1=feeds.getField1();
                        String created_at=feeds.getCreated_at();
                        if(field1 != null)
                        {
                            flag3=1;
                            float data=Float.parseFloat(field1);
                            arraylistgraphdata.add(data);
                            String actual_time=SetTimeFormat.setTimeFormat(created_at);
                            arraylisttime.add(actual_time);
                        }

                    }
                    setCycleAdapter();
                }
                catch (Exception e)
                {
                    Log.e("Enlarge_C_Excep",""+e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {
                Log.e("Enlarge_C_Error",""+t);
            }
        });
    }


    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thingspeak.com/channels/").addConverterFactory(GsonConverterFactory.create()).build();
    ApIInterface service = retrofit.create(ApIInterface.class);




    //setting customized Adapter
    class ProductAdapter extends ArrayAdapter<CodeReason> {

        public ProductAdapter() {
            super(EnlargeActivity.this,R.layout.rejectionlistview,arrayListadapter);

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


    public void setInjectionAdapter()
    {
        int count=0;
        CodeReason codeReason;
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            String data=String.valueOf(arraylistgraphdata.get(i));
            codeReason=new CodeReason("Product:"+ ++count,data);
            arrayListadapter.add(codeReason);
        }
        listViewadapter.setAdapter(adapter);

    }
    public void setCycleAdapter()
    {
        CodeReason codeReason;
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            String data=String.valueOf(arraylistgraphdata.get(i));
            codeReason=new CodeReason("Avg_Cycletime",data);
            arrayListadapter.add(codeReason);
        }
        listViewadapter.setAdapter(adapter);

    }
    public void setRifilAdapter()
    {

        int count=0;
        CodeReason codeReason;
        for(int i=0;i<arraylistgraphdata.size();i++)
        {
            String data=String.valueOf(arraylistgraphdata.get(i));
            codeReason=new CodeReason("Rifil:"+ ++count,data);
            arrayListadapter.add(codeReason);
        }
        listViewadapter.setAdapter(adapter);

    }


    //On BackPressed Method
    @Override
    public void onBackPressed() {
        //making null to all arraylist
        arraylisttime = null;
        arraylistgraphdata = null;
        arraylistentry=null;
        arrayListadapter=null;
        super.onBackPressed();
    }
}
