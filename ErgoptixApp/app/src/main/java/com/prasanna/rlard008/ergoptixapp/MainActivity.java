package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.prasanna.rlard008.ergoptixapp.Pojo.Data;
import com.prasanna.rlard008.ergoptixapp.UI.LeftNavAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ListView listViewDrawer;
    TextView lblTitle;
    String temp = "";
    String stat;

    Button buttonPersonalTrial,buttonMicroscope,buttonWorkhopSupport,buttonSubmitTTL;

    ArrayList<Data> al = new ArrayList<>();
    ActionBar actionBar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout =(DrawerLayout)findViewById(R.id.drawerClient);
        listViewDrawer=(ListView)findViewById(R.id.left_drawer_Client);


        buttonMicroscope = (Button) findViewById(R.id.microscope);
        buttonPersonalTrial = (Button) findViewById(R.id.personalTrial);

        buttonSubmitTTL = (Button) findViewById(R.id.TTL);
        buttonWorkhopSupport = (Button) findViewById(R.id.workshopSupport);

        sendRequest();


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


        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));


        listViewDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                Data d = al.get(position);
                temp = d.getTexts();
                String selected_item=temp;

                if (selected_item.equals("About Us")) {

                    Intent intent = new Intent(MainActivity.this, AboutUSActivity.class);
                    startActivity(intent);

                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (selected_item.equals("Shop Now")) {

                    Uri uri = Uri.parse("https://www.ergoptix.com/buy-now");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                    drawerLayout.closeDrawer(GravityCompat.START);

                }


                if (selected_item.equals("Learn")) {

                    Intent intent = new Intent(MainActivity.this, LearnActivity.class);
                    startActivity(intent);

                    drawerLayout.closeDrawer(GravityCompat.START);

                }

                if (selected_item.equals("Product Videos")) {

                    Uri uri = Uri.parse("https://www.ergoptix.com/videos");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                    drawerLayout.closeDrawer(GravityCompat.START);

                }


            }
        });  //end of list view drawer

        // Starting on click events


        buttonWorkhopSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://139.59.79.196:8080/ErgoptixApplication1/Index.jsp");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        buttonMicroscope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MicroscopeRequestActivity.class);
                startActivity(intent);

            }
        });

        buttonPersonalTrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://139.59.79.196:8080/ErgoptixApplication1/PersonalEnquiry.jsp");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        buttonSubmitTTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent TTL = new Intent(MainActivity.this,CalcEyeDistanceActivity.class);
                startActivity(TTL);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("status", stat);

        editor.commit();


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

        if(item.getItemId()== R.id.shop)

        {
            Uri uri = Uri.parse("https://www.ergoptix.com/buy-now");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }

        if(item.getItemId()== R.id.book)

        {
            Uri uri = Uri.parse("https://www.ergoptix.com/buy-now/Promotions-c23270685");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

        }


        return super.onOptionsItemSelected(item);
    }


    public void sendRequest()
    {


        al.add(new Data("Shop Now" , new int[] {
        R.drawable.shopcart1, R.drawable.shopcart1}));


        al.add(new Data("Learn" , new int[] {
                R.drawable.learn1, R.drawable.learn1 }));

        al.add(new Data("Product Videos" , new int[] {
                R.drawable.video1, R.drawable.video1 }));

        al.add(new Data("About Us" , new int[] {
                R.drawable.about1, R.drawable.about1 }));

        LeftNavAdapter adapter = new LeftNavAdapter(MainActivity.this,al);

        listViewDrawer.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.optionsmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
