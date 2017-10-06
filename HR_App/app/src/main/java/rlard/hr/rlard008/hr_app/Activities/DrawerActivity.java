package rlard.hr.rlard008.hr_app.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.Fragments.AdminFragment;
import rlard.hr.rlard008.hr_app.Fragments.DailyReportFragment;
import rlard.hr.rlard008.hr_app.Fragments.ImageFragment;
import rlard.hr.rlard008.hr_app.Fragments.ManualEntryFragment;
import rlard.hr.rlard008.hr_app.Fragments.MonthlyReportFragment;
import rlard.hr.rlard008.hr_app.Fragments.RolesFragment;
import rlard.hr.rlard008.hr_app.Fragments.TaskListFragment;
import rlard.hr.rlard008.hr_app.Fragments.UpdateRolesFragment;
import rlard.hr.rlard008.hr_app.Fragments.WeeklyReportFragment;
import rlard.hr.rlard008.hr_app.Pojo.RolesData;
import rlard.hr.rlard008.hr_app.R;

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView listViewdata;
    private ArrayList<RolesData> arrayListlistview;
    private ActionBar actionBar;
    private TextView actionbartitle;
    private ImageView imageView,imageView1;
    private TextView textViewname;
    private SharedPreferences sharedPreferences;
    private String imageurl="";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerdata);
        listViewdata=(ListView)findViewById(R.id.left_drawer_data);
        imageView=(ImageView)findViewById(R.id.image);
        imageView1=(ImageView)findViewById(R.id.drawerWelcome);
        textViewname=(TextView)findViewById(R.id.textname);

        arrayListlistview=new ArrayList<>();
        setDrawerLayout();





        loadingImages();


        //chaecking
        loadRoles();


        //shared Preferences
        sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        String empname=sharedPreferences.getString("personName","");

        imageurl=sharedPreferences.getString("url","");

        Log.e("url","---->"+imageurl);
        textViewname.setText(empname);

        imageRequest();

//service intent
//        Intent intent=new Intent(DrawerActivity.this, ServiceClass.class);
//        startService(intent);



        //click Listener on ListView
        listViewdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        loadingRolesFragment();
                        break;
                    case 1:
                        loadingManualEntryFragment();
                        break;
                    case 2:
                        loadingTaskListFragment();
                        break;
                    case 3:
                        loadingDailyReportFragment();
                        break;
                    case 4:
                        loadingWeeklyReportFragment();
                        break;
                    case 5:
                        loadingMonthlyReportFragment();
                        break;
                    case 6:
                        loadingUpdateFragment();
                        break;

                    case 7:
                        loadingAdminFragment();
                       break;
                    case 8:
                        moveTaskToBack(true);
                        finish();

                        break;
                }
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                {
                    drawerLayout.closeDrawers();
                }
            }
        });
    }

    public void setDrawerLayout()

    {
        arrayListlistview.add(new RolesData(R.drawable.role,"MyRoles"));
        arrayListlistview.add(new RolesData(R.drawable.entry,"ManualEntry"));
        arrayListlistview.add(new RolesData(R.drawable.list,"TaskList"));
        arrayListlistview.add(new RolesData(R.drawable.ic_nav1,"DailyReport"));
        arrayListlistview.add(new RolesData(R.drawable.ic_nav1,"WeeklyReport"));
        arrayListlistview.add(new RolesData(R.drawable.ic_nav1,"MonthlyReport"));
        arrayListlistview.add(new RolesData(R.drawable.entry,"Update Roles"));
        arrayListlistview.add(new RolesData(R.drawable.ic_nav4,"Admin"));
        arrayListlistview.add(new RolesData(R.drawable.exit,"Exit"));

        ListViewAdapter adapter=new ListViewAdapter();
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

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
       // moveTaskToBack(true);
        FragmentManager fragManager = getSupportFragmentManager();
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Fragment frag = fragManager.getFragments().get(count-1);
        FragmentTransaction ft=fragManager.beginTransaction();
        ft.replace(R.id.container,frag);
        ft.commit();
    }



    //loading fragments
    public void loadingDailyReportFragment()
    {
        DailyReportFragment dailyreportFragment=new DailyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,dailyreportFragment);
        ft.commit();
    }

    public void loadingWeeklyReportFragment()
    {
        WeeklyReportFragment weeklyReportFragment=new WeeklyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,weeklyReportFragment);
        ft.commit();
    }

    public void loadingMonthlyReportFragment()
    {
        MonthlyReportFragment monthlyReportFragment=new MonthlyReportFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,monthlyReportFragment);
        ft.commit();
    }

    public void loadingTaskListFragment()
    {
        TaskListFragment taskListFragment=new TaskListFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,taskListFragment);
        ft.commit();
    }

    public void loadingManualEntryFragment()
    {
        ManualEntryFragment manualEntryFragment=new ManualEntryFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,manualEntryFragment);
        ft.commit();

    }

    public void loadingUpdateFragment()
    {
        UpdateRolesFragment updateRolesFragment=new UpdateRolesFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,updateRolesFragment);
        ft.commit();
    }

    public void loadingAdminFragment()
    {
        AdminFragment adminFragment=new AdminFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,adminFragment);
        ft.commit();
    }


    public void loadingRolesFragment()
    {
        RolesFragment rolesFragment=new RolesFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,rolesFragment);
        ft.commit();
    }


   public void imageRequest()
   {
       ImageRequest imageRequest=new ImageRequest(imageurl, new Response.Listener<Bitmap>() {
           @Override
           public void onResponse(Bitmap response) {
        imageView.setImageBitmap(response);
           }
       },0,0,null,null);
       RequestQueue requestQueue= Volley.newRequestQueue(this);
       requestQueue.add(imageRequest);

   }


   class ListViewAdapter extends ArrayAdapter<RolesData>
   {

       public ListViewAdapter() {
           super(DrawerActivity.this,R.layout.layout_drawer_lv,arrayListlistview);
       }

       @NonNull
       @Override
       public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
           LayoutInflater inflater=getLayoutInflater();
           convertView=inflater.inflate(R.layout.layout_drawer_lv,parent,false);
           TextView textViewicon=(TextView)convertView.findViewById(R.id.text1);
           TextView textViewname=(TextView)convertView.findViewById(R.id.text2);

           RolesData rolesData=arrayListlistview.get(position);
           textViewicon.setCompoundDrawablesWithIntrinsicBounds(rolesData.getRoleicon(),0,0,0);
           textViewname.setText(rolesData.getRolename());

           return convertView;
       }
   }

    @Override
    protected void onStart() {
        super.onStart();

        // Store our shared preference
        SharedPreferences sp = getSharedPreferences("OURINFO", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("active", "true");
        ed.commit();
    }




    public void loadingImages()
    {
        ImageFragment imageFragment=new ImageFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,imageFragment);
        ft.addToBackStack("images");
        ft.commit();
    }

    public void loadRoles()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("flagrole", MODE_PRIVATE);
        String stat = sharedPreferences.getString("flag", "");
        if(stat.equals("y"))
        {
            loadingRolesFragment();
        }
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("flag","n");
        editor.commit();
    }

}
