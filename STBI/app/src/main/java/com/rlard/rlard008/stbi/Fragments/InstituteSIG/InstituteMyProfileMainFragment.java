package com.rlard.rlard008.stbi.Fragments.InstituteSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_CommercializationFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_ConsultancyFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_DepartmentFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_MyPofileFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstituteMyProfileMainFragment extends Fragment {

    TextView textViewProfile,textViewDepartment,textViewInfo,textViewMileStone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_institute_my_profile_main, container, false);

        textViewProfile = (TextView) itemView.findViewById(R.id.textview_SIG_Profile);
        textViewDepartment = (TextView) itemView.findViewById(R.id.textview_SIG_Dept);
        textViewInfo = (TextView) itemView.findViewById(R.id.textview_SIG_Info);
        textViewMileStone = (TextView) itemView.findViewById(R.id.textview_SIG_Milestone);

        textViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_InstitutePofileFragment frg=new SIG_InstitutePofileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();

            }
        });

        textViewDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_InstituteDeptFragment frg=new SIG_InstituteDeptFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();

            }
        });


        textViewInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_InstituteInfoFragment frg=new SIG_InstituteInfoFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();

            }
        });

        textViewMileStone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SIG_InstituteMilestoneFragment frg=new SIG_InstituteMilestoneFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
