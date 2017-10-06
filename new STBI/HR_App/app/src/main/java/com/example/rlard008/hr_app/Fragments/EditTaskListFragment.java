package com.example.rlard008.hr_app.Fragments;


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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rlard008.hr_app.Api.TimeCalculation;
import com.example.rlard008.hr_app.Pojo.SaveData;
import com.example.rlard008.hr_app.R;
import com.example.rlard008.hr_app.localdb.DataBaseHelper;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by sudhakar on 5/22/17.
 */

public class EditTaskListFragment extends Fragment {

    private TextView ettaskname;
    private TextView etrole;
    private EditText et1hour;
    private EditText et2hour;
    private EditText et1minute;
    private EditText et2minute;
    private Spinner spinnerstatus;
    private Button btnsubmit;
    private SharedPreferences sharedPreferences;
    private ArrayList<String>arrayListstatus;
    private ArrayList<SaveData>arrayList;
    private String taskname=null;
    private String role=null;
    private DataBaseHelper db;
    private String checkbtn="";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View itemview=inflater.inflate(R.layout.edittasklist_layout,container,false);

        ettaskname=(TextView) itemview.findViewById(R.id.tvtaskname1);
        etrole=(TextView) itemview.findViewById(R.id.tvrole1);
        et1hour=(EditText)itemview.findViewById(R.id.et1hour);
        et1minute=(EditText)itemview.findViewById(R.id.et1minute);
        et2hour=(EditText)itemview.findViewById(R.id.et2hour);
        et2minute=(EditText)itemview.findViewById(R.id.et2minute);
        spinnerstatus=(Spinner)itemview.findViewById(R.id.spinnerstatus);
        btnsubmit=(Button)itemview.findViewById(R.id.btn_submit);

        db=new DataBaseHelper(getContext());
        sharedPreferences=getContext().getSharedPreferences("roledata", Context.MODE_PRIVATE);
        db=new DataBaseHelper(getContext());
        taskname=sharedPreferences.getString("task","");
        role=sharedPreferences.getString("role","");
        etrole.setText(""+role);

        Log.e("TaskName->",taskname);
        Toast.makeText(getContext(),""+taskname,Toast.LENGTH_LONG).show();
        ettaskname.setText(""+taskname);

        arrayList=new ArrayList<>();


        arrayListstatus=new ArrayList<>();
        setStatusAdapter();


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
        int totaltime=0;

        String hour1=et1hour.getText().toString();
        String minute1=et1minute.getText().toString();
        String starttime=hour1+":"+minute1+":"+"00";
        Log.e("SatrtTiem",starttime);
        String hour2=et2hour.getText().toString();
        String minute2=et2minute.getText().toString();
        String stoptime=hour2+":"+minute2+":"+"00";
//        Log.e("StopTime",stoptime);
//        try {
//           totaltime = (int) TimeCalculation.calculatetime(starttime,stoptime);
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

        else if (TextUtils.isEmpty(hour1)){

            et1hour .setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(minute1)){

            et1minute.setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(hour2)){

            et2hour.setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(minute2)){

            et2minute.setError(getString(R.string.error_field_required));
        }

        else {

            Log.e("StopTime",stoptime);
            try {
                totaltime = (int) TimeCalculation.calculatetime(starttime,stoptime);
                Log.e("TotalTime",""+totaltime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            SaveData saveData = new SaveData(taskname, role, starttime, stoptime, totaltime, status, checkbtn);
            Log.e("SaveData", "" + saveData);
            boolean check = db.updateData(saveData);
            if (check == true) {
                Toast.makeText(getContext(), "Updated", Toast.LENGTH_LONG).show();
            }


        }

    }
}

