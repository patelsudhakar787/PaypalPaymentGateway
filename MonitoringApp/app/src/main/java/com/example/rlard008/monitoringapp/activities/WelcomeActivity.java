package com.example.rlard008.monitoringapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rlard008.monitoringapp.R;
import com.example.rlard008.monitoringapp.fragments.AboutUsFragment;
import com.example.rlard008.monitoringapp.fragments.MainActivityFragment;
import com.example.rlard008.monitoringapp.fragments.MapViewFragment;
import com.example.rlard008.monitoringapp.pojo.Data;
import com.example.rlard008.monitoringapp.ui.LeftNavAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.rlard008.monitoringapp.R.id.drawerClient;
//Welcome activity,activity after login activity // it will show drawer and number of installed machines
public class WelcomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ListView listViewDrawer;
    TextView lblTitle;
    String temp = "";
    String url ="";
    ArrayList<String> arrayListMachine=new ArrayList<>();
    private static int i=0;
    ArrayList<Data> al = new ArrayList<>();
    ActionBar actionBar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        drawerLayout =(DrawerLayout)findViewById(drawerClient);

        listViewDrawer=(ListView)findViewById(R.id.left_drawer_Client);
        loadFragment();

        SharedPreferences sf =this.getSharedPreferences("param",MODE_PRIVATE);
        String clientId = sf.getString("clientId", "");
        url="http://1-dot-vibescope-158106.appspot.com/ListMachines?clientId="+clientId;
        sendRequest();



        //enable back navigation
        View c = getLayoutInflater().inflate(R.layout.action_bar_logo, null);
        lblTitle = (TextView) c.findViewById(R.id.title);
        lblTitle.setCompoundDrawablesWithIntrinsicBounds(R.drawable.line1,0,0,0);

        c.findViewById(R.id.feed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawers();
                else
                    drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        lblTitle.setOnClickListener(new View.OnClickListener() {
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

        //---load  fragment on option selected----

        listViewDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Data d = al.get(position);
                temp = d.getTexts();
                String Machine_Id=temp;


                if (Machine_Id.equals("About") || Machine_Id.equals("Help") || Machine_Id.equals("Logout"))
                {
                    if (Machine_Id.equals("About")) {

                        AboutUsFragment frg=new AboutUsFragment();
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        ft.replace(R.id.container,frg);
                        ft.commit();


                        drawerLayout.closeDrawer(GravityCompat.START);
                    }
                    if (Machine_Id.equals("Logout")) {
                        Intent logout = new Intent(WelcomeActivity.this,LoginActivity.class);
                        startActivity(logout);
                        drawerLayout.closeDrawer(GravityCompat.START);

                        finish();
                    }
                    if (Machine_Id.equals("Help")) {

                    }
                }
                else {
                    SharedPreferences sp = getSharedPreferences("param", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("machineId", Machine_Id);
                    editor.commit();
                    allFragments();


                    drawerLayout.closeDrawer(GravityCompat.START);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)

        {
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else
                drawerLayout.openDrawer(GravityCompat.START);
        }


        return super.onOptionsItemSelected(item);
    }

    //functions for loading fragments
    public void allFragments()
    {
        MainActivityFragment frg=new MainActivityFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,frg);
        ft.commit();

    }

    public void sendRequest()
    {
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jo;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jo = jsonArray.getJSONObject(i);
                        String machineID = jo.getString("machine_id");
                        arrayListMachine.add(machineID);
                    }
                    if(arrayListMachine==null)
                    {
                        Toast.makeText(WelcomeActivity.this,"Connection Problem",Toast.LENGTH_LONG).show();
                    }
                    else {


                        String[] machineArr = arrayListMachine.toArray(new String[arrayListMachine.size()]);
                        for(i=0;i<machineArr.length;i++) {
                            al.add(new Data(machineArr[i], new int[] {
                                    R.drawable.ic_nav1, R.drawable.ic_nav1_sel }));
                        }

                        al.add(new Data("About" , new int[] {
                                R.drawable.ic_nav5, R.drawable.ic_nav5_sel }));

                        al.add(new Data("Help" , new int[] {
                                R.drawable.ic_nav6, R.drawable.ic_nav6_sel }));

                        al.add(new Data("Logout" , new int[] {
                                R.drawable.ic_nav4, R.drawable.ic_nav4_sel }));

                        LeftNavAdapter adapter = new LeftNavAdapter(WelcomeActivity.this,al);

                        listViewDrawer.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(WelcomeActivity.this,"Unable to connect to Server. pls try again",Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


//loading Fragment

    public void loadFragment() {

        MapViewFragment frg = new MapViewFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,frg);
        ft.commit();
    }

}

