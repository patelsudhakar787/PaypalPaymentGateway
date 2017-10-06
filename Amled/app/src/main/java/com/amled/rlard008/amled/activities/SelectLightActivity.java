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
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.SelectLight;

import java.util.ArrayList;

public class SelectLightActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<SelectLight>arrayList;
    private SharedPreferences sharedPreferences1;
    public SelectLight selectLight;
    private ActionBar actionBar=null;
    private ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_light);
        listView=(ListView)findViewById(R.id.listview);
       // imageView=(ImageView)findViewById(R.id.imagecategory);

        //---calling function
      //  scaleView(imageView,0f,1f);


        //action bar
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));



        sharedPreferences1=getSharedPreferences("lights",MODE_PRIVATE);
        arrayList=new ArrayList<>();
        actionBarTitleGravity();

        addData();

        //setting listView Adapter
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(SelectLightActivity.this,WelComePageActivity.class);
        startActivity(intent);
    }

    //adding data to arraylist
    public void addData()
    {
        arrayList.add(new SelectLight("TubeLight"));
        arrayList.add(new SelectLight("BayLight"));
        arrayList.add(new SelectLight("FloodLight"));
        arrayList.add(new SelectLight("StreetLight"));
        arrayList.add(new SelectLight("PanelLight"));
    }


    //Adapter  function
    class ListViewAdapter extends ArrayAdapter<SelectLight>
    {

        public ListViewAdapter() {
            super(SelectLightActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerviewpccover,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            textView.setTypeface(null, Typeface.BOLD_ITALIC);
           final CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            selectLight=arrayList.get(position);
            textView.setText(selectLight.getLight());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    selectLight=arrayList.get(position);

                    Log.e("selected lights",""+selectLight);
                    SharedPreferences.Editor editor=sharedPreferences1.edit();
                    editor.putString("light",selectLight.getLight());
                    editor.commit();


                    Intent intent = new Intent(SelectLightActivity.this, GeneralInfoActivity.class);
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

        textview.setText("Choose LED Category");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }

    public void scaleView(View v, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(
                1f, 1f, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setFillAfter(true); // Needed to keep the result of the animation
        anim.setDuration(3000);
        v.startAnimation(anim);
    }


}
