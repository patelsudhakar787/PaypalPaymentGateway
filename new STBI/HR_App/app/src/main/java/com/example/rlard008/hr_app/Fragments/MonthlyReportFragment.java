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
import android.widget.TextView;

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
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MonthlyReportFragment extends Fragment {

    private TextView tvempname;
    private PieChart pieChart;
   // private ArrayList<ChartData> arrayListchartData;
    private String monthlyreporturl="";
    private SharedPreferences sharedPreferences;
    private ArrayList<SaveData>arrayListsavedata;
    private ListView listView;

    //private ArrayList<Integer>arrayListcolor;

    ArrayList<Entry> yvalues;
    ArrayList<String> xVals;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View itemview=inflater.inflate(R.layout.fragment_report,container,false);
        listView=(ListView)itemview.findViewById(R.id.listview);
        tvempname=(TextView)itemview.findViewById(R.id.tvempname);
        pieChart=(PieChart)itemview.findViewById(R.id.pie_chart);
        arrayListsavedata=new ArrayList<>();

        //shared Preferences
        sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
        String empname=sharedPreferences.getString("personName","");
        tvempname.setText("Hello, "+empname);
        empname=empname.replace(" ","");
        monthlyreporturl="http://139.59.78.52:8080/HR_Application/MonthlyReportServlet?table="+empname;

        yvalues = new ArrayList<Entry>();
        xVals = new ArrayList<String>();


//        arrayListcolor=new ArrayList<>();
//
//        arrayListcolor.add(Color.parseColor("#0091EA"));
//        arrayListcolor.add(Color.parseColor("#6a1b9a"));
//        arrayListcolor.add(Color.parseColor("#c62828"));
//        arrayListcolor.add(Color.parseColor("#ffea00"));
//        arrayListcolor.add(Color.parseColor("#76ff03"));
//        arrayListcolor.add(Color.parseColor("#ff3d00"));
//
//        arrayListchartData=new ArrayList<>();
        getMonthlyReportRequest();


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
            textViewtaskname.setText("Role"+(position+1)+":"+saveData.getTaskname());
            textViewtimetaken.setText(""+saveData.getTimetaken()+" Minutes");

            return itemview;
        }
    }

    public void getMonthlyReportRequest()
    {
        StringRequest stringRequest=new StringRequest(monthlyreporturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonarray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    SaveData savedata;
                    for(int i=0;i<jsonarray.length();i++)
                    {
                        jsonObject1=jsonarray.getJSONObject(i);
                        String rolename=jsonObject1.getString("role");
                        int time=Integer.parseInt(jsonObject1.getString("time"));
                        //float pertime= (float) (time/4.80);
                        savedata=new SaveData(rolename,time);
                        arrayListsavedata.add(savedata);
                       // arrayListchartData.add(new ChartData("Role"+(i+1)+",("+(Math.round(pertime*100)/100D)+" %)",pertime, Color.WHITE,Color.parseColor("#0091EA")));

                        yvalues.add(new Entry(time, i));
                        xVals.add("Role"+(i+1));

                    }
                    Log.e("arraylist",""+arrayListsavedata);

                       // pieChart.setChartData(arrayListchartData);

                    Log.e("yvalues",""+yvalues);
                    PieDataSet dataSet = new PieDataSet(yvalues, "Monthly Report");


                    PieData data = new PieData(xVals, dataSet);


                    //data.setValueFormatter(new PercentFormatter());
                    data.setValueTextSize(13f);
                    data.setValueTextColor(Color.DKGRAY);
                    dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
                    pieChart.setDrawHoleEnabled(false);

                    pieChart.setData(data);



                    ListViewAdapter adapter = new ListViewAdapter();
                    listView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


}
