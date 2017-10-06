package com.rlard.rlard008.stbi.Fragments.ManageSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rlard.rlard008.stbi.Fragments.Begin.IdeasFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.ProgressRatingFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdeaDetails_SIGFragment extends Fragment {


    Button buttonNext,buttonClose;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_idea_details__sig, container, false);

        buttonClose=(Button)itemview.findViewById(R.id.SIG_btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.SIG_btn_next);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IdeaSIGFragment frg = new IdeaSIGFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressRatingSIGFragment frg = new ProgressRatingSIGFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });

        return  itemview;

    }

}
