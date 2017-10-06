package com.rlard.smartenergymeter.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rlard.smartenergymeter.R;
import com.rlard.smartenergymeter.fragment.MainActivityFragment;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //loading fragment
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
