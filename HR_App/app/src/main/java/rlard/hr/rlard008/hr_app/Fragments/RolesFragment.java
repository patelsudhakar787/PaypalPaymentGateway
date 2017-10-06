package rlard.hr.rlard008.hr_app.Fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import rlard.hr.rlard008.hr_app.Activities.TimerActivity;
import rlard.hr.rlard008.hr_app.Pojo.RolesData;
import rlard.hr.rlard008.hr_app.R;
import rlard.hr.rlard008.hr_app.service.RemainderService;

import static android.content.Context.MODE_PRIVATE;


public class RolesFragment extends Fragment {

    ArrayList<RolesData> arrayListRoles;
    GridView gridView;
    private SharedPreferences sharedPreferences;

    private String role1=null;
    private String role2=null;
    private String role3=null;
    private String role4=null;
    private String role5=null;
    private String role6=null;
    private String role7=null;
    private String role8=null;
    private String role9=null;
    private String role10=null;
    private String role11=null;
    private String role12=null;
    private String role13=null;
    private String role14=null;
    private String role15=null;
    private String role16=null;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemView=inflater.inflate(R.layout.fragment_roles, container, false);

        gridView=(GridView) itemView.findViewById(R.id.gridviewItem);
        arrayListRoles=new ArrayList<>();



        alaramService();
        sendRequest();


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sharedPreferences=getContext().getSharedPreferences("roledata", MODE_PRIVATE);
                RolesData rolesData=arrayListRoles.get(position);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("rolename",rolesData.getRolename());
                editor.commit();
                Intent intent=new Intent(getContext(),TimerActivity.class);
                startActivity(intent);

            }
        });


        return itemView;
    }
    //GridView Adapter
    public class GridViewAdapter extends ArrayAdapter<RolesData>
    {

        public GridViewAdapter() {
            super(getActivity(),R.layout.textlayout,arrayListRoles);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            View itemview=inflater.inflate(R.layout.textlayout,null);
            TextView textViewdata=(TextView)itemview.findViewById(R.id.text);
            ImageView imageView=(ImageView)itemview.findViewById(R.id.imageview);
            RolesData data=arrayListRoles.get(position);
            textViewdata.setText(""+data.getRolename());
            Log.e("textViewdata",""+textViewdata);
            imageView.setImageResource(data.getRoleicon());
            return itemview;
        }
    }
    //sending request
    public void sendRequest() {

        SharedPreferences sharedPreferences1 =getContext().getSharedPreferences("data",MODE_PRIVATE);

        String empID = sharedPreferences1.getString("empId","");

        Log.e("mainAct_EmpID",""+empID);

        String requesturl = "http://139.59.78.52:8080/HR_Application/SelectRoleServlet?empid="+empID;//+13;
        Log.e("mainAct_requesturl",""+requesturl);
        StringRequest stringRequest = new StringRequest(requesturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Response", "" + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    role1 = jsonObject1.getString("role1");
                    role1=role1.replace("_"," ");
                    role2 = jsonObject1.getString("role2");
                    role2=role2.replace("_"," ");
                    role3 = jsonObject1.getString("role3");
                    Log.e("Role3",""+role3);
                    role3=role3.replace("_"," ");
                    role4 = jsonObject1.getString("role4");
                    role4=role4.replace("_"," ");
                    role5 = jsonObject1.getString("role5");
                    role5=role5.replace("_"," ");
                    role6 = jsonObject1.getString("role6");
                    role6=role6.replace("_"," ");
                    role7 = jsonObject1.getString("role7");
                    role7=role7.replace("_"," ");
                    role8 = jsonObject1.getString("role8");
                    role8=role8.replace("_"," ");
                    role9 = jsonObject1.getString("role9");
                    role9=role9.replace("_"," ");
                    // role9 = jsonObject1.getString("role9");
                    role10 = jsonObject1.getString("role10");
                    role10=role10.replace("_"," ");
                    role11 = jsonObject1.getString("role11");
                    role11=role11.replace("_"," ");
                    role12 = jsonObject1.getString("role12");
                    role12=role12.replace("_"," ");
                    role13 = jsonObject1.getString("role13");
                    role13=role13.replace("_"," ");
                    role14 = jsonObject1.getString("role14");
                    role14=role14.replace("_"," ");
                    role15 = jsonObject1.getString("role15");
                    role15=role15.replace("_"," ");
                    role16 = jsonObject1.getString("role16");
                    role16=role16.replace("_"," ");
                    // role16 = jsonObject1.getString("role16");



                    Log.e("Role1",""+role1);
                    Log.e("Role2",""+role2);
                    Log.e("Role3",""+role3);
                    Log.e("Role4",""+role4);
                    Log.e("Role5",""+role5);
                    Log.e("Role6",""+role6);
                    Log.e("Role7",""+role7);


                    if(!role1.isEmpty() || !role1.equals("null") ) {
                        if(role1.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role1));
                        }
                    }
                    if(!role2.isEmpty() && !role2.equals("null")) {
                        if(role2.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role2));
                        } }
                    if(!role3.isEmpty() && !role3.equals("null")) {
                        if(role3.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role3));
                        } }
                    if(!role4.isEmpty() && !role4.equals("null")) {
                        if(role4.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role4));
                        }    }
                    if(!role5.isEmpty() && !role5.equals("null")) {
                        if(role5.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role5));
                        }     }
                    if(!role6.isEmpty() && !role6.equals("null")) {
                        if(role6.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role6));
                        }  }
                    if(!role7.isEmpty() && !role7.equals("null")) {
                        if(role7.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role7));
                        }    }
                    if(!role8.isEmpty() && !role8.equals("null")) {
                        if(role8.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role8));
                        }     }
