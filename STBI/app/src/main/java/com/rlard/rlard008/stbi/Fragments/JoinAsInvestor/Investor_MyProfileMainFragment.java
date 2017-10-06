package com.rlard.rlard008.stbi.Fragments.JoinAsInvestor;


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
public class Investor_MyProfileMainFragment extends Fragment {

    TextView textViewPersonalDetails,textViewEducation,textViewInterest,textViewExperience;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_investor__my_profile_main, container, false);

        textViewEducation = (TextView) itemView.findViewById(R.id.textviewInvestorEducation);
        textViewPersonalDetails = (TextView) itemView.findViewById(R.id.textviewInvestorPersonalDetails);
        textViewInterest = (TextView) itemView.findViewById(R.id.textviewInvestorInterest);
        textViewExperience = (TextView) itemView.findViewById(R.id.textviewInvestorExperience);

        textViewPersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Investor_MyProfileFragment frg=new Investor_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();

            }
        });

        textViewEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Investor_EducationFragment frg=new Investor_EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();

            }
        });


        textViewInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Investor_InterestFragment frg=new Investor_InterestFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();

            }
        });

        textViewExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Investor_ExperienceFragment frg=new Investor_ExperienceFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
