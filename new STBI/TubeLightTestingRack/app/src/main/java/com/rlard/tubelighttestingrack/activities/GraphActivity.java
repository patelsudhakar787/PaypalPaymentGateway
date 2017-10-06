package com.rlard.tubelighttestingrack.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rlard.tubelighttestingrack.R;
import com.rlard.tubelighttestingrack.fragment.MainActivityFragment;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        loadingFragment();
    }


    public void loadingFragment()
    {
        MainActivityFragment mainActivityFragment=new MainActivityFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,mainActivityFragment);
        ft.commit();
    }
}
