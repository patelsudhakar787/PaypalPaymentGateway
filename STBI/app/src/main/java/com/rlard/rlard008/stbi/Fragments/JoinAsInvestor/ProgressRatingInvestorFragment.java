package com.rlard.rlard008.stbi.Fragments.JoinAsInvestor;


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
public class ProgressRatingInvestorFragment extends Fragment {


    Button buttonNext,buttonClose;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_progress_rating_investor, container, false);

        buttonClose=(Button)itemview.findViewById(R.id.progress_btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.progress_btn_next);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Investor_IdeaFragment frg = new Investor_IdeaFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IdeaPitchInvestorFragment frg = new IdeaPitchInvestorFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.InvestorContainer,frg);
                ft.commit();
            }
        });

        return  itemview;
    }

}
