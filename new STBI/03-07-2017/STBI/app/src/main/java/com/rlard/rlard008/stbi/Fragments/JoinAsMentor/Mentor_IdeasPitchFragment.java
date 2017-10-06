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
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_IdeasPitchFragment extends Fragment {


    Button buttonOk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_mentor__ideas_pitch, container, false);

        buttonOk = (Button) itemView.findViewById(R.id.mentor_pitch_btn_ok);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_IdeasFragment frg = new Mentor_IdeasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.mentorContainer, frg);
                ft.commit();
            }
        });

        return itemView;
    }
}
