package com.rlard.rlard008.stbi.Fragments.Begin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends Fragment {


  //  TextView textViewPersonalDetails,textViewEducation,textViewMySkills;
    Button buttonEducationDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_education, container, false);

//        textViewEducation = (TextView) itemView.findViewById(R.id.textviewEduEducation);
//        textViewPersonalDetails = (TextView) itemView.findViewById(R.id.textviewEduPersonalDetails);
//        textViewMySkills = (TextView) itemView.findViewById(R.id.textviewEduMySkills);
        buttonEducationDetails = (Button) itemView.findViewById(R.id.education_AddDetails);


        buttonEducationDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddEducationDetailsFragment frg=new AddEducationDetailsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });


//        textViewPersonalDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                MyProfileFragment frg=new MyProfileFragment();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();
//
//            }
//        });
//
//        textViewEducation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                EducationFragment frg=new EducationFragment();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();
//
//            }
//        });
//
//
//        textViewMySkills.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                SkillsFragment frg=new SkillsFragment();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();
//
//            }
//        });
//

        return itemView;
    }

}
