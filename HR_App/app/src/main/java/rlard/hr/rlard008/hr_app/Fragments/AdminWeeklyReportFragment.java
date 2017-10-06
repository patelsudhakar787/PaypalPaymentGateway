package rlard.hr.rlard008.hr_app.Fragments;


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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Pojo.AdminSaveData;
import rlard.hr.rlard008.hr_app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminWeeklyReportFragment extends Fragment {


    public AdminWeeklyReportFragment() {
        // Required empty public constructor
    }

    private TextView tvempname;
    private PieChart pieChart;
    private String weekyreporturl="";
    private SharedPreferences sharedPreferences;
    private ListView listview;

    ArrayList<Entry> yvalues;
    ArrayList<String> xVals;
    private ArrayList<AdminSaveData> arrayListsavedata;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_admin_report, container, false);

        listview=(ListView)itemview.findViewById(R.id.adminListview);
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

        weekyreporturl="http://139.59.78.52:8080/HR_Application/WeeklyReportServlet?table="+empname;

        getWeeklyReportRequest();

        return itemview;
    }

    public void getWeeklyReportRequest()
    {
        StringRequest stringRequest=new StringRequest(weekyreporturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonarray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    AdminSaveData adminsavedata;
                    for(int i=0;i<jsonarray.length();i++)
                    {
                        jsonObject1=jsonarray.getJSONObject(i);
                        String rolename=jsonObject1.getString("role");
                        int time=Integer.parseInt(jsonObject1.getString("time"));
                        // float pertime= (float) (time/4.80);
                        adminsavedata=new AdminSaveData(rolename,time);
                        arrayListsavedata.add(adminsavedata);

                        yvalues.add(new Entry(time, i));
                        xVals.add("Role"+(i+1));
                    }
                    Log.e("arraylist",""+arrayListsavedata);


                    Log.e("yvalues",""+yvalues);
                    PieDataSet dataSet = new PieDataSet(yvalues, "Weekly Report");


                    PieData data = new PieData(xVals, dataSet);


                    //data.setValueFormatter(new PercentFormatter());
                    data.setValueTextSize(13f);
                    data.setValueTextColor(Color.DKGRAY);
                    dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
                    pieChart.setDrawHoleEnabled(false);

                    pieChart.setData(data);

                    ListViewAdapter adapter = new ListViewAdapter();
                    listview.setAdapter(adapter);
                    // }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
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
            textViewtaskname.setText("Role"+(position+1)+":"+saveData.getTaskname());
            textViewtimetaken.setText(""+saveData.getTimetaken()+" Minutes");

            return itemview;
        }
    }

}
