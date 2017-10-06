package rlard.hr.rlard008.hr_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import rlard.hr.rlard008.hr_app.Api.Api;
import rlard.hr.rlard008.hr_app.Pojo.SaveData;
import rlard.hr.rlard008.hr_app.R;
import rlard.hr.rlard008.hr_app.localdb.DataBaseHelper;

/**
 * Created by sudhakar on 5/22/17.
 */

public class EditTaskListFragment extends Fragment {

    private TextView ettaskname;
    private TextView etrole;
    private TextView tasknote;
    private TextView companyname;
    private Spinner et1hour;
    private Spinner et2hour;
    private Spinner et1minute;
    private Spinner et2minute;
    private Spinner spinnerstatus;
    private Button btnsubmit;
    private SharedPreferences sharedPreferences;
    private ArrayList<String>arrayListstatus;
    private ArrayList<SaveData>arrayList;
    private String taskname=null;
    private String role=null;
    private String note=null;
    private String comname=null;
    private DataBaseHelper db;
    private String checkbtn="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View itemview=inflater.inflate(R.layout.edittasklist_layout,container,false);

        ettaskname=(TextView) itemview.findViewById(R.id.tvtaskname1);
        etrole=(TextView) itemview.findViewById(R.id.tvrole1);
        tasknote=(TextView)itemview.findViewById(R.id.tvtasknote);
        companyname=(TextView)itemview.findViewById(R.id.tvcompanyname);
        et1hour=(Spinner) itemview.findViewById(R.id.spinnerhour1);
        et1minute=(Spinner) itemview.findViewById(R.id.spinnerminute1);
        et2hour=(Spinner) itemview.findViewById(R.id.spinnerhour2);
        et2minute=(Spinner) itemview.findViewById(R.id.spinnerminute2);
        spinnerstatus=(Spinner)itemview.findViewById(R.id.spinnerstatus);
        btnsubmit=(Button)itemview.findViewById(R.id.btn_submit);

        db=new DataBaseHelper(getContext());
        sharedPreferences=getContext().getSharedPreferences("roledata", Context.MODE_PRIVATE);
        db=new DataBaseHelper(getContext());
        taskname=sharedPreferences.getString("task","");
        role=sharedPreferences.getString("role","");
        note=sharedPreferences.getString("note","");
        comname=sharedPreferences.getString("cname","");
        etrole.setText(""+role);
        ettaskname.setText(""+taskname);
        tasknote.setText(""+note);
        companyname.setText(""+comname);
        arrayList=new ArrayList<>();


        arrayListstatus=new ArrayList<>();
        setStatusAdapter();



        setSpinners();


        checkbtn=db.checkBtn(taskname);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatingData();
                arrayList=db.getData();
                Log.e("Arraylist",""+arrayList);
            }
        });
        return itemview;
    }


    public void setStatusAdapter()
    {
        arrayListstatus.add("Working");
        arrayListstatus.add("Pending");
        arrayListstatus.add("OnHold");
        arrayListstatus.add("Done");
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListstatus);
        spinnerstatus.setAdapter(arrayAdapter);
    }


    public void updatingData()
    {
        Calendar cal = Calendar.getInstance();
        int date=cal.get(Calendar.DATE);
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);

        int totaltime=0;

        String hour1=et1hour.getSelectedItem().toString();
                hour1=hour1.replace(" ","");


        String minute1=et1minute.getSelectedItem().toString();
        minute1=minute1.replace(" ","");


        String starttime = date+":"+month+":"+year+":"+hour1+":"+minute1+":"+"00";
        Log.e("SatrtTiem",starttime);
        String hour2=et2hour.getSelectedItem().toString();
        hour2=hour2.replace(" ","");

        String minute2=et2minute.getSelectedItem().toString();
        minute2=minute2.replace(" ","");

        String stoptime=date+":"+month+":"+year+":"+hour2+":"+minute2+":"+"00";
//        Log.e("StopTime",stoptime);
//        try {
//           totaltime = (int) Api.calculatetime(starttime,stoptime);
//            Log.e("TotalTime",""+totaltime);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        String status=spinnerstatus.getSelectedItem().toString();
        Log.e("status",status);

         if (TextUtils.isEmpty(taskname)){

            ettaskname .setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(role)){

            etrole.setError(getString(R.string.error_field_required));
        }

        else {

            Log.e("StopTime",stoptime);
            try {
                totaltime = (int) Api.calculatetime(starttime,stoptime);
                Log.e("TotalTime",""+totaltime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            SaveData saveData = new SaveData(taskname, role, starttime, stoptime, totaltime, status, checkbtn,note,comname);
            Log.e("SaveData", "" + saveData);
            boolean check = db.updateData(saveData);
            if (check == true) {
                Toast.makeText(getContext(), "Updated", Toast.LENGTH_LONG).show();
            }


        }

    }


    public void setSpinners()
    {
        ArrayList<String>alhour=Api.getHour();
        Log.e("Al data","al"+alhour);
        ArrayAdapter<String>adapter1=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,alhour);
        et1hour.setAdapter(adapter1);
        et2hour.setAdapter(adapter1);


        ArrayList<String>alminute=Api.getMinute();
        ArrayAdapter<String>adapter2=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,alminute);
        et1minute.setAdapter(adapter2);
        et2minute.setAdapter(adapter2);
    }

}

