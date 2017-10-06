package com.rlard.rlard008.stbi.Fragments.UpgradeSkills;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpgradeApplyConfirmFragment extends Fragment {


    Button buttonApply,buttonClose;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_upgrade_apply_confirm, container, false);

        buttonApply = (Button) itemView.findViewById(R.id.confirm_btn_apply);
        buttonClose = (Button) itemView.findViewById(R.id.confirm_btn_close);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Applied",Toast.LENGTH_LONG).show();

                JuniorSkillsFragment frg=new JuniorSkillsFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.UpgradeContainer,frg);
                ft.commit();
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JuniorSkillsFragment frg=new JuniorSkillsFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.UpgradeContainer,frg);
                ft.commit();
            }
        });


        return itemView;
    }

}
