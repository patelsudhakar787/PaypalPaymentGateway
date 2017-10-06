package com.rlard.rlard008.stbi.Fragments.UpgradeSkills;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpgradeDetailsFragment extends Fragment {


    Button buttonNext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_upgrade_details, container, false);

        buttonNext = (Button) itemView.findViewById(R.id.upgrade_btn_next);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpgradeDetails2Fragment frg=new UpgradeDetails2Fragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.UpgradeContainer,frg);
                ft.commit();
            }
        });


        return itemView;
    }

}
