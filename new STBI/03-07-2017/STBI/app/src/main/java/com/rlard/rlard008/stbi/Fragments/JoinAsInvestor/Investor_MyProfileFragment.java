package com.rlard.rlard008.stbi.Fragments.JoinAsInvestor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_CourseDesignFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_EducationFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_ExperienceFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_OfferTrainingFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_SkillsFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Investor_MyProfileFragment extends Fragment {

    Button buttonAddDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_investor__my_profile, container, false);




        buttonAddDetails = (Button) itemView.findViewById(R.id.investor_profile_AddDetails);


        buttonAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                ProfileAddDetailsFragment frg=new ProfileAddDetailsFragment();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();

            }
        });


        return itemView;
    }


}
