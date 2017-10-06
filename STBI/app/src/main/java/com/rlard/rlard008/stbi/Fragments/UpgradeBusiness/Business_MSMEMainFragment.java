package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


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
public class Business_MSMEMainFragment extends Fragment {


    TextView textViewMSME,textViewDSIR,textViewOTHER;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView=inflater.inflate(R.layout.fragment_business__msmemain, container, false);

        textViewMSME = (TextView) itemView.findViewById(R.id.textviewMSME);
        textViewDSIR = (TextView) itemView.findViewById(R.id.textviewDSIR);
        textViewOTHER = (TextView) itemView.findViewById(R.id.textviewOTHER);

        textViewMSME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_MSMEFragment frg=new Business_MSMEFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();

            }
        });

        textViewDSIR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_DISRFragment frg=new Business_DISRFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();

            }
        });


        textViewOTHER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_OTHERFragment frg=new Business_OTHERFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();

            }
        });

        return itemView;

    }

}
