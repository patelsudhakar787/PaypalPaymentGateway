package com.amled.rlard008.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.ChooseLEDOption;

import java.util.ArrayList;

public class ChooseLEDActivity extends AppCompatActivity{

    private ListView listView;
    private ArrayList<ChooseLEDOption>arrayList;
    private SharedPreferences sfchooseled;

    private ActionBar actionbar=null;
    private String light="";
    private LinearLayout linearLayout;

    private ChooseLEDOption chooseLEDOption1=null;








    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_led);

        listView=(ListView)findViewById(R.id.listview);
        linearLayout=(LinearLayout)findViewById(R.id.linearchooseled);

        //creating object

        sfchooseled=getSharedPreferences("chooseledobj",MODE_PRIVATE);


        actionbar=getSupportActionBar();
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();


        //getting data from shared preferences
        SharedPreferences sharedPreferences4=getSharedPreferences("lights",MODE_PRIVATE);
        light=sharedPreferences4.getString("light","");
        if(light.equals("TubeLight"))
        {
            //calling adapter function
            settubelightChooseLEDAdapter();
        }
        if(light.equals("BayLight"))
        {
            setbaylightChooseLedAdapter();
        }
        if(light.equals("FloodLight"))
        {
            setfloodLightChooseLEDAdapter();
        }
        if(light.equals("StreetLight"))
        {
            setstreetLightChooseLEDAdapter();
        }
        if(light.equals("PanelLight"))
        {
            setpanelLightChooseLEDAdapter();
        }


    }



    //function for setting adapter
    public void settubelightChooseLEDAdapter()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCopper-Base Lining","A"));
        arrayList.add(new ChooseLEDOption("Grade-B (24-26 LM),\nCopper Wire,\nAluminium-Base Lining","B"));
        arrayList.add(new ChooseLEDOption("Grade-C (22-24 LM),\nCopper Wire,\nAluminium-Base Lining","C"));

        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }

    public void setbaylightChooseLedAdapter()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCopper-Base Lining","A"));
        arrayList.add(new ChooseLEDOption("Grade-B (24-26 LM),\nCopper Wire,\nAluminium-Base Lining", "B"));
        arrayList.add(new ChooseLEDOption("Grade-C (22-24 LM),\nCopper Wire,\nAluminium-Base Lining","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }

  public void setfloodLightChooseLEDAdapter()
  {
      arrayList=new ArrayList<>();
      arrayList.add(new ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCopper-Base Lining","A"));
      arrayList.add(new ChooseLEDOption("Grade-B (24-26 LM),\nCopper Wire,\nAluminium-Base Lining","B"));
      arrayList.add(new ChooseLEDOption("Grade-C (22-24 LM),\nCopper Wire,\nAluminium-Base Lining","C"));
      ListViewAdapter adapter=new ListViewAdapter();
      listView.setAdapter(adapter);

  }
    public void setstreetLightChooseLEDAdapter()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCopper-Base Lining","A"));
        arrayList.add(new ChooseLEDOption("Grade-B (24-26 LM),\nCopper Wire,\nAluminium-Base Lining","B"));
        arrayList.add(new ChooseLEDOption("Grade-C (22-24 LM),\nCopper Wire,\nAluminium-Base Lining","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }
    public void setpanelLightChooseLEDAdapter()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new ChooseLEDOption("Grade-A (26-28 LM),\nGold-Bond Wire,\nCopper-Base Lining","A"));
        arrayList.add(new ChooseLEDOption("Grade-B (24-26 LM),\nCopper Wire,\nAluminium-Base Lining","B"));
        arrayList.add(new ChooseLEDOption("Grade-C (22-24 LM),\nCopper Wire,\nAluminium-Base Lining","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<ChooseLEDOption>
    {

        public ListViewAdapter() {
            super(ChooseLEDActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recycler1chooseled,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
           final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final ChooseLEDOption chooseLEDOption=arrayList.get(position);
            textView.setText(chooseLEDOption.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("position",""+position);
                    chooseLEDOption1=arrayList.get(position);
                    SharedPreferences.Editor editor=sfchooseled.edit();
                    editor.putString("chooseled",""+chooseLEDOption1.getConfiguration());
                    editor.putString("chooseledgrade",""+chooseLEDOption1.getGrade());
                    editor.commit();
                    Log.e("chooseledconfig",""+chooseLEDOption1.getConfiguration());

                    Intent intent = new Intent(ChooseLEDActivity.this, LEDPCBActivity.class);
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

        textview.setText("Choose LED");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionbar.setCustomView(textview);

    }

}
