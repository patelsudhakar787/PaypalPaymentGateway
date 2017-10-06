package com.example.rlard008.hr_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.hr_app.Pojo.SaveData;
import com.example.rlard008.hr_app.R;
import com.example.rlard008.hr_app.localdb.DataBaseHelper;

import org.json.JSONObject;

import java.util.ArrayList;


public class TaskListFragment extends Fragment {


    private ListView listviewData;
    private ArrayList<SaveData>arrayListTaskData;
    DataBaseHelper db;
    private SharedPreferences sharedPreferences;
    String submitrequesturl="";
    SaveData saveData1;
    boolean status=false;
    private String result="";
    private static int pos=0;
    private String role="";




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.fragment_task_list,container,false);
        listviewData=(ListView)itemview.findViewById(R.id.listviewtask);

        // sharedPreferences
        sharedPreferences=getContext().getSharedPreferences("roledata", Context.MODE_PRIVATE);
//role
//        role=sharedPreferences.getString("rolename","").replace(" ","");
//
//        Log.e("RoleName",""+role);

        arrayListTaskData=new ArrayList<>();
        db=new DataBaseHelper(getContext());

        arrayListTaskData=db.getData();
        Log.e("arraylistadat",""+arrayListTaskData);

        //setting adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listviewData.setAdapter(adapter);

        return itemview;
    }




    // adapter class
    class ListViewAdapter extends ArrayAdapter<SaveData>
    {

        public ListViewAdapter() {
            super(getActivity(),R.layout.tasklist_listview,arrayListTaskData);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View itemView=inflater.inflate(R.layout.tasklist_listview,parent,false);
            TextView tvtaskname=(TextView) itemView.findViewById(R.id.tvtaskname);
            TextView tvstarttime=(TextView)itemView.findViewById(R.id.tvstarttime);
            TextView tvstoptime=(TextView)itemView.findViewById(R.id.tvstoptime);
            TextView ttaken=(TextView)itemView.findViewById(R.id.ttaken);
            TextView status=(TextView)itemView.findViewById(R.id.tvstatus);
            Button btn_submit=(Button)itemView.findViewById(R.id.btn_submit);
            Button btn_edit=(Button)itemView.findViewById(R.id.btn_edit);

            SaveData saveData=arrayListTaskData.get(position);
            tvtaskname.setText(saveData.getTaskname());
            tvstarttime.setText(saveData.getStarttime());
            tvstoptime.setText(saveData.getStoptime());
            ttaken.setText(""+saveData.getTimetaken());
            status.setText(saveData.getStatus());


            //click listener on submit button
            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String taskname1=null;
                    String starttime1=null;
                    String stoptime1=null;
                    String status1=null;


                    saveData1=arrayListTaskData.get(position);

                    //role
                    role = saveData1.getRole().replace(" ","_");

                    //taskname
                    String taskname=saveData1.getTaskname();
                    if(taskname !=null) {
                        taskname1 = taskname.replace(" ", "_");
                    }
                    //starttime
                    String starttime=saveData1.getStarttime();
                    if(starttime !=null) {
                        starttime1 = starttime.replace(" ", "");
                    }
                    //stoptime
                    String stoptime=saveData1.getStoptime();
                    if(stoptime !=null) {
                        stoptime1 = stoptime.replace(" ", "");
                    }
                    //status
                    String status=saveData1.getStatus();

                    if(status !=null) {
                        status1 = status.replace(" ", "");
                    }
                    //timetaken
                    int timetaken=saveData1.getTimetaken();

//getting table name
                    sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                    String tablename=sharedPreferences.getString("personName","");
                    tablename=tablename.replace(" ","");
                    //calling submit request function
                    submitrequesturl="http://139.59.78.52:8080/HR_Application/SubmitTaskServlet?role="+role+"&task="+taskname1+"&starttime="+starttime1+"&stoptime="+stoptime1+"&ttime="+timetaken+"&status="+status1+"&table="+tablename;
                    Log.e("url",""+submitrequesturl);
                    submitRequest();


               pos=position;


                }
            });


            //click on edit button
            btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listviewData.setVisibility(View.GONE);

                    SaveData saveData2=arrayListTaskData.get(position);
                    String taskname=saveData2.getTaskname();
                    String rolename=saveData2.getRole();

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("task",taskname);
                    editor.putString("role",rolename);
                    editor.commit();
                    loadingChildFragment();
                }
            });

            return itemView;
        }
    }


    public void submitRequest()
    {
        StringRequest stringRequest=new StringRequest(submitrequesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    result=jsonObject.getString("data");
                    db.deleteData(saveData1.getTaskname());
                    arrayListTaskData.remove(pos);
                    //setting adapter
                    ListViewAdapter adapter = new ListViewAdapter();
                    listviewData.setAdapter(adapter);
                    Toast.makeText(getContext(),""+result,Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(),"connection problem",Toast.LENGTH_LONG).show();
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


    public void loadingChildFragment()
    {
        EditTaskListFragment editTaskListFragment=new EditTaskListFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.relative,editTaskListFragment);
        ft.commit();
    }


}
