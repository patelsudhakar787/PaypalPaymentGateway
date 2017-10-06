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
public class MyProfileFragment extends Fragment {


   // TextView textViewPersonalDetails,textViewEducation,textViewMySkills;
    Button buttonAddProfDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_my_profile, container, false);

//        textViewEducation = (TextView) itemView.findViewById(R.id.textviewEducation);
//        textViewPersonalDetails = (TextView) itemView.findViewById(R.id.textviewPersonalDetails);
//        textViewMySkills = (TextView) itemView.findViewById(R.id.textviewMySkills);
        buttonAddProfDetails = (Button) itemView.findViewById(R.id.profile_AddDetails);


        buttonAddProfDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProfileAddDetailsFragment frg=new ProfileAddDetailsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });




        return itemView;
    }

}
