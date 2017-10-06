package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Business__UpgradeOppMainFragment extends Fragment {

    TextView textViewIntern, textViewConsultancy, textViewChallenge;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_business___upgrade_opp_main, container, false);

        textViewIntern = (TextView) itemView.findViewById(R.id.textviewIntern);
        textViewConsultancy = (TextView) itemView.findViewById(R.id.textviewConsultancy);
        textViewChallenge = (TextView) itemView.findViewById(R.id.textviewChallenge);

        textViewIntern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business__UpgradeOppFragment frg = new Business__UpgradeOppFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.BusinessContainer, frg);
                ft.commit();

            }
        });

        textViewConsultancy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_ConsultancyFragment frg = new Business_ConsultancyFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.BusinessContainer, frg);
                ft.commit();

            }
        });


        textViewChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_ChallengeFragment frg = new Business_ChallengeFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.BusinessContainer, frg);
                ft.commit();

            }
        });

        return itemView;
    }

}
