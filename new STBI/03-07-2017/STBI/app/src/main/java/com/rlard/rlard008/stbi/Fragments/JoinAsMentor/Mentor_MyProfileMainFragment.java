package com.rlard.rlard008.stbi.Fragments.JoinAsMentor;


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
public class Mentor_MyProfileMainFragment extends Fragment {

    TextView textViewPersonalDetails,textViewEducation,textViewMySkills,textViewExperience,textViewDesign,textViewTraining;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_mentor__my_profile_main, container, false);

        textViewEducation = (TextView) itemView.findViewById(R.id.textviewMentorEducation);
        textViewPersonalDetails = (TextView) itemView.findViewById(R.id.textviewMentorPersonalDetails);
        textViewMySkills = (TextView) itemView.findViewById(R.id.textviewMentorCommercialization);
        textViewExperience = (TextView) itemView.findViewById(R.id.textviewMentorExperience);
        textViewDesign = (TextView) itemView.findViewById(R.id.textviewMentorCourse);
        textViewTraining = (TextView) itemView.findViewById(R.id.textviewMentorTraining);

        textViewPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_MyProfileFragment frg=new Mentor_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        textViewEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_EducationFragment frg=new Mentor_EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });


        textViewMySkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_SkillsFragment frg=new Mentor_SkillsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        textViewExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_ExperienceFragment frg=new Mentor_ExperienceFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        textViewDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_CourseDesignFragment frg=new  Mentor_CourseDesignFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        textViewTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_OfferTrainingFragment frg=new  Mentor_OfferTrainingFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
