package com.example.rlard008.hr_app.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rlard008.hr_app.Activities.TimerActivity;
import com.example.rlard008.hr_app.Api.TimeCalculation;
import com.example.rlard008.hr_app.Pojo.SaveData;
import com.example.rlard008.hr_app.R;
import com.example.rlard008.hr_app.localdb.DataBaseHelper;

import java.text.ParseException;
import java.util.ArrayList;

import static com.example.rlard008.hr_app.R.id.spinnerstatus;

/**
 * Created by sudhakar on 5/22/17.
 */

public class ManualEntryFragment extends Fragment {
    private EditText ettaskname;
    private EditText etrole;
    private EditText ethour1;
    private EditText etminute1;
    private EditText ethour2;
    private EditText etminute2;
    private Spinner spinner;
    private Button btn_submit;
    private DataBaseHelper db;
    private ArrayList<String>arrayListstatus;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View itemView=inflater.inflate(R.layout.manualentry_layout,container,false);
        ettaskname=(EditText)itemView.findViewById(R.id.ettaskname);
        etrole=(EditText)itemView.findViewById(R.id.etrole);
        ethour1=(EditText)itemView.findViewById(R.id.et1hour);
        ethour2=(EditText)itemView.findViewById(R.id.et2hour);
        etminute1=(EditText)itemView.findViewById(R.id.et1minute);
        etminute2=(EditText)itemView.findViewById(R.id.et2minute);
        spinner=(Spinner)itemView.findViewById(spinnerstatus);
        btn_submit=(Button)itemView.findViewById(R.id.btn_submit);

        db=new DataBaseHelper(getContext());
        arrayListstatus=new ArrayList<>();


        setStatusAdapter();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    manualData();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
        return itemView;
    }

    public void manualData() throws ParseException {
        int timetaken=0;
        String taskname=ettaskname.getText().toString();
        String rolename=etrole.getText().toString();
        String hour1=ethour1.getText().toString();
        String minute1=etminute1.getText().toString();
        String starttime=hour1+":"+minute1+":"+"00";
        String hour2=ethour2.getText().toString();
        String minute2=etminute2.getText().toString();
        String stoptime=hour2+":"+minute2+":"+"00";
        //timetaken= (int) TimeCalculation.calculatetime(starttime,stoptime);

        String status=spinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(taskname)){

            ettaskname .setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(rolename)){

            etrole.setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(hour1)){

            ethour1 .setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(minute1)){

            etminute1.setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(hour2)){

            ethour2.setError(getString(R.string.error_field_required));
        }

        else if (TextUtils.isEmpty(minute2)){

            etminute2.setError(getString(R.string.error_field_required));
        }




        else {

            if(status.equals("Done")) {

                timetaken = (int) TimeCalculation.calculatetime(starttime, stoptime);

                SaveData saveData = new SaveData(taskname, rolename, starttime, stoptime, timetaken, status, "Play");
                boolean check = db.insertTaskData(saveData);

                if (check == true) {
                    Toast.makeText(getContext(), "Added To TaskList", Toast.LENGTH_LONG).show();
                    ettaskname.setText("");
                    etrole.setText("");
                    ethour1.setText("");
                    ethour2.setText("");
                    etminute1.setText("");
                    etminute2.setText("");
                }
            } else {

                Toast.makeText(getContext(),"Status of manually entered task must be Done",Toast.LENGTH_LONG).show();
            }
        }
//        SaveData saveData=new SaveData(taskname,rolename,starttime,stoptime,timetaken,status,"Play");
//        boolean check=db.insertTaskData(saveData);
//
//        if(check==true)
//        {
//            Toast.makeText(getContext(),"Added To TaskList",Toast.LENGTH_LONG).show();
//            ettaskname.setText("");
//            etrole.setText("");
//            ethour1.setText("");
//            ethour2.setText("");
//            etminute1.setText("");
//            etminute2.setText("");
//
//        }


    }



    public void setStatusAdapter()
    {
        arrayListstatus.add("Working");
        arrayListstatus.add("Pending");
        arrayListstatus.add("OnHold");
        arrayListstatus.add("Done");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListstatus);
        spinner.setAdapter(arrayAdapter);
    }
}