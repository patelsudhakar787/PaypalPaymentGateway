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

public class SelectLightActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView;
    private ArrayList<com.example.sudhakar.amled.pojo.SelectLight>arrayList;
    private SharedPreferences sharedPreferences;
    public com.example.sudhakar.amled.pojo.SelectLight selectLight;
    private ActionBar actionBar=null;
    private Button btn_next;
    private Button btn_privious;
    public  boolean status=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_light);
        listView=(ListView)findViewById(R.id.listview);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_privious=(Button)findViewById(R.id.btn_previous);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));


        sharedPreferences=getSharedPreferences("lights",MODE_PRIVATE);
        arrayList=new ArrayList<>();
        actionBarTitleGravity();

        addData();

        //setting listView Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }





    //adding data to arraylist
    public void addData()
    {
        arrayList.add(new com.example.sudhakar.amled.pojo.SelectLight("TubeLight"));
        arrayList.add(new com.example.sudhakar.amled.pojo.SelectLight("BayLight"));
        arrayList.add(new com.example.sudhakar.amled.pojo.SelectLight("FloodLight"));
        arrayList.add(new com.example.sudhakar.amled.pojo.SelectLight("StreetLight"));
        arrayList.add(new com.example.sudhakar.amled.pojo.SelectLight("PanelLight"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                if(status==true) {
                    Intent intent1 = new Intent(com.example.sudhakar.amled.activities.SelectLightActivity.this, GeneralInfoActivity.class);
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(com.example.sudhakar.amled.activities.SelectLightActivity.this,"Please Select One LED Light",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.SelectLightActivity.this, com.example.sudhakar.amled.activities.RegistrationActivity.class);
                startActivity(intent2);

                break;
        }

    }

    //Adapter  function
    class ListViewAdapter extends ArrayAdapter<com.example.sudhakar.amled.pojo.SelectLight>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.SelectLightActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerviewpccover,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
           final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            selectLight=arrayList.get(position);
            textView.setText(selectLight.getLight());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    status=true;
                    selectLight=arrayList.get(position);
                    Log.e("selected lights",""+selectLight);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("light",selectLight.getLight());
                    editor.commit();

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

        textview.setText("Choose LED Category");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
