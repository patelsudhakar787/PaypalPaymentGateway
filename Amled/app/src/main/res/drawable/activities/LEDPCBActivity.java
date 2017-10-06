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

public class LEDPCBActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_next;
    private Button btn_previous;
    private ListView listView;
    private ListView listView1;
    private ArrayList<com.example.sudhakar.amled.pojo.LEDPCBOption> arrayList;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;
    private ActionBar actionBar=null;
    private com.example.sudhakar.amled.pojo.LEDPCBOption ledpcbOption1=null;
    private TextView textViewlength1;
    private TextView getTextViewlength2;
    private static final String length1="Length : 2Ft";
    private static final String length2="Length : 4Ft";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led);
        btn_next=(Button)findViewById(R.id.btn_next);
         btn_previous=(Button)findViewById(R.id.btn_previous);
       listView=(ListView)findViewById(R.id.listview);
        listView1=(ListView)findViewById(R.id.listview1);
        textViewlength1=(TextView)findViewById(R.id.textlength1);
        getTextViewlength2=(TextView)findViewById(R.id.textlength2);
        textViewlength1.setText(length1);
        getTextViewlength2.setText(length2);

        sharedPreferences=getSharedPreferences("cled4",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("cledcost4", MODE_PRIVATE);


        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

        actionBarTitleGravity();
        //calling adapter function
        setChooseLEDAdapter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                if(ledpcbOption1 != null) {
                    Intent intent = new Intent(com.example.sudhakar.amled.activities.LEDPCBActivity.this, MechanicalHousingActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(com.example.sudhakar.amled.activities.LEDPCBActivity.this,"Please Select One option",Toast.LENGTH_LONG).show();
                }
                break;


            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.LEDPCBActivity.this,ChooseLEDActivity.class);
                startActivity(intent2);
                break;

        }
    }

    //function for setting adapter
    public void setChooseLEDAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new com.example.sudhakar.amled.pojo.LEDPCBOption("Garde A,\nAluminium ,\nWidth- 16mm,\nThickness- 0.9mm",300f));
        arrayList.add(new com.example.sudhakar.amled.pojo.LEDPCBOption("Garde B,\nAluminium ,\nWidth- 9mm,\nThickness- 0.8mm",200f));
        arrayList.add(new com.example.sudhakar.amled.pojo.LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm",100f));
//        arrayList.add(new LEDPCBOption("Garde A,\nAluminium ,\nWidth- 16mm,\nThickness- 0.9mm"));
//        arrayList.add(new LEDPCBOption("Garde B,\nAluminium,\nWidth- 9mm,\nThickness- 0.8mm"));
//        arrayList.add(new LEDPCBOption("Garde C,\nFr4 ,\nWidth-9 mm,\nThickness- 0.8mm"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde B,\nsize-0.8mm,\nlength-2Ft"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde A,\nsize-0.8mm,\nlength-2Ft"));
//        arrayList.add(new LEDPCBOption("FR4,\nGarde -,\nsize-1.6mm,\nlength-4Ft"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde B,\nsize-1.6mm,\nlength-4Ft"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde A,\nsize-1.6mm,\nlength-4Ft"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde B,\nsize-1.6mm,\nlength-4Ft"));
//        arrayList.add(new LEDPCBOption("Al ,\nGarde A,\nsize-1.6mm,\nlength-4Ft"));

        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

        ListViewAdapter adapter1=new ListViewAdapter();
        listView1.setAdapter(adapter1);





    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<com.example.sudhakar.amled.pojo.LEDPCBOption>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.LEDPCBActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerledpcb,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
            final com.example.sudhakar.amled.pojo.LEDPCBOption ledpcbOption=arrayList.get(position);
            textView.setText(ledpcbOption.getConfiguration());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledpcbOption1=arrayList.get(position);

                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("ledpcb",ledpcbOption1.getConfiguration());
                    editor.commit();

                    SharedPreferences.Editor editor1=sharedPreferences1.edit();
                    editor1.putFloat("cost4",ledpcbOption1.getCost());
                    editor1.commit();

                    Log.e("gettCost",""+ledpcbOption1.getCost());

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

        textview.setText("Choose LED PCB");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }
}
