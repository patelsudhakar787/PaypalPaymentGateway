package com.rlard.rlard008.stbi.Fragments.JoinAsMentor;


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
public class Mentor_IdeaDetailsFragment extends Fragment {

    Button buttonNext,buttonClose;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_mentor__idea_details, container, false);

        buttonClose=(Button)itemview.findViewById(R.id.mentor_btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.mentor_btn_next);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_IdeasFragment frg = new Mentor_IdeasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_ProgressRatingFragment frg = new Mentor_ProgressRatingFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();
            }
        });

        return  itemview;
    }


}
