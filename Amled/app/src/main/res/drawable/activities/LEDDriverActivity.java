package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhakar.amled.R;
import com.example.sudhakar.amled.pojo.LEDDriver;

import java.util.ArrayList;

public class LEDDriverActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_next;
    private Button btn_previous;
    private ArrayList<LEDDriver>arrayList;
    private ListView listView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;
    private ActionBar actionBar=null;
    private LEDDriver ledDriver1=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leddriver);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_previous=(Button)findViewById(R.id.btn_previous);
        listView=(ListView)findViewById(R.id.listview);
        sharedPreferences=getSharedPreferences("cled3",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("cledcost3",MODE_PRIVATE);


        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();
        //caliing adapter function
        setLEDDriverAdapter();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                if(ledDriver1 != null) {
                    Intent intent = new Intent(com.example.sudhakar.amled.activities.LEDDriverActivity.this, LEDPCCoverActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(com.example.sudhakar.amled.activities.LEDDriverActivity.this,"Please Select One Options",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.LEDDriverActivity.this,MechanicalHousingActivity.class);
                startActivity(intent2);
                break;


        }
    }

    //function for setting adapter
    public void setLEDDriverAdapter()
    {
        arrayList=new ArrayList<LEDDriver>();
        arrayList.add(new LEDDriver("a)Low PF,\nConstant Current- No,\nConstant Voltage- No,\nOVP-No,\nVoltage RequestR(160-245)",250f));
        arrayList.add(new LEDDriver("b)Low PF,\nConstant Current- No,\nConstant Voltage- No,\nOVP-No,\nVoltage Request(160-245)",200f));
        arrayList.add(new LEDDriver("c)PF>0.9,\nConstant Current- Yes,\nConstant Voltage- Yes,\nOVP-No,\nVoltage Request(160-245)",150f));
        arrayList.add(new LEDDriver("d)Low PF,\nConstant Current- Yes,\nConstant Voltage- Yes,\nOVP-No,\nVoltage Request(160-245)",100f));
        arrayList.add(new LEDDriver("e)Low PF,\nConstant Current-Yes,\nConstant Voltage- Yes,\nOVP-Yes,\nVoltage Request(160-245)",50f));
        arrayList.add(new LEDDriver("f)Low PF,\nConstant Current- Yes,\nConstant Voltage- Yes,\nOVP-Yes,\nVoltage Request(160-245)",20f));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }



    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<LEDDriver>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.LEDDriverActivity.this,R.layout.recyclerleddriver,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerledpcb,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final LEDDriver ledDriver=arrayList.get(position);
            textView.setText(ledDriver.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledDriver1=arrayList.get(position);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("leddriver",ledDriver1.getConfiguration());
                    editor.commit();

                    SharedPreferences.Editor editor1=sharedPreferences1.edit();
                    editor1.putFloat("cost3",ledDriver1.getCost());
                    editor1.commit();
                    Log.e("getCost",""+ledDriver1.getCost());
                }
            });
            return view;
        }
    }
    //disable on back
    @Override
    public void onBackPressed() {

    }
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
