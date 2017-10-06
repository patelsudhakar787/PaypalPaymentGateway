package com.example.rlard008.hr_app.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.rlard008.hr_app.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminFragment extends Fragment {


    public AdminFragment() {
        // Required empty public constructor
    }


    EditText editTextName;
    Spinner spinnerReportType;
    Button buttonSubmit;

    private ArrayList<String> arrayListReportType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_admin,container,false);

        editTextName = (EditText) itemview.findViewById(R.id.etAdminEmpname);
        spinnerReportType = (Spinner) itemview.findViewById(R.id.spinnerAdminReport);
        buttonSubmit = (Button) itemview.findViewById(R.id.buttonAdminSubmit);

        arrayListReportType = new ArrayList<>();

        setReportTypeAdapter();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getdata();

            }
        });

        return itemview;
    }

    void getdata() {

        String empName = editTextName.getText().toString();
        String reportType = spinnerReportType.getSelectedItem().toString();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("AdminData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("empName",empName);
        editor.commit();

        if (reportType.equals("Daily Report")) {

            loadAdminDailyReportFragment();
        }
        if (reportType.equals("Weekly Report")) {

            loadAdminWeeklyReportFragment();
        }
        if (reportType.equals("Monthly Report")) {

            loadAdminMonthlyReportFragment();
        }
    }

    void setReportTypeAdapter() {

        arrayListReportType.add("Daily Report");
        arrayListReportType.add("Weekly Report");
        arrayListReportType.add("Monthly Report");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,arrayListReportType);
        spinnerReportType.setAdapter(adapter);
    }

    void loadAdminDailyReportFragment () {

        AdminDailyReportFragment frg=new AdminDailyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }

    void loadAdminWeeklyReportFragment () {

        AdminWeeklyReportFragment frg=new AdminWeeklyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }
    void loadAdminMonthlyReportFragment () {

        AdminMonthlyReportFragment frg=new AdminMonthlyReportFragment();
        android.support.v4.app.FragmentManager fm=getFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.adminContainer,frg);
        ft.commit();
    }

}
