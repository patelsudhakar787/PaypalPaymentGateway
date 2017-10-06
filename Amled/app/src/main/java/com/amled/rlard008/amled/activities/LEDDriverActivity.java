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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.LEDDriver;

import java.util.ArrayList;

public class LEDDriverActivity extends AppCompatActivity  {

    private ArrayList<LEDDriver>arrayList;
    private ListView listView;
    private SharedPreferences sfleddriver;

    private ActionBar actionBar=null;
    private LEDDriver ledDriver1=null;

    private String light="";






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leddriver);

        listView=(ListView)findViewById(R.id.listview);
        sfleddriver=getSharedPreferences("leddriverobj",MODE_PRIVATE);


        //creating object
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));
        //getting data from shared preferences
        SharedPreferences sharedPreferences13=getSharedPreferences("lights",MODE_PRIVATE);
        light=sharedPreferences13.getString("light","");
        if(light.equals("TubeLight"))
        {
            setLEDDriverAdapter();
        }
        if(light.equals("BayLight"))
        {
            setLEDDriverAdapter();
        }
        if(light.equals("FloodLight"))
        {
            setLEDDriverAdapter();
        }
        if(light.equals("StreetLight"))
        {
            setLEDDriverAdapter();
        }
        if(light.equals("PanelLight")) {

            setLEDDriverAdapter();
        }
        actionBarTitleGravity();
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }



    //function for setting adapter
    public void setLEDDriverAdapter()
    {
        arrayList=new ArrayList<LEDDriver>();
        arrayList.add(new LEDDriver("PowerFacter=0.9,\nConstant Current- Yes,\nConstant Voltage- Yes,\nOverVoltage Protection-No,\nThermal OverVoltage Protection-Yes,\nShort Circuit-Yes,\nVoltage Request(160-245)","A"));
        arrayList.add(new LEDDriver("PowerFacter=0.9,\nConstant Current- Yes,\nConstant Voltage- Yes,\nOverVoltage Protection-No,\nThermal OverVoltage Protection-No,\nShort Circuit-No,\nVoltage Request(160-245)","B"));
        arrayList.add(new LEDDriver("PowerFacter=0.6,\nConstant Current- No,\nConstant Voltage- No,\nOverVoltage Protection-No,\nThermal OverVoltage Protection-No,\nShort Circuit-No,\nVoltage Request(160-245)","C"));
   }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<LEDDriver>
    {

        public ListViewAdapter() {
            super(LEDDriverActivity.this,R.layout.recyclerleddriver,arrayList);
        }



        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerledpcb,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final LEDDriver ledDriver=arrayList.get(position);
            textView.setText(ledDriver.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledDriver1=arrayList.get(position);


                    SharedPreferences.Editor editor=sfleddriver.edit();
                    editor.putString("leddriver",ledDriver1.getConfiguration());
                    editor.putString("leddrivergrade",ledDriver1.getGrade());
                    editor.commit();



                    Intent intent = new Intent(LEDDriverActivity.this, LEDPCCoverActivity.class);
                    startActivity(intent);
                    checkBox.setChecked(false);

                }
            });
            return view;
        }
    }
    //disable on back

    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("Choose LED Driver");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
