package com.example.sudhakar.rfdms_app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sudhakar.rfdms_app.R;


public class MainActivityFragment extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.card_view_graph_view,container,false);
        cardView1=(CardView)v.findViewById(R.id.linear1);
        cardView2=(CardView)v.findViewById(R.id.linear2);
        cardView3=(CardView)v.findViewById(R.id.linear3);
        cardView4=(CardView)v.findViewById(R.id.linear4);

        //calling functions
        loadVoltageFragment();
        loadCurrentFragment();
        loadPowerFragment();
        loadPowerFactorFragment();
        return v;
    }



    //loading fragment
    public void loadCurrentFragment()
    {
        CurrentGraphFragment currentGraphFragment=new CurrentGraphFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear2,currentGraphFragment);
        ft.commit();
    }

    public void loadPowerFactorFragment()
    {
        PowerFactorGraphFragment powerFactorGraphFragment=new PowerFactorGraphFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear4,powerFactorGraphFragment);
        ft.commit();
    }


    public void loadPowerFragment()
    {
        PowerGraphFragment powerGraphFragment=new PowerGraphFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear3,powerGraphFragment);
        ft.commit();
    }

    public void loadVoltageFragment()
    {
        VoltageGraphFragment voltageGraphFragment=new VoltageGraphFragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear1,voltageGraphFragment);
        ft.commit();
    }

}
