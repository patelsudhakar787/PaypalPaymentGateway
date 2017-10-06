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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.hr_app.Pojo.AdminSaveData;
import com.example.rlard008.hr_app.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminDailyReportFragment extends Fragment {


    public AdminDailyReportFragment() {
        // Required empty public constructor
    }

    private TextView tvempname;
    private PieChart pieChart;
    private String dailyreporturl="";
    private SharedPreferences sharedPreferences;
    private ListView listView;

    ArrayList<Entry> yvalues;
    ArrayList<String> xVals;
    private ArrayList<AdminSaveData> arrayListsavedata;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.fragment_admin_report, container, false);

        listView=(ListView)itemview.findViewById(R.id.adminListview);
        tvempname=(TextView)itemview.findViewById(R.id.tvAdminEmpname);
        pieChart=(PieChart)itemview.findViewById(R.id.admin_pie_chart);


        yvalues = new ArrayList<Entry>();
        xVals = new ArrayList<String>();
        arrayListsavedata=new ArrayList<>();

        //shared Preferences
        sharedPreferences=getContext().getSharedPreferences("AdminData", Context.MODE_PRIVATE);
        String empname=sharedPreferences.getString("empName","");
        tvempname.setText(empname);
        empname=empname.replace(" ","");

        Log.e("admin empname",""+empname);

        dailyreporturl="http://139.59.78.52:8080/HR_Application/DailyReportServlet?table="+empname;

        getDailyReportRequest();

        return itemview;
    }


    public void getDailyReportRequest()
    {
        StringRequest stringRequest=new StringRequest(dailyreporturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("reposnse",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;

                    for(int i=0;i<jsonArray.length();i++)
                    {

                        jsonObject1=jsonArray.getJSONObject(i);
                        int totlatime=Integer.parseInt(jsonObject1.getString("time"));
                        String taskname=jsonObject1.getString("role");
                        // float pertime= Math.round(totlatime/4.80);

                        Log.e("taskname",""+taskname);
                        Log.e("total time",""+totlatime);
                        arrayListsavedata.add(new AdminSaveData(taskname,totlatime));

                        yvalues.add(new Entry(totlatime, i));
                        xVals.add("Task"+(i+1));
                    }



                    Log.e("arraylistsavedata", "" + arrayListsavedata);



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

    //listView adapter
    class ListViewAdapter extends ArrayAdapter<AdminSaveData>
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

            AdminSaveData saveData=arrayListsavedata.get(position);
            textViewtaskname.setText("Task"+(position+1)+":"+saveData.getTaskname());
            textViewtimetaken.setText(""+saveData.getTimetaken()+" Minutes");



            return itemview;
        }
    }

}
