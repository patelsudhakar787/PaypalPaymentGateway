package com.rlard.rlard008.stbi.Fragments.ManageSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SIG_MyPofileMainFragment extends Fragment {

    TextView textViewCoordinatorDetails,textViewDepartment,textViewCommercialization,textViewConsultancyRecord;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_sig__my_pofile_main, container, false);

        textViewCoordinatorDetails = (TextView) itemView.findViewById(R.id.textview_SIG_CoordinatorDetails);
        textViewDepartment = (TextView) itemView.findViewById(R.id.textview_SIG_Department);
        textViewCommercialization = (TextView) itemView.findViewById(R.id.textview_SIG_Commercialization);
        textViewConsultancyRecord = (TextView) itemView.findViewById(R.id.textview_SIG_Consultancy);

        textViewCoordinatorDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_MyPofileFragment frg=new SIG_MyPofileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();

            }
        });

        textViewDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_DepartmentFragment frg=new SIG_DepartmentFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();

            }
        });


        textViewCommercialization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_CommercializationFragment frg=new SIG_CommercializationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();

            }
        });

        textViewConsultancyRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_ConsultancyFragment frg=new SIG_ConsultancyFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
