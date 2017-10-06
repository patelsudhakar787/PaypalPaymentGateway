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
import com.amled.rlard008.amled.pojo.LEDPCBOption;

import java.util.ArrayList;

public class LEDPCBActivity extends AppCompatActivity {

    private ListView listView;
    private ListView listView1;
    private ArrayList<LEDPCBOption> arrayList;
    private SharedPreferences sfledpcb;
    private ActionBar actionBar=null;
    private LEDPCBOption ledpcbOption1=null;
    private TextView textViewlength1;
    private TextView getTextViewlength2;
    private static final String length1="Length : 2Ft";
    private static final String length2="Length : 4Ft";
    private String light="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);

        listView=(ListView)findViewById(R.id.listview);
        listView1=(ListView)findViewById(R.id.listview1);
        textViewlength1=(TextView)findViewById(R.id.textlength1);
        getTextViewlength2=(TextView)findViewById(R.id.textlength2);
        textViewlength1.setText(length1);
        getTextViewlength2.setText(length2);

        //creating object
        sfledpcb=getSharedPreferences("ledpcbobj",MODE_PRIVATE);



        //getting data from shared preferences
        SharedPreferences sharedPreferences7=getSharedPreferences("lights",MODE_PRIVATE);
       light=sharedPreferences7.getString("light","");
        if(light.equals("TubeLight"))
        {
            //calling adapter function
settubelightLEDPCBAdapter();
        }
        if(light.equals("BayLight"))
        {
setbaylightLEDPCBAdapter();
        }
        if(light.equals("FloodLight"))
        {
setfloodlightLEDPCBAdapter();
        }
        if(light.equals("StreetLight"))
        {
setstreetlightLEDPCBAdapter();
        }
        if(light.equals("PanelLight"))
        {
setpanellightLEDPCBAdapter();
        }
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();

        ListViewAdapter1 adapter=new ListViewAdapter1();
        listView.setAdapter(adapter);

        ListViewAdapter2 adapter1=new ListViewAdapter2();
        listView1.setAdapter(adapter1);

    }



    //function for setting adapter
    public void settubelightLEDPCBAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nWidth- 16mm,\nThickness- 0.9mm","A"));
        arrayList.add(new LEDPCBOption("Garde B,\nAluminium ,\nWidth- 9mm,\nThickness- 0.8mm","B"));
        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm","C"));
    }
    public void setbaylightLEDPCBAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nThickness- 1.6mm","A"));
        arrayList.add(new LEDPCBOption("Garde B,\nAluminium ,\nThickness- 1mm","B"));
        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm","C"));

    }
    public void setfloodlightLEDPCBAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nThickness- 1.6mm","A"));
        arrayList.add(new LEDPCBOption("Garde B,\nAluminium ,\nThickness- 1mm","B"));
        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm","C"));
    }
    public void setstreetlightLEDPCBAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nThickness- 1.6mm","A"));
        arrayList.add(new LEDPCBOption("Garde B,\nAluminium ,\nThickness- 1mm","B"));
        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm","C"));
    }
    public void setpanellightLEDPCBAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nThickness- 1.6mm","A"));
        arrayList.add(new LEDPCBOption("Garde B,\nAluminium ,\nThickness- 1mm","B"));
        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm","C"));
    }


    //Adapter  function

    class ListViewAdapter1 extends ArrayAdapter<LEDPCBOption>
    {

        public ListViewAdapter1() {
            super(LEDPCBActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerledpcb,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final LEDPCBOption ledpcbOption=arrayList.get(position);
            textView.setText(ledpcbOption.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledpcbOption1=arrayList.get(position);

                    String data=length1+"\n"+ledpcbOption1.getConfiguration();
                    SharedPreferences.Editor editor=sfledpcb.edit();
                    editor.putString("ledpcb",data);
                    editor.putString("ledpcbgrade",""+ledpcbOption1.getGrade());
                    editor.commit();


                    Intent intent = new Intent(LEDPCBActivity.this, MechanicalHousingActivity.class);
                    startActivity(intent);

                    checkBox.setChecked(false);
                }
            });
            return view;
        }
    }


    class ListViewAdapter2 extends ArrayAdapter<LEDPCBOption>
    {

        public ListViewAdapter2() {
            super(LEDPCBActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerledpcb,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final LEDPCBOption ledpcbOption=arrayList.get(position);
            textView.setText(ledpcbOption.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledpcbOption1=arrayList.get(position);

                    String data=length2+"\n"+ledpcbOption1.getConfiguration();

                    SharedPreferences.Editor editor=sfledpcb.edit();
                    editor.putString("ledpcb",data);
                    editor.putString("ledpcbgrade",""+ledpcbOption1.getGrade());
                    editor.commit();

                    Intent intent = new Intent(LEDPCBActivity.this, MechanicalHousingActivity.class);
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

        textview.setText("Choose LED PCB");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
