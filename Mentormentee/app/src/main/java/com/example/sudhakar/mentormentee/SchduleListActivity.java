package com.example.sudhakar.mentormentee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sudhakar.mentormentee.adapter.SchduleListRecyclerView;
import com.example.sudhakar.mentormentee.pojo.MeetingInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SchduleListActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_schdule;
 //   private ListView listView;
    private RecyclerView rv;
    private ArrayList<MeetingInfo>arrayList=new ArrayList<>();
    private String selecturl="";
    private String empid="";
    private SchduleListRecyclerView adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schdule);
        btn_schdule=(Button)findViewById(R.id.btn_schdule);
        //listView=(ListView)findViewById(R.id.listview);
        rv=(RecyclerView)findViewById(R.id.recylerview);
// use a linear layout manager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);


        SharedPreferences sf =this.getSharedPreferences("param",MODE_PRIVATE);
        empid=sf.getString("empid","");
        sendRequest();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(arrayList!=null) {
//                    ListViewAdapter adapter = new ListViewAdapter();
//                    listView.setAdapter(adapter);
                    adapter=new SchduleListRecyclerView(arrayList);
                    rv.setAdapter(adapter);
                }


            }
        },2000);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_schdule:
                Intent intent=new Intent(SchduleListActivity.this,SchduleActivity.class);
                startActivity(intent);
                break;
        }
    }



    public void sendRequest()
    {
        selecturl="http://10.10.0.219:7070/MentorMentee/SelectListViewServlet?eid="+empid;
        Log.e("url",""+selecturl);
        StringRequest stringRequest=new StringRequest(selecturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1;
                    MeetingInfo meetingInfo;
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        jsonObject1=jsonArray.getJSONObject(i);
                        String time=jsonObject1.getString("time");
                        String name=jsonObject1.getString("pname");
                        String venue=jsonObject1.getString("venue");
                        String purpose=jsonObject1.getString("purpose");
                        meetingInfo=new MeetingInfo(time,name,venue,purpose);
                        arrayList.add(meetingInfo);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error",""+error);

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


//    class ListViewAdapter extends ArrayAdapter<MeetingInfo>
//    {
//
//        public ListViewAdapter() {
//            super(SchduleListActivity.this, R.layout.layoutunder_listview,arrayList);
//        }
//
//        @NonNull
//        @Override
//        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//            LayoutInflater inflater=getLayoutInflater();
//            View view=inflater.inflate(R.layout.layoutunder_listview,null);
//            TextView textViewtime=(TextView)view.findViewById(R.id.textviewtime);
//            TextView textViewPname=(TextView)view.findViewById(R.id.textviewwith);
//            TextView textViewvenue=(TextView)view.findViewById(R.id.textviewvenue);
//            TextView textViewpurpose=(TextView)view.findViewById(R.id.textviewpurpose);
//
//            MeetingInfo meetingInfo=arrayList.get(position);
//            textViewtime.setText(meetingInfo.getTime());
//            textViewPname.setText(meetingInfo.getPname());
//            textViewvenue.setText(meetingInfo.getVenue());
//            textViewpurpose.setText(meetingInfo.getPurpose());
//
//
//            return view;
//        }
//    }


    @Override
    protected void onResume() {
        super.onResume();
        cleardata();
        sendRequest();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
if(arrayList!=null) {
//    ListViewAdapter adapter = new ListViewAdapter();
//    listView.setAdapter(adapter);
}


            }
        },2000);
    }

    public void cleardata()
    {
        if(arrayList !=null) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.clear();
            }
        }

    }



}
