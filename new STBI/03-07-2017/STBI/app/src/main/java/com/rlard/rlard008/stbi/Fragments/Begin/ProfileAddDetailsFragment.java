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
public class ProfileAddDetailsFragment extends Fragment {


    Button buttonSaveDetails,buttonCancelDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_profile_add_details, container, false);

        buttonSaveDetails = (Button) itemView.findViewById(R.id.addDetails_btn_save);
        buttonCancelDetails = (Button) itemView.findViewById(R.id.addDetails_btn_cancel);


        buttonSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();

                MyProfileFragment frg=new MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });

        buttonCancelDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyProfileFragment frg=new MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });


        return itemView;
    }

}
