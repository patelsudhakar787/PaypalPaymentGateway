package com.prasanna.rlard008.ergoptixapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.prasanna.rlard008.ergoptixapp.Pojo.LearnImageAdapter;


public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        LearnImageAdapter adapterView = new LearnImageAdapter(this);
        mViewPager.setAdapter(adapterView);
    }
}

