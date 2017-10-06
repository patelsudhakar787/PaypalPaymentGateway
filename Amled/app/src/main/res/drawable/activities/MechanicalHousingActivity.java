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

import java.util.ArrayList;

public class MechanicalHousingActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_next;
    private Button btn_previous;
  private ListView listView;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;
    private ArrayList<com.example.sudhakar.amled.pojo.MechanicalHousing>arrayList;
    private ActionBar actionBar=null;
    private com.example.sudhakar.amled.pojo.MechanicalHousing ledConfigurationP1=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledconfig);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_previous=(Button)findViewById(R.id.btn_previous);
       listView=(ListView)findViewById(R.id.listview);
        sharedPreferences=getSharedPreferences("cled2",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("cledcost2", MODE_PRIVATE);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));
actionBarTitleGravity();
        //callling function for setting adapter
        setChooseLEDAdapter();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                if(ledConfigurationP1 != null) {
                    Intent intent = new Intent(com.example.sudhakar.amled.activities.MechanicalHousingActivity.this, com.example.sudhakar.amled.activities.LEDDriverActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(com.example.sudhakar.amled.activities.MechanicalHousingActivity.this,"Please Select One Option",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.MechanicalHousingActivity.this, com.example.sudhakar.amled.activities.LEDPCBActivity.class);
                startActivity(intent2);
                break;


        }
    }

    //function for setting adapter
    public void setChooseLEDAdapter()
    {
        arrayList=new ArrayList<com.example.sudhakar.amled.pojo.MechanicalHousing>();
        arrayList.add(new com.example.sudhakar.amled.pojo.MechanicalHousing("High Quality Aluminium","A",200));
        arrayList.add(new com.example.sudhakar.amled.pojo.MechanicalHousing("Low Qulaity Aluminium","B",150));
        arrayList.add(new com.example.sudhakar.amled.pojo.MechanicalHousing("Plastic","C",100));
     //   arrayList.add(new MechanicalHousing("d) Aluminium","A"));


        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<com.example.sudhakar.amled.pojo.MechanicalHousing>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.MechanicalHousingActivity.this,R.layout.recyclerleddriver,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerlecconfig,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.textviewconfig);
            TextView textView1=(TextView)view.findViewById(R.id.textviewgrade);
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final com.example.sudhakar.amled.pojo.MechanicalHousing ledConfigurationP=arrayList.get(position);
            textView.setText(ledConfigurationP.getConfig());
            textView1.setText(ledConfigurationP.getGrade());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledConfigurationP1=arrayList.get(position);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("ledconfig1",ledConfigurationP.getGrade());
                    editor.putString("ledconfig2",ledConfigurationP.getConfig());
                    editor.commit();

                    SharedPreferences.Editor editor1=sharedPreferences1.edit();
                    editor1.putFloat("cost2",ledConfigurationP1.getCost());
                    editor1.commit();
                    Log.e("getCost",""+ledConfigurationP1.getCost());

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

        textview.setText("Mechanical Housing");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
