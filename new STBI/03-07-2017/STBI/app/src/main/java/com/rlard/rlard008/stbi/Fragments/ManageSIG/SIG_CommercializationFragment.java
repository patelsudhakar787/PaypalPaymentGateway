package com.rlard.rlard008.stbi.Fragments.ManageSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.FindOpportinuty.Find_MySkillFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SIG_CommercializationFragment extends Fragment {

    Button buttonAddCommercializationDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_sig__commercialization, container, false);


        buttonAddCommercializationDetails = (Button) itemView.findViewById(R.id.SIG_AddCommercializationDetails);


        buttonAddCommercializationDetails.setOnClickListener(new View.OnClickListener() {
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
