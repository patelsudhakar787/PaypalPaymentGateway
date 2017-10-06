package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitInternshipFragment extends Fragment {


    Spinner spinnerDay,spinnerMonth;
    Button buttonUpload,buttonClose;

    String days[]={"1","2","3","4","5","6"};

    String months[]={"Weeks","Months"};

    ArrayAdapter<String> daysAdapter;
    ArrayAdapter<String> MonthsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_submit_internship, container, false);

        buttonClose = (Button) itemView.findViewById(R.id.intern_btn_close);
        buttonUpload = (Button) itemView.findViewById(R.id.intern_btn_upload);

        spinnerDay = (Spinner) itemView.findViewById(R.id.InternDurationDay);
        spinnerMonth = (Spinner) itemView.findViewById(R.id.InternDurationMonth);


        daysAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,days);
        spinnerDay.setAdapter(daysAdapter);

        MonthsAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,months);
        spinnerMonth.setAdapter(MonthsAdapter);

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business__UpgradeOppFragment frg = new Business__UpgradeOppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.BusinessContainer, frg);
                ft.commit();

            }
        });

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Uploaded",Toast.LENGTH_LONG).show();

                Business__UpgradeOppFragment frg = new Business__UpgradeOppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.BusinessContainer, frg);
                ft.commit();

            }
        });


        return itemView;

    }

}
