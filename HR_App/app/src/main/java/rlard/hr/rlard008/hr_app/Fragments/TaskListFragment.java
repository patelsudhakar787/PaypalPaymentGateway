package rlard.hr.rlard008.hr_app.Fragments;


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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Pojo.SaveData;
import rlard.hr.rlard008.hr_app.R;
import rlard.hr.rlard008.hr_app.localdb.DataBaseHelper;


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
        Boolean isExpand = false;
        public ListViewAdapter() {
            super(getActivity(),R.layout.tasklist_listview,arrayListTaskData);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getActivity().getLayoutInflater();
            View itemView=inflater.inflate(R.layout.tasklist_listview,parent,false);
            TextView tvtaskname=(TextView) itemView.findViewById(R.id.tvtaskname);
            TextView tvstarttime=(TextView)itemView.findViewById(R.id.tvsttime);
            TextView tvstoptime=(TextView)itemView.findViewById(R.id.tvstoptime);
            TextView ttaken=(TextView)itemView.findViewById(R.id.ttaken);
            TextView status=(TextView)itemView.findViewById(R.id.tvstatus);
            TextView tvnote=(TextView)itemView.findViewById(R.id.tvnote);
            TextView tvcname=(TextView)itemView.findViewById(R.id.cname);
            Button btn_submit=(Button)itemView.findViewById(R.id.btn_submit);
            Button btn_edit=(Button)itemView.findViewById(R.id.btn_edit);
            final LinearLayout linearcompanies=(LinearLayout)itemView.findViewById(R.id.linearcname);
            final Button btn_ex_col=(Button)itemView.findViewById(R.id.btn_ex_col);
            final LinearLayout linearLayout=(LinearLayout)itemView.findViewById(R.id.linear);
            SaveData saveData=arrayListTaskData.get(position);
            tvtaskname.setText(saveData.getTaskname());

            String startt=saveData.getStarttime();
            tvstarttime.setText(""+startt);
            String stopt=saveData.getStoptime();
            Log.e("Stop Time",""+stopt);
            tvstoptime.setText(""+stopt);
            ttaken.setText(""+saveData.getTimetaken());
            status.setText(saveData.getStatus());
            tvnote.setText(""+saveData.getNote());
            tvcname.setText(""+saveData.getCompanyname());



            //setting visibility for  linear layout
            linearLayout.setVisibility(View.GONE);
            linearcompanies.setVisibility(View.GONE);

            //click listener on button expand ans collapse
            btn_ex_col.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (isExpand == true) {
                        linearLayout.setVisibility(View.GONE);
                        linearcompanies.setVisibility(View.GONE);
                        isExpand = false;
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        // expandButton.setCompoundDrawablesWithIntrinsicBounds(
                        //       R.drawable.expand1, 0, 0, 0);
                    }
                    else {
                        linearLayout.setVisibility(View.VISIBLE);
                        linearcompanies.setVisibility(View.VISIBLE);
                        isExpand = true;
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        btn_ex_col.setCompoundDrawablesWithIntrinsicBounds(
                                R.drawable.collapse1, 0, 0, 0);
                    }

                }
            });
            //click listener on submit button
            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String taskname=null;
                    String starttime=null;
                    String stoptime=null;
                    String status=null;
                    String note=null;
                    String companyname=null;

                    saveData1=arrayListTaskData.get(position);

                     note=saveData1.getNote();
                    if(note !=null) {
                        note = note.replace(" ", "_");
                    }
                    companyname=saveData1.getCompanyname();
                    //role
                    role = saveData1.getRole();
                    if(role !=null) {
                        role = role.replace(" ", "_");
                    }
                    //taskname
                    taskname=saveData1.getTaskname();
                    if(taskname !=null) {
                        taskname= taskname.replace(" ", "_");
                    }
                    //starttime
                    starttime=saveData1.getStarttime();
                    if(starttime !=null) {
                        starttime = starttime.replace(" ", "");
                    }
                    //stoptime
                    stoptime=saveData1.getStoptime();
                    if(stoptime !=null) {
                        stoptime = stoptime.replace(" ", "");
                    }
                    //status
                    status=saveData1.getStatus();

                    if(status !=null) {
                        status = status.replace(" ", "");
                    }
                    //timetaken
                    int timetaken=saveData1.getTimetaken();

//getting table name
                    sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
                    String tablename=sharedPreferences.getString("personName","");
                    tablename=tablename.replace(" ","");
                    //calling submit request function
                    submitrequesturl="http://139.59.78.52:8080/HR_Application/SubmitTaskServlet?role="+role+"&task="+taskname+"&starttime="+starttime+"&stoptime="+stoptime+"&ttime="+timetaken+"&status="+status+"&table="+tablename+"&note="+note+"&cname="+companyname;
                    Log.e("url",""+submitrequesturl);

                    if(taskname !=null && starttime !=null && stoptime !=null &&companyname !=null && role != null && status != null) {
                        submitRequest();
                    }
                    else
                    {
                        Toast.makeText(getContext(),"Please Enter all Data",Toast.LENGTH_LONG).show();
                    }

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
                    String note=saveData2.getNote();
                    String compnayname=saveData2.getCompanyname();

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("task",taskname);
                    editor.putString("role",rolename);
                    editor.putString("note",note);
                    editor.putString("cname",compnayname);
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
