package com.rlard.rlard008.stbi.Fragments.InstituteSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rlard.rlard008.stbi.Fragments.ManageSIG.IdeaPitchSIGFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.IdeaSIGFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstituteProgressRatingSIGFragment extends Fragment {

    Button buttonNext,buttonClose;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_institute_progress_rating_sig, container, false);

        buttonClose=(Button)itemview.findViewById(R.id.progress_btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.progress_btn_next);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InstituteIdeaSIGFragment frg = new InstituteIdeaSIGFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InstituteIdeaPitchSIGFragment frg = new InstituteIdeaPitchSIGFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();
            }
        });

        return  itemview;
    }



}
