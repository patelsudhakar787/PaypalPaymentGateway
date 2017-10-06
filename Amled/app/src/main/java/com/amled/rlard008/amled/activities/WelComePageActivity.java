package com.amled.rlard008.amled.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.adapter.DrawerListAdapter;
import com.amled.rlard008.amled.api.Network;
import com.amled.rlard008.amled.fragment.WelcomeFragment;
import com.amled.rlard008.amled.pojo.Drawerdata;

import java.util.ArrayList;

public class WelComePageActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView listViewdata;
    private ArrayList<Drawerdata>arrayListdata;
    private ActionBar actionBar=null;
    private TextView actionbartitle;
    private static final String message = "No Internet Connection";
    private Boolean isCon=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come_page);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerdata);
        listViewdata=(ListView)findViewById(R.id.left_drawer_data);
        arrayListdata=new ArrayList<>();



        isCon= Network.isNwConnected(this);
        //checking for Internet connection
        if(!isCon) {
            message(this);
        }
        //calling load fragment function for loading fragment
        loadWelcomeFragment();

        //setting drawer layout
        setDrawerLayout();


        //click listener on drawer Items
        listViewdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    String serviceurl="https://www.amledindia.com/services";
                    Uri uri=Uri.parse(serviceurl);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);

                }

                if(position==1)
                {
                    String abouturl="https://www.amledindia.com/about";
                    Uri uri=Uri.parse(abouturl);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
                if(position==2)
                {
                    String helpurl="https://www.amledindia.com/contact";
                    Uri uri=Uri.parse(helpurl);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);


                }

            }
        });






    }




    //loading fragment

    public void loadWelcomeFragment()
    {

        WelcomeFragment fgr=new WelcomeFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,fgr);
        ft.commit();
    }


    public void setDrawerLayout()
    {
        //adding data to arraylist
        arrayListdata.add(new Drawerdata(R.drawable.services,"Services"));
        arrayListdata.add(new Drawerdata(R.drawable.aboutus,"About Us"));
        arrayListdata.add(new Drawerdata(R.drawable.help,"Help"));
        Log.e("arraylist",""+arrayListdata);


        //setting adapter to drawer
        DrawerListAdapter adapter=new DrawerListAdapter(WelComePageActivity.this,arrayListdata);
        listViewdata.setAdapter(adapter);


        //enable navigation
        View c = getLayoutInflater().inflate(R.layout.action_bar_logo, null);
        actionbartitle=(TextView)c.findViewById(R.id.titledata);
        actionbartitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.line,0,0,0);

        c.findViewById(R.id.feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawers();
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        actionbartitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawers();
                else
                    drawerLayout.openDrawer(GravityCompat.START);

            }
        });


        actionBar=getSupportActionBar();
        actionBar.setCustomView(c);
        actionBar.setDisplayShowCustomEnabled(true);
        //actionBar.setDisplayUseLogoEnabled(true);

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
    }


    //overiding backpressed method
    @Override
    public void onBackPressed() {

    }



    public  static void message(Activity activity) {
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show();
    }



}
