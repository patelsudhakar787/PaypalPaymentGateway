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
public class UpgradeDetails2Fragment extends Fragment {


    Button buttonApply;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_upgrade_details2, container, false);

        buttonApply = (Button) itemView.findViewById(R.id.upgrade_btn_apply);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UpgradeApplyConfirmFragment frg=new UpgradeApplyConfirmFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.UpgradeContainer,frg);
                ft.commit();
            }
        });


        return itemView;
    }

}
