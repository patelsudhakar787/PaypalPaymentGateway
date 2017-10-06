package com.rlard.rlard008.stbi.Fragments.IncubationSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.InstituteSIG.SIG_InstituteDeptFragment;
import com.rlard.rlard008.stbi.Fragments.InstituteSIG.SIG_InstituteInfoFragment;
import com.rlard.rlard008.stbi.Fragments.InstituteSIG.SIG_InstituteMilestoneFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncubationProfileMainFragment extends Fragment {


    TextView textViewProfile,textViewInfo,textViewMileStone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_incubation_profile_main, container, false);

        textViewProfile = (TextView) itemView.findViewById(R.id.textview_SIG_Profile);
        textViewInfo = (TextView) itemView.findViewById(R.id.textview_SIG_Info);
        textViewMileStone = (TextView) itemView.findViewById(R.id.textview_SIG_Milestone);

        textViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_IncubationPofileFragment frg=new SIG_IncubationPofileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();

            }
        });


        textViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_IncubationInfoFragment frg=new SIG_IncubationInfoFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();

            }
        });

        textViewMileStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_IncubationMilestoneFragment frg=new SIG_IncubationMilestoneFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
