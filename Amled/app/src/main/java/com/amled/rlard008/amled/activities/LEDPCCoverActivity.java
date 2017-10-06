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
import com.amled.rlard008.amled.pojo.LEDPCCover;

import java.util.ArrayList;

public class LEDPCCoverActivity extends AppCompatActivity  {

    private ListView listView;
    private ArrayList<LEDPCCover>arrayList;
    private ActionBar actionBar=null;

    private SharedPreferences sfledpccover;
    private LEDPCCover ledpcCover1=null;
    private String light="";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pccover);

      listView=(ListView)findViewById(R.id.listview);
         sfledpccover=getSharedPreferences("ledpccoverobj",MODE_PRIVATE);


        //getting data from shared preferences
        SharedPreferences sharedPreferences16=getSharedPreferences("lights",MODE_PRIVATE);
        light=sharedPreferences16.getString("light","");

        ///creating objects


        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));


        actionBarTitleGravity();
        setChooseLEDAdapter();




    }



    //function for setting adapter
    public void setChooseLEDAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new LEDPCCover("A","A"));
        arrayList.add(new LEDPCCover("B","B"));
        arrayList.add(new LEDPCCover("C","C"));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<LEDPCCover>
    {

        public ListViewAdapter() {
            super(LEDPCCoverActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerviewpccover,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
            final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
           final LEDPCCover ledpcCover=arrayList.get(position);
            textView.setText(ledpcCover.getGrade());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledpcCover1=arrayList.get(position);
                    String data="Grade "+ledpcCover1.getConfig();

                    SharedPreferences.Editor editor=sfledpccover.edit();
                    editor.putString("ledpccover",data);
                    editor.putString("ledpccovergrade",ledpcCover1.getGrade());
                    editor.commit();


                    Intent intent=new Intent(LEDPCCoverActivity.this,TotalCostActivity.class);
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

        textview.setText("Choose LED PCCover");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }

}
