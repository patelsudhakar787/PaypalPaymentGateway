package com.rlard.rlard008.stbi.Fragments.ManageSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOpportinutyMainFragment extends Fragment {


    TextView textViewProject,textViewGrantsFunding,textViewHackathon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_my_opportinuty_main, container, false);

        textViewProject = (TextView) itemView.findViewById(R.id.textviewProject);
        textViewGrantsFunding = (TextView) itemView.findViewById(R.id.textviewGrantsFunding);
        textViewHackathon = (TextView) itemView.findViewById(R.id.textviewHackathon);

        textViewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyOpportinutyFragment frg = new MyOpportinutyFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });


        textViewGrantsFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Grants And Funding",Toast.LENGTH_LONG).show();

                GrantsAndFundFragment frg = new GrantsAndFundFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });

        textViewHackathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Hackathon",Toast.LENGTH_LONG).show();

                HackathonFragment frg = new HackathonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });

        return itemView;
    }

}
