package com.rlard.rlard008.stbi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.rlard.rlard008.stbi.Fragments.Begin.IdeasFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.ProfileMainFragment;
import com.rlard.rlard008.stbi.Fragments.EventsFragment;
import com.rlard.rlard008.stbi.Pojo.DrawerData;
import com.rlard.rlard008.stbi.Pojo.DrawerListAdapter;
import com.rlard.rlard008.stbi.Pojo.DrawerOptionAdapter;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;

import java.util.ArrayList;

import static android.R.attr.width;
import static com.rlard.rlard008.stbi.R.attr.height;

public class BeginActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ListView listViewOption;
    private ArrayList<DrawerData> arrayList;
    private ArrayList<DrawerData> arrayListOption;


    private ActionBar actionBar=null;
    private TextView actionbartitle;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerBegin);
        listView=(ListView)findViewById(R.id.left_drawer_data);
        listViewOption=(ListView)findViewById(R.id.left_drawer_option_data);

       // imageView=(ImageView)findViewById(R.id.image);



        //calling function
        addingData();

        loadEventFragment();

        ////////////////

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // DrawerData data=arrayList.get(position);
                if(position==0)
                {
                   // imageView.setVisibility(View.GONE);

            //        listViewEvent.setVisibility(View.GONE);
                    //Toast.makeText(DrawerActivity.this,"Clicked On"+data,Toast.LENGTH_LONG).show();
                    IdeasFragment frg=new IdeasFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==1)
                {
                    //imageView.setVisibility(View.GONE);
              //      listViewEvent.setVisibility(View.GONE);

                    ProfileMainFragment frg=new ProfileMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.container,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==2)
                {
                    //        imageView.setVisibility(View.GONE);
                    // Toast.makeText(ManageSigActivity.this,"Clicked On My Profile",Toast.LENGTH_LONG).show();

//                    ProfileSIGFragment frg=new ProfileSIGFragment();
//                    FragmentManager fm=getSupportFragmentManager();
//                    FragmentTransaction ft=fm.beginTransaction();
//                    ft.replace(R.id.ManageSigContainer,frg);
//                    ft.commit();
//                    Intent intent = new Intent(FindOpportinutyActivity.this,MainActivity.class);
//                    startActivity(intent);

                    Intent intent = new Intent(BeginActivity.this,MainActivity.class);
                    startActivity(intent);

                    drawerLayout.closeDrawer(GravityCompat.START);
                }


            }
        });

        listViewOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i==0) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (i==1) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (i==2) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });
    }

    public void addingData()
    {
        arrayList=new ArrayList<>();
        arrayListOption=new ArrayList<>();
        arrayList.add(new DrawerData(R.drawable.bulb2,"My Idea"));
        arrayList.add(new DrawerData(R.drawable.profile,"My Profile"));

        arrayListOption.add(new DrawerData(0,"Find My Opportunity"));
        arrayListOption.add(new DrawerData(0,"Upgrade My Skill"));
        arrayListOption.add(new DrawerData(0,"Join As Mentor"));

        arrayList.add(new DrawerData(R.drawable.logout2,"Logout"));


        //setting adapter
        DrawerListAdapter adapter=new DrawerListAdapter(this,arrayList);
        listView.setAdapter(adapter);

        //setting adapter
        DrawerOptionAdapter adapter1=new DrawerOptionAdapter(this,arrayListOption);
        listViewOption.setAdapter(adapter1);


        //enable navigation
        View c = getLayoutInflater().inflate(R.layout.action_bar_logo, null);
        actionbartitle=(TextView)c.findViewById(R.id.title);
        actionbartitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.line1,0,0,0);

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

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE ));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menuEvents:
                loadEventFragment();
                break;

            case R.id.menuNotifications:
                Toast.makeText(BeginActivity.this,"Notifications",Toast.LENGTH_LONG).show();
                break;

            case R.id.menuContact:
                Toast.makeText(BeginActivity.this,"Contact",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadEventFragment() {

        EventsFragment frg=new EventsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,frg);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
         //moveTaskToBack(true);
    }




}
