package com.petrolpump.rlard008.petrolpump.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.petrolpump.rlard008.petrolpump.AdminActivity;
import com.petrolpump.rlard008.petrolpump.R;



/**
 * Created by sudhakar on 6/6/17.
 */

public class CalenderFragment extends Fragment {
    private DatePicker datePicker;
    private Button btnback;
private SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemview=inflater.inflate(R.layout.fragment_calender,container,false);
        datePicker=(DatePicker)itemview.findViewById(R.id.datepicker);
        btnback=(Button)itemview.findViewById(R.id.btn_back);
        sharedPreferences=getContext().getSharedPreferences("calender", Context.MODE_PRIVATE);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                Log.e("day",""+day);
                Log.e("month",""+month);
                Log.e("year",""+year);

                Intent intent=new Intent(getContext(), AdminActivity.class);
                startActivity(intent);
            }
        });


        return itemview;
    }
}
