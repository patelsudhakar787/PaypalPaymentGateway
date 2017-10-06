package com.rlard.smartenergymeter.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rlard.smartenergymeter.R;
import com.rlard.smartenergymeter.pojo.Data;
import com.rlard.smartenergymeter.pojo.MachineDetails;

import java.util.ArrayList;



public class DrawerActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ListView listViewDrawer;
    TextView lblTitle;
    private static int i=0;
    ArrayList<Data> al = new ArrayList<>();
    ActionBar actionBar=null;
    private String list_machineurl="";
    private SharedPreferences sharedPreferences;
    private String clientId=null;
    private ArrayList<MachineDetails>arrayListmachines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerLayout =(DrawerLayout)findViewById(R.id.drawerClient);
        listViewDrawer=(ListView)findViewById(R.id.left_drawer_Client);


        arrayListmachines=new ArrayList<>();
        al=new ArrayList<>();


        getMachineDetails();
        sharedPreferences=this.getSharedPreferences("data",MODE_PRIVATE);
        clientId=sharedPreferences.getString("clientId","");


        if(clientId !=null) {
            for(MachineDetails machineDetails:arrayListmachines)
            {
                if(machineDetails.getClientid().equals(clientId))
                {
                    al.add(new Data(machineDetails.getMachineid(),R.drawable.ic_nav5));
                }
            }

        }

ListViewAdapter adapter=new ListViewAdapter();
        listViewDrawer.setAdapter(adapter);
        //-------

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
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));


        //click listener on lisview
        listViewDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(DrawerActivity.this,GraphActivity.class);
                startActivity(intent);
            }
        });

    }





    //adapter class
    class ListViewAdapter extends ArrayAdapter<Data>
    {

        public ListViewAdapter() {
            super(DrawerActivity.this,R.layout.drawer_item_layout,al);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View itemView=inflater.inflate(R.layout.drawer_item_layout,parent,false);
            TextView textViewlbl=(TextView)itemView.findViewById(R.id.lbl);
            TextView textViewimage=(TextView)itemView.findViewById(R.id.image);
            Data data=al.get(position);
            textViewlbl.setText(data.getTexts());
            textViewimage.setBackgroundResource(data.getResources());
            return itemView;
        }
    }



    public void getMachineDetails()
    {
        MachineDetails machineDetails1=new MachineDetails("client1","Sentinal_1");
        MachineDetails machineDetails2=new MachineDetails("client1","Sentinal_2");
        MachineDetails machineDetails3=new MachineDetails("client1","Sentinal_3");
        MachineDetails machineDetails4=new MachineDetails("client1","Sentinal_4");
        MachineDetails machineDetails5=new MachineDetails("client2","Sentinal_1");
        MachineDetails machineDetails6=new MachineDetails("client2","Sentinal_2");
        arrayListmachines.add(machineDetails1);
        arrayListmachines.add(machineDetails2);
        arrayListmachines.add(machineDetails3);
        arrayListmachines.add(machineDetails4);
        arrayListmachines.add(machineDetails5);
        arrayListmachines.add(machineDetails6);
    }

}
