package com.rlard.rlard008.stbi.Fragments.Begin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEducationDetailsFragment extends Fragment {


    Button buttonSaveDetails,buttonCancelDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_add_education_details, container, false);

        buttonSaveDetails = (Button) itemView.findViewById(R.id.addDetailsEdu_btn_save);
        buttonCancelDetails = (Button) itemView.findViewById(R.id.addDetailsEdu_btn_cancel);


        buttonSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();

                EducationFragment frg=new EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });

        buttonCancelDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EducationFragment frg=new EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });


        return itemView;

    }

}