//
//                    if(!role9.isEmpty() && !role9.equals("null")) {
//                        arrayListRoles.add(new RolesData(R.drawable.role_icon, role9));
//                    }

                    if(!role9.isEmpty() && !role9.equals("null")) {
                        if(role9.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role9));
                        }     }
                    if(!role10.isEmpty() && !role10.equals("null")) {
                        if(role10.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role10));
                        }     }

                    if(!role11.isEmpty() && !role11.equals("null")) {
                        if(role11.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role11));
                        }     }

                    if(!role12.isEmpty() && !role12.equals("null")) {
                        if(role12.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role12));
                        }     }

                    if(!role13.isEmpty() && !role13.equals("null")) {
                        if(role13.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role13));
                        }     }

                    if(!role14.isEmpty() && !role14.equals("null")) {
                        if(role14.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role14));
                        }    }
                    if(!role15.isEmpty() && !role15.equals("null")) {
                        if(role15.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role15));
                        }   }

                    if(!role16.isEmpty() && !role16.equals("null")) {
                        if(role16.equals("NotDefined"))
                        {
                            //nothing
                        }
                        else {
                            arrayListRoles.add(new RolesData(R.drawable.role_icon, role16));
                        }   }

                    //calling grid View Adapter----
                    GridViewAdapter adapter=new GridViewAdapter();
                    gridView.setAdapter(adapter);

                    Log.e("arraylist_sendRequest",""+arrayListRoles);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error_MainActivity", "" + error);
                Toast.makeText(getContext(),"Internet Connection Issue",Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    void alaramService() {

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");

        date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));

        String localTime = date.format(currentLocalTime);

        Log.e("Local_time", "" + localTime);
        String split_local_time[]=localTime.split(":");

        int l_time = Integer.parseInt(split_local_time[0]);


        Log.e("Local_time", "" + l_time);

        if (l_time >= 11 && l_time < 19) {



            Intent intent = new Intent(getContext(), RemainderService.class);

            PendingIntent pi = PendingIntent.getService(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            long systemtime = SystemClock.elapsedRealtime();
            long timeToExecute = systemtime + 3000;


            //initialize alarm manager with time and intent
            AlarmManager manager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);

            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, timeToExecute, pi);

//            }

        }



    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // Store our shared preference
//        SharedPreferences sp = getContext().getSharedPreferences("OURINFO", MODE_PRIVATE);
//        SharedPreferences.Editor ed = sp.edit();
//        ed.putString("active", "true");
//        ed.commit();
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        SharedPreferences sp = getContext().getSharedPreferences("OURINFO", MODE_PRIVATE);
//        SharedPreferences.Editor ed = sp.edit();
//        ed.putString("active", "false");
//        ed.commit();
//    }

    public void destroyfragment()
    {
        RolesFragment rolesFragment=new RolesFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.remove(rolesFragment);
        ft.commit();
       Toast.makeText(getContext(),"Destroy",Toast.LENGTH_LONG).show();

    }

}
