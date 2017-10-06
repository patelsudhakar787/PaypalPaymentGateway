package com.rlard.rlard008.stbi.Fragments.InstituteSIG;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rlard.rlard008.stbi.Fragments.ManageSIG.GrantsAndFundFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.HackathonFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.MyOpportinutyFragment;
import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstituteOpportinutyMainFragment extends Fragment {

    TextView textViewProject,textViewGrantsFunding,textViewHackathon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_institute_opportinuty_main, container, false);

        textViewProject = (TextView) itemView.findViewById(R.id.textviewProject);
        textViewGrantsFunding = (TextView) itemView.findViewById(R.id.textviewGrantsFunding);
        textViewHackathon = (TextView) itemView.findViewById(R.id.textviewHackathon);

        textViewProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InstituteMyOpportinutyFragment frg = new InstituteMyOpportinutyFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();
            }
        });


        textViewGrantsFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Grants And Funding",Toast.LENGTH_LONG).show();

                InstituteGrantsAndFundFragment frg = new InstituteGrantsAndFundFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();
            }
        });

        textViewHackathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Hackathon",Toast.LENGTH_LONG).show();

                InstituteHackathonFragment frg = new InstituteHackathonFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.Sig_InstituteContainer,frg);
                ft.commit();
            }
        });

        return itemView;

    }

}
