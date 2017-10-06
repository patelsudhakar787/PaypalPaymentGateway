package com.example.rlard008.monitoringapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rlard008.monitoringapp.R;



//it will load allparameters fragment in a single fragment
public class MainActivityFragment extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4,cardView5;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v=inflater.inflate(R.layout.card_view_graph_view,container,false);
        cardView1=(CardView)v.findViewById(R.id.linear1);
        cardView2=(CardView)v.findViewById(R.id.linear2);
        cardView3=(CardView)v.findViewById(R.id.linear3);
        cardView4=(CardView)v.findViewById(R.id.linear4);
        cardView5=(CardView)v.findViewById(R.id.linear5);

        loadChannel_1();
        loadChannel_2();
        loadChannel_3();
        loadChannel_4();
        loadChannel_5();
        return v;
    }



    //loading fragments
    public void loadChannel_1()
    {
        ChartChannel1Fragment frg=new ChartChannel1Fragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear1,frg);
        ft.commit();
    }
    public void loadChannel_2()
    {
        ChartChannel2Fragment frg=new ChartChannel2Fragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear2,frg);
        ft.commit();
    }
    public void loadChannel_3()
    {
        ChartChannel3Fragment frg=new ChartChannel3Fragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear3,frg);
        ft.commit();
    }
    public void loadChannel_4()
    {
        ChartChannel4Fragment frg=new ChartChannel4Fragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear4,frg);
        ft.commit();
    }
    public void loadChannel_5()
    {
        ChartChannel5Fragment frg=new ChartChannel5Fragment();
        FragmentManager fm=getChildFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.linear5,frg);
        ft.commit();
    }

}
