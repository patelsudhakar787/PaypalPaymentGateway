package com.rlard.rlard008.stbi.Fragments.IncubationSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rlard.rlard008.stbi.Fragments.InstituteSIG.InstituteGrantsAndFundFragment;
import com.rlard.rlard008.stbi.Fragments.InstituteSIG.InstituteHackathonFragment;
import com.rlard.rlard008.stbi.Fragments.InstituteSIG.InstituteMyOpportinutyFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IncubationOpportinutyMainFragment extends Fragment {


    TextView textViewProject,textViewGrantsFunding,textViewHackathon;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_incubation_opportinuty_main, container, false);

        textViewProject = (TextView) itemView.findViewById(R.id.textviewProject);
        textViewGrantsFunding = (TextView) itemView.findViewById(R.id.textviewGrantsFunding);
        textViewHackathon = (TextView) itemView.findViewById(R.id.textviewHackathon);

        textViewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IncubationMyOpportinutyFragment frg = new IncubationMyOpportinutyFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();
            }
        });


        textViewGrantsFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Grants And Funding",Toast.LENGTH_LONG).show();

                IncubationGrantsAndFundFragment frg = new IncubationGrantsAndFundFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();
            }
        });

        textViewHackathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Hackathon",Toast.LENGTH_LONG).show();

                IncubationHackathonFragment frg = new IncubationHackathonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_IncubationContainer,frg);
                ft.commit();
            }
        });

        return itemView;

    }

}
