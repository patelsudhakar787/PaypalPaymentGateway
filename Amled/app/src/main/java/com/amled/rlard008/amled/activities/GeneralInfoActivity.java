package com.amled.rlard008.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.GInfo;

import java.util.ArrayList;

public class GeneralInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listViewginfo;
    private ArrayList<GInfo>arrayList;
    private Button btn_next;
    private Button btn_privious;
    private ActionBar actionBar=null;
    private SharedPreferences sharedPreferences;
    private ListView listview;
    private ArrayList<Integer>arrayListbgimages;
    private static int imageid=0;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);
        listViewginfo=(ListView)findViewById(R.id.listview);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_privious=(Button)findViewById(R.id.btn_previous);
        listview=(ListView)findViewById(R.id.listview);
        cardView=(CardView)findViewById(R.id.card);
        arrayList=new ArrayList<>();



        //calling function
        addingImages();

//getting data from shared preferences
        sharedPreferences=getSharedPreferences("lights",MODE_PRIVATE);
        String light=sharedPreferences.getString("light","");
        Log.e("Light","dsd"+light);
        if(light.equals("TubeLight"))
        {
            getTubeLightGeneralInfoList();
            imageid=arrayListbgimages.get(0);
            cardView.setBackgroundResource(imageid);
        }
        if(light.equals("BayLight"))
        {
            getBayLightGeneralInfoList();
            imageid=arrayListbgimages.get(1);
            cardView.setBackgroundResource(imageid);

        }
        if(light.equals("FloodLight"))
        {
            getFloodLightGeneralInfoList();
            imageid=arrayListbgimages.get(2);
            cardView.setBackgroundResource(imageid);
        }
        if(light.equals("StreetLight"))
        {
            getStreetLightGeneralInfo();
            imageid=arrayListbgimages.get(3);
            cardView.setBackgroundResource(imageid);
        }
        if(light.equals("PanelLight"))
        {
            getPanelLightGeneralInfo();
            imageid=arrayListbgimages.get(4);
            cardView.setBackgroundResource(imageid);
        }

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();

    }




    public void getTubeLightGeneralInfoList()
    {

        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span: 50,000 hours\nWarrenty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span: 30,000 hours\nWarrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satifactory\n Life Span: 20,000 hours\nWarrenty:1 year"));
        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);
    }

    public void getBayLightGeneralInfoList()
    {
        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span:50,000 hours\n Warrenty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span:20,000 hours\n Warrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satisfactory\n Life Span:15,000 hours\n Warrenty:1 years"));
        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);
    }


    public void getFloodLightGeneralInfoList()
    {
        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span:50,000 hours\n Warranty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span:20,000 hours\n Warrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satisfactory\n Life Span:15,000 hours\n Warranty:1 years"));

        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);

    }

    public void getStreetLightGeneralInfo()
    {
        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span:50,000 hours\n Warrenty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span:20,000 hours\n Warrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satisfactory\n Life Span:15,000 hours\n Warrenty:1 years"));
        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);

    }

    public void getPanelLightGeneralInfo()
    {
        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span:50,000 hours\n Warrenty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span:20,000 hours\n Warrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satisfactory\n Life Span:15,000 hours\n Warrenty:1 years"));
        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:

                    Intent intent = new Intent(GeneralInfoActivity.this, ChooseLEDActivity.class);
                    startActivity(intent);

                break;

            case R.id.btn_previous:
                Intent intent1=new Intent(GeneralInfoActivity.this,SelectLightActivity.class);
                startActivity(intent1);
                break;
        }
    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<GInfo>
    {

        public ListViewAdapter() {
            super(GeneralInfoActivity.this,R.layout.listviewginfo,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.listviewginfo,parent,false);
            TextView textViewgrade=(TextView)view.findViewById(R.id.textviewgrade);
            TextView textViewGinfo=(TextView)view.findViewById(R.id.textviewinfo);
            textViewgrade.setTypeface(null, Typeface.BOLD_ITALIC);
            textViewGinfo.setTypeface(null, Typeface.BOLD_ITALIC);
            GInfo generalinfo=arrayList.get(position);
            textViewgrade.setText(generalinfo.getGrade());
            textViewGinfo.setText(generalinfo.getConfig());
            return view;
        }
    }


    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("General Information");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }

    @Override
    public void onBackPressed() {

    }


    public void addingImages()
    {
        arrayListbgimages=new ArrayList<>();
        arrayListbgimages.add(R.drawable.tubelight);
        arrayListbgimages.add(R.drawable.baylight);
        arrayListbgimages.add(R.drawable.floodlight);
        arrayListbgimages.add(R.drawable.streetlight);
        arrayListbgimages.add(R.drawable.panellight);
    }

}
