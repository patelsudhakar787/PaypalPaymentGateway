package com.rlard.rlard008.stbi.Fragments.FindOpportinuty;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.Begin.EducationFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.ProfileAddDetailsFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.SkillsFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Find_MyProfileFragment extends Fragment {



    Button buttonAddProfDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_find__my_profile, container, false);


        buttonAddProfDetails = (Button) itemView.findViewById(R.id.profile_Find_AddDetails);


        buttonAddProfDetails.setOnClickListener(new View.OnClickListener() {
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
