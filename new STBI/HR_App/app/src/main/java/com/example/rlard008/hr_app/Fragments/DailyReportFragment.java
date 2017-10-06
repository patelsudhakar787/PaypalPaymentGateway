package com.example.rlard008.hr_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.hr_app.Pojo.SaveData;
import com.example.rlard008.hr_app.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
//import com.intrusoft.scatter.ChartData;
//import com.intrusoft.scatter.PieChart;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class DailyReportFragment extends Fragment {


    private TextView tvempname;
    private PieChart pieChart;
    private ListView listView;
    private String reporturl="";
   // private ArrayList<ChartData> arrayListchartData=null;
   // private ArrayList<Integer>arrayListcolor;
    private ArrayList<SaveData>arrayListsavedata=null;
    private SharedPreferences sharedPreferences;
   // private ScrollView scrollView;

    ArrayList<Entry> yvalues;
    ArrayList<String> xVals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.fragment_report,container,false);
        tvempname=(TextView)itemview.findViewById(R.id.tvempname);
        pieChart=(PieChart)itemview.findViewById(R.id.pie_chart);
        listView=(ListView)itemview.findViewById(R.id.listview);
     //   scrollView=(ScrollView)itemview.findViewById(R.id.sv);


//        arrayListchartData=new ArrayList<>();
//        arrayListcolor=new ArrayList<>();
        arrayListsavedata=new ArrayList<>();

        yvalues = new ArrayList<Entry>();
        xVals = new ArrayList<String>();

//        arrayListcolor.add(Color.parseColor("#0091EA"));
//        arrayListcolor.add(Color.parseColor("#6a1b9a"));
//        arrayListcolor.add(Color.parseColor("#c62828"));
//        arrayListcolor.add(Color.parseColor("#ffea00"));
//        arrayListcolor.add(Color.parseColor("#76ff03"));
//        arrayListcolor.add(Color.parseColor("#ff3d00"));




        //shared Preferences
        sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        String empname=sharedPreferences.getString("personName","");
        tvempname.setText("Hello, "+empname);
        empname=empname.replace(" ","");




        reporturl="http://139.59.78.52:8080/HR_Application/DailyReportServlet?table="+empname;
        Log.e("url",""+reporturl);
        getReportRequest();


        Log.e("arraylist",""+arrayListsavedata);
       // Log.e("arraylist_",""+arrayListchartData);


        return itemview;
    }

    //listView adapter
    class ListViewAdapter extends ArrayAdapter<SaveData>
    {

        public ListViewAdapter() {
            super(getActivity(),R.layout.reportlistview,arrayListsavedata);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View itemview=inflater.inflate(R.layout.reportlistview,parent,false);
            TextView textViewtaskname=(TextView)itemview.findViewById(R.id.taskname);
            TextView textViewtimetaken=(TextView)itemview.findViewById(R.id.timetaken);

            SaveData saveData=arrayListsavedata.get(position);
            textViewtaskname.setText("Task"+(position+1)+":"+saveData.getTaskname());
            textViewtimetaken.setText(""+saveData.getTimetaken()+" Minutes");



            return itemview;
        }
    }




    public void getReportRequest()
    {
        StringRequest stringRequest=new StringRequest(reporturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("reposnse",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    //int j=0;
                    for(int i=0;i<jsonArray.length();i++)
                    {
                       // j++;
                        jsonObject1=jsonArray.getJSONObject(i);
                        int totlatime=Integer.parseInt(jsonObject1.getString("time"));
                        String taskname=jsonObject1.getString("role");
                       // float pertime= Math.round(totlatime/4.80);

                        Log.e("taskname",""+taskname);
                        Log.e("total time",""+totlatime);
                        arrayListsavedata.add(new SaveData(taskname,totlatime));
//                        if(j==5)
//                        {
//                            j=0;
//                        }
                        //Log.e("pertime",""+pertime);
                     //   arrayListchartData.add(new ChartData("T"+(i+1),pertime, Color.WHITE,arrayListcolor.get(j)));//arrayListcolor.get(i)));//Color.parseColor("#0091EA")));

                        yvalues.add(new Entry(totlatime, i));
                        xVals.add("Task"+(i+1));
                    }



                        Log.e("arraylistsavedata", "" + arrayListsavedata);
                       // Log.e("arraylist", "" + arrayListchartData);
                    //setting data to the pieChart
                    //pieChart.setChartData(arrayListchartData);


                    Log.e("yvalues",""+yvalues);
                    PieDataSet dataSet = new PieDataSet(yvalues, "Daily Report");


                    PieData data = new PieData(xVals, dataSet);


                    //data.setValueFormatter(new PercentFormatter());
                    data.setValueTextSize(13f);
                    data.setValueTextColor(Color.DKGRAY);
                    dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
                    pieChart.setDrawHoleEnabled(false);

                    pieChart.setData(data);


                    //setting adpter
                    ListViewAdapter adapter = new ListViewAdapter();
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    Toast.makeText(getContext(),"connection problem",Toast.LENGTH_LONG).show();
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",""+error);
                Toast.makeText(getContext(),"connection problem",Toast.LENGTH_LONG).show();

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }
}
