package com.rlard.rlard008.stbi.Fragments.FindOpportinuty;


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
public class Find_MyProfileMainFragment extends Fragment {


    TextView textViewPersonalDetails,textViewEducation,textViewMySkills;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_find__my_profile_main, container, false);

        textViewEducation = (TextView) itemView.findViewById(R.id.textview_Find_Education);
        textViewPersonalDetails = (TextView) itemView.findViewById(R.id.textview_Find_PersonalDetails);
        textViewMySkills = (TextView) itemView.findViewById(R.id.textview_Find_MySkills);

        textViewPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Find_MyProfileFragment frg=new Find_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();

            }
        });

        textViewEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Find_EducationFragment frg=new Find_EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();

            }
        });


        textViewMySkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Find_MySkillFragment frg=new Find_MySkillFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
