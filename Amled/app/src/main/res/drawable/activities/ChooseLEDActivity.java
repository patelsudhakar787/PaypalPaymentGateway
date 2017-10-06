package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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

public class ChooseLEDActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_next;
    private Button btn_previous;
    private ListView listView;
    private ArrayList<com.example.sudhakar.amled.pojo.ChooseLEDOption>arrayList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;
    private ActionBar actionbar=null;
    private String light="";
    private ArrayList<Integer>arrayListint;
    private com.example.sudhakar.amled.pojo.ChooseLEDOption chooseLEDOption1=null;
  //  int count=0;





    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_led);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_previous=(Button)findViewById(R.id.btn_previous);
       listView=(ListView)findViewById(R.id.listview);

        arrayListint = new ArrayList<>();
        sharedPreferences=getSharedPreferences("cled1",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("cledcost1",MODE_PRIVATE);

        actionbar=getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

actionBarTitleGravity();

        //getting data from shared preferences
        sharedPreferences=getSharedPreferences("lights",MODE_PRIVATE);
        light=sharedPreferences.getString("light","");
        if(light.equals("TubeLight"))
        {
            //calling adapter function
            setChooseLEDAdapter();
        }
        else {
            Toast.makeText(com.example.sudhakar.amled.activities.ChooseLEDActivity.this,"No Data for "+light,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_next:
                if(chooseLEDOption1 !=null) {
                    Intent intent = new Intent(com.example.sudhakar.amled.activities.ChooseLEDActivity.this, com.example.sudhakar.amled.activities.LEDPCBActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(com.example.sudhakar.amled.activities.ChooseLEDActivity.this,"Please Select One Option",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.ChooseLEDActivity.this,GeneralInfoActivity.class);
                startActivity(intent2);
                break;


        }
    }



    //function for setting adapter
    public void setChooseLEDAdapter()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new com.example.sudhakar.amled.pojo.ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCupper-Base Lining",300f));
        arrayList.add(new com.example.sudhakar.amled.pojo.ChooseLEDOption("Grade-B (24-26 LM),\nCupper Wire,\nAluminium-Base Lining",200f));
        arrayList.add(new com.example.sudhakar.amled.pojo.ChooseLEDOption("Grade-C (22-24 LM),\nCupper Wire,\nAluminium-Base Lining",100f));
//        arrayList.add(new ChooseLEDOption("Grade-B (22-24LM),\nGold-Bond Wire,\nCu-Base Lining"));
//        arrayList.add(new ChooseLEDOption("Grade-B (24-26LM),\nAl-Bond Wire,\nCu-Base Lining"));
//        arrayList.add(new ChooseLEDOption("Grade-B (24-26LM),\nGold-Bond Wire,\nCu-Base Lining"));
//        arrayList.add(new ChooseLEDOption("Grade-B (26-28LM),\nAl-Bond Wire,\nCu-Base Lining"));
//        arrayList.add(new ChooseLEDOption("Grade-B (20-22LM),\nGold-Bond Wire,\nCu-Base Lining"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }




    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<com.example.sudhakar.amled.pojo.ChooseLEDOption>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.ChooseLEDActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recycler1chooseled,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
           final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final com.example.sudhakar.amled.pojo.ChooseLEDOption chooseLEDOption=arrayList.get(position);
            textView.setText(chooseLEDOption.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("position",""+position);
                    chooseLEDOption1=arrayList.get(position);
                    Log.e("chooseled",""+chooseLEDOption1);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("led1",chooseLEDOption1.getConfiguration());
                    editor.commit();
                    SharedPreferences.Editor editor1=sharedPreferences1.edit();
                    editor1.putFloat("cost1",chooseLEDOption1.getCost());
                    editor1.commit();




                }
            });
            return view;
        }
    }
    //disable on back
    @Override
    public void onBackPressed()
    {

    }
    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

       TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("Choose LED");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionbar.setCustomView(textview);

    }

}
