package com.rlard.tubelighttestingrack.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import com.rlard.tubelighttestingrack.R;
import com.rlard.tubelighttestingrack.fragment.IndicatorFragment;
import com.rlard.tubelighttestingrack.pojo.RolesData;

import java.util.ArrayList;

public class DrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView listViewdata;
    private ArrayList<RolesData> arrayListlistview;
    private ActionBar actionBar;
    private TextView actionbartitle;
    private ImageView imageView;
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

        textViewname=(TextView)findViewById(R.id.textname);

        arrayListlistview=new ArrayList<>();
        setDrawerLayout();

        //shared Preferences
        sharedPreferences=getSharedPreferences("data", Context.MODE_PRIVATE);
        String empname=sharedPreferences.getString("personName","");

        imageurl=sharedPreferences.getString("url","");

        Log.e("url","---->"+imageurl);
        textViewname.setText(empname);

        imageRequest();



        //loading gragment
        loadingFragment();
        //click Listener on ListView
        listViewdata.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent=new Intent(DrawerActivity.this,GraphActivity.class);
                        startActivity(intent);
                        break;
                     case 1:
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
        arrayListlistview.add(new RolesData(R.drawable.drawerlogo,"Energy Meter"));
        arrayListlistview.add(new RolesData(R.drawable.exit,"Logout"));
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



    public void loadingFragment()
    {
        IndicatorFragment indicatorFragment=new IndicatorFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,indicatorFragment);
        ft.commit();
    }

}
