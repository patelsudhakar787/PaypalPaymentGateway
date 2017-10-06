package com.rlard.rlard008.stbi.Fragments.FindOpportinuty;


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
public class Find_MyOppMainFragment extends Fragment {


    TextView textViewIntern,textViewSponser,textViewJob;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_find__my_opp_main, container, false);

        textViewIntern = (TextView) itemView.findViewById(R.id.textviewIntern);
        textViewSponser = (TextView) itemView.findViewById(R.id.textviewSponser);
        textViewJob = (TextView) itemView.findViewById(R.id.textviewJob);

        textViewIntern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Find_MyOppFragment frg = new Find_MyOppFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();
            }
        });


        textViewSponser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Sponseer",Toast.LENGTH_LONG).show();

                Find_SponserProFragment frg = new Find_SponserProFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();
            }
        });

        textViewJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Job",Toast.LENGTH_LONG).show();

                Find_JobFragment frg = new Find_JobFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.OpportinutyContainer,frg);
                ft.commit();
            }
        });

        return itemView;
    }

}
