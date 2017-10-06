package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sudhakar.amled.R;
import com.example.sudhakar.amled.pojo.GInfo;

import java.util.ArrayList;

public class GeneralInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView listViewginfo;
    private ArrayList<GInfo>arrayList;
    private Button btn_next;
    private Button btn_privious;
    private ActionBar actionBar=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);
        listViewginfo=(ListView)findViewById(R.id.listview);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_privious=(Button)findViewById(R.id.btn_previous);
        arrayList=new ArrayList<>();
        getDataInList();

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();
        //settind Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listViewginfo.setAdapter(adapter);
    }




    public void getDataInList()
    {

        arrayList.add(new GInfo("A","Thermal Conductivity - Excellent\n Life Span: 50,000 hours\nWarrenty:3-5 years"));
        arrayList.add(new GInfo("B","Thermal Conductivity - Good\n Life Span: 30,000 hours\nWarrenty:2 years"));
        arrayList.add(new GInfo("C","Thermal Conductivity - Satifactory\n Life Span: 20,000 hours\nWarrenty:1 year"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:

                    Intent intent = new Intent(com.example.sudhakar.amled.activities.GeneralInfoActivity.this, com.example.sudhakar.amled.activities.ChooseLEDActivity.class);
                    startActivity(intent);

                break;

            case R.id.btn_previous:
                Intent intent1=new Intent(com.example.sudhakar.amled.activities.GeneralInfoActivity.this, com.example.sudhakar.amled.activities.SelectLightActivity.class);
                startActivity(intent1);
                break;
        }
    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<GInfo>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.GeneralInfoActivity.this,R.layout.listviewginfo,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.listviewginfo,parent,false);
            TextView textViewgrade=(TextView)view.findViewById(R.id.textviewgrade);
            TextView textViewGinfo=(TextView)view.findViewById(R.id.textviewinfo);
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
}
