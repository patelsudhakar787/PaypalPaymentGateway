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
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdeaPitchSIGFragment extends Fragment {


    Button buttonOk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_idea_pitch_sig, container, false);

        buttonOk = (Button) itemView.findViewById(R.id.pitch_SIG_btn_ok);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IdeaSIGFragment frg = new IdeaSIGFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });


        return itemView;
    }

}
