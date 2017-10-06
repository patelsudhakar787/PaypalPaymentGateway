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
import com.amled.rlard008.amled.pojo.MechanicalHousing;

import java.util.ArrayList;

public class MechanicalHousingActivity extends AppCompatActivity {

  private ListView listView;
    private SharedPreferences sfmhousing;

    private ArrayList<MechanicalHousing>arrayList;
    private ActionBar actionBar=null;
    private MechanicalHousing ledConfigurationP1=null;


    private String light="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledconfig);

       listView=(ListView)findViewById(R.id.listview);
        sfmhousing=getSharedPreferences("mhousingobj",MODE_PRIVATE);


        //crating object


        //getting data from shared preferences
       SharedPreferences sharedPreferences10=getSharedPreferences("lights",MODE_PRIVATE);
        light=sharedPreferences10.getString("light","");
        if(light.equals("TubeLight"))
        {
            settubelightmHousingAdapter();
        }
        if(light.equals("BayLight"))
        {
            setbaylightmHousingAdapter();
             }
        if(light.equals("FloodLight"))
        {
            setfloodlightmHousingAdapter();
         }
        if(light.equals("StreetLight"))
        {
            setstreetlightmHousingAdapter();

         }
        if(light.equals("PanelLight"))
        {
         setpanellightmHousingAdapter();
        }
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));
actionBarTitleGravity();



    }



    //function for setting adapter
    public void settubelightmHousingAdapter()
    {
        arrayList=new ArrayList<MechanicalHousing>();
        arrayList.add(new MechanicalHousing("High Quality Aluminium","A"));
        arrayList.add(new MechanicalHousing("Low Qulaity Aluminium","B"));
        arrayList.add(new MechanicalHousing("Plastic","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }

    public void setpanellightmHousingAdapter()
    {
        arrayList=new ArrayList<MechanicalHousing>();
        arrayList.add(new MechanicalHousing("Aluminium\nDie cast\nHeavy","A"));
        arrayList.add(new MechanicalHousing("Aluminium Die cast\nwith plastic parts\nLight weight","B"));
        arrayList.add(new MechanicalHousing("Plastic","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }
    public void setbaylightmHousingAdapter()
    {
        arrayList=new ArrayList<MechanicalHousing>();
        arrayList.add(new MechanicalHousing("Aluminium\nDie cast\nHeavy","A"));
        arrayList.add(new MechanicalHousing("Aluminium Die cast\nwith plastic parts\nLight weight","B"));
        arrayList.add(new MechanicalHousing("Plastic","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }
    public void setfloodlightmHousingAdapter()
    {
        arrayList=new ArrayList<MechanicalHousing>();
        arrayList.add(new MechanicalHousing("Aluminium\nDie cast\nHeavy","A"));
        arrayList.add(new MechanicalHousing("Aluminium Die cast\nwith plastic parts\nLight weight","B"));
        arrayList.add(new MechanicalHousing("Plastic","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }
    public void setstreetlightmHousingAdapter()
    {
        arrayList=new ArrayList<MechanicalHousing>();
        arrayList.add(new MechanicalHousing("Aluminium\nDie cast\nHeavy","A"));
        arrayList.add(new MechanicalHousing("Aluminium Die cast\nwith plastic parts\nLight weight","B"));
        arrayList.add(new MechanicalHousing("Plastic","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }

    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<MechanicalHousing>
    {

        public ListViewAdapter() {
            super(MechanicalHousingActivity.this,R.layout.recyclerleddriver,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerlecconfig,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.textviewconfig);
            TextView textView1=(TextView)view.findViewById(R.id.textviewgrade);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            textView1.setTypeface(null, Typeface.BOLD_ITALIC);
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final MechanicalHousing ledConfigurationP=arrayList.get(position);
            textView.setText(ledConfigurationP.getGrade());
            textView1.setText(ledConfigurationP.getConfig());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledConfigurationP1=arrayList.get(position);

                    String grade="Grade "+ledConfigurationP1.getGrade();
                    SharedPreferences.Editor editor=sfmhousing.edit();
                    editor.putString("mhousing1",grade);
                    editor.putString("mhousing2",ledConfigurationP1.getConfig());
                    editor.putString("mhousinggrade",""+ledConfigurationP1.getGrade());
                    editor.commit();


                    Intent intent = new Intent(MechanicalHousingActivity.this, LEDDriverActivity.class);
                    startActivity(intent);

                    checkBox.setChecked(false);

                }
            });
            return view;
        }
    }



    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("Mechanical Housing");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
