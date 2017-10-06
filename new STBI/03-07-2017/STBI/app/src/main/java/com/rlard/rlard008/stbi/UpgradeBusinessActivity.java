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

import com.rlard.rlard008.stbi.Fragments.EventsFragment;
import com.rlard.rlard008.stbi.Fragments.FindOpportinuty.Find_MyOppFragment;
import com.rlard.rlard008.stbi.Fragments.FindOpportinuty.Find_MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business_MSMEFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business_MSMEMainFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business_MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business_MyProfileMainFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business__UpgradeOppFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeBusiness.Business__UpgradeOppMainFragment;
import com.rlard.rlard008.stbi.Pojo.DrawerData;
import com.rlard.rlard008.stbi.Pojo.DrawerListAdapter;

import java.util.ArrayList;

public class UpgradeBusinessActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private ArrayList<DrawerData> arrayList;
    private ActionBar actionBar=null;
    private TextView actionbartitle;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_business);

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
      //              imageView.setVisibility(View.GONE);
                    //Toast.makeText(ManageSigActivity.this,"Clicked On Idea from SIG",Toast.LENGTH_LONG).show();

                    Business__UpgradeOppMainFragment frg=new Business__UpgradeOppMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.BusinessContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==1)
                {
       //             imageView.setVisibility(View.GONE);
                    //Toast.makeText(ManageSigActivity.this,"Clicked On My Opportunity",Toast.LENGTH_LONG).show();

                    Business_MSMEMainFragment frg=new Business_MSMEMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.BusinessContainer,frg);
                    ft.commit();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if(position==2)
                {

                    Business_MyProfileMainFragment frg=new Business_MyProfileMainFragment();
                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.replace(R.id.BusinessContainer,frg);
                    ft.commit();

                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                if(position==3)
                {

                    Intent intent = new Intent(UpgradeBusinessActivity.this,MainActivity.class);
                    startActivity(intent);



                    drawerLayout.closeDrawer(GravityCompat.START);
                }



            }
        });

    }

    public void addingData()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new DrawerData(R.drawable.opp1,"My Upgrade Opportunity"));
        arrayList.add(new DrawerData(R.drawable.profile,"My Government Support"));
        arrayList.add(new DrawerData(R.drawable.profile,"My Business Profile"));
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
                Toast.makeText(UpgradeBusinessActivity.this,"Notifications",Toast.LENGTH_LONG).show();
                break;

            case R.id.menuContact:
                Toast.makeText(UpgradeBusinessActivity.this,"Contact",Toast.LENGTH_LONG).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadEventFragment() {

        EventsFragment frg=new EventsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.BusinessContainer,frg);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        // moveTaskToBack(true);
    }


}
