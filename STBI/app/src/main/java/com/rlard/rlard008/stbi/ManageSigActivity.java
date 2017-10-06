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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rlard.rlard008.stbi.Fragments.EventsFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.IdeaSIGFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.MyOpportinutyMainFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_MyPofileFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_MyPofileMainFragment;
import com.rlard.rlard008.stbi.Pojo.DrawerData;
import com.rlard.rlard008.stbi.Pojo.DrawerListAdapter;

import java.util.ArrayList;

public class ManageSigActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ArrayList<DrawerData> arrayList;
    private ActionBar actionBar=null;
    private TextView actionbartitle;
    //private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_sig);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerBegin);
        listView=(ListView)findViewById(R.id.left_drawer_data);
      //  imageView=(ImageView)findViewById(R.id.imageSig);

        //calling function
        addingData();


        loadEventFragment();

        ////////////////

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
    //                imageView.setVisibility(View.GONE);
                    //Toast.makeText(ManageSigActivity.this,"Clicked On Idea from SIG",Toast.LENGTH_LONG).show();

                    IdeaSIGFragment frg=new IdeaSIGFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.ManageSigContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==1)
                {
     //               imageView.setVisibility(View.GONE);
                    //Toast.makeText(ManageSigActivity.this,"Clicked On My Opportunity",Toast.LENGTH_LONG).show();
                    MyOpportinutyMainFragment frg=new MyOpportinutyMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.ManageSigContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==2)
                {
     //               imageView.setVisibility(View.GONE);
                    Toast.makeText(ManageSigActivity.this,"Clicked On My Profile",Toast.LENGTH_LONG).show();

                    SIG_MyPofileMainFragment frg=new SIG_MyPofileMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.ManageSigContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==3)
                {
 //                   imageView.setVisibility(View.GONE);
//                    Toast.makeText(DrawerActivity.this,"In Manage Fragment",Toast.LENGTH_LONG).show();
//                    ManageFragment frg=new ManageFragment();
//                    FragmentManager fm=getSupportFragmentManager();
//                    FragmentTransaction ft=fm.beginTransaction();
//                    ft.replace(R.id.container,frg);
//                    ft.commit();
                    Intent intent = new Intent(ManageSigActivity.this,MainActivity.class);
                    startActivity(intent);


                    drawerLayout.closeDrawer(GravityCompat.START);
                }

            }
        });

    }

    public void addingData()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new DrawerData(R.drawable.bulb2,"Idea From My SIG"));
        arrayList.add(new DrawerData(R.drawable.opp1,"My Opportunity"));
        arrayList.add(new DrawerData(R.drawable.profile,"My Profile"));
        arrayList.add(new DrawerData(R.drawable.logout2,"Logout"));


        //setting adapter
        DrawerListAdapter adapter=new DrawerListAdapter(this,arrayList);
        listView.setAdapter(adapter);


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
                Toast.makeText(ManageSigActivity.this,"Notifications",Toast.LENGTH_LONG).show();
                break;

            case R.id.menuContact:
                Toast.makeText(ManageSigActivity.this,"Contact",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadEventFragment() {

        EventsFragment frg=new EventsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.ManageSigContainer,frg);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
      //  moveTaskToBack(true);
    }


}
