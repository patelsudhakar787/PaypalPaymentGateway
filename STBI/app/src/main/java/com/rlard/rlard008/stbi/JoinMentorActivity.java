package com.rlard.rlard008.stbi;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rlard.rlard008.stbi.Fragments.Begin.IdeasFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.EventsFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_IdeasFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.JoinAsMentor.Mentor_MyProfileMainFragment;
import com.rlard.rlard008.stbi.Pojo.DrawerData;
import com.rlard.rlard008.stbi.Pojo.DrawerListAdapter;
import com.rlard.rlard008.stbi.Pojo.DrawerOptionAdapter;

import java.util.ArrayList;

public class JoinMentorActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_join_mentor);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerBegin);
        listView=(ListView)findViewById(R.id.left_drawer_data);

        listViewOption=(ListView)findViewById(R.id.left_drawer_option_data);
    //    imageView=(ImageView)findViewById(R.id.image);

        //calling function
        addingData();

        loadEventFragment();

        ////////////////

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DrawerData data=arrayList.get(position);
                if(position==0)
                {
        //            imageView.setVisibility(View.GONE);
                    //Toast.makeText(DrawerActivity.this,"Clicked On"+data,Toast.LENGTH_LONG).show();
//
                    Mentor_IdeasFragment frg=new Mentor_IdeasFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.mentorContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==1)
                {
         //           imageView.setVisibility(View.GONE);

                    Mentor_MyProfileMainFragment frg=new Mentor_MyProfileMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.mentorContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }


                if(position==2)
                {
                    //        imageView.setVisibility(View.GONE);
                    // Toast.makeText(ManageSigActivity.this,"Clicked On My Profile",Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(JoinMentorActivity.this,MainActivity.class);
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

            }
        });

    }

    public void addingData()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new DrawerData(R.drawable.bulb2,"Ideas"));
        arrayList.add(new DrawerData(R.drawable.profile,"My Profile"));
        arrayList.add(new DrawerData(R.drawable.logout2,"Logout"));

        arrayListOption=new ArrayList<>();
        arrayListOption.add(new DrawerData(0,"Begin My Startup"));
        arrayListOption.add(new DrawerData(0,"Upgrade My Skill"));


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
                Toast.makeText(JoinMentorActivity.this,"Notifications",Toast.LENGTH_LONG).show();
                break;

            case R.id.menuContact:
                Toast.makeText(JoinMentorActivity.this,"Contact",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadEventFragment() {

        EventsFragment frg=new EventsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.mentorContainer,frg);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // moveTaskToBack(true);
    }

}
