package com.example.sudhakar.rfdms_app.activities;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sudhakar.rfdms_app.R;
import com.example.sudhakar.rfdms_app.pojo.Data;
import com.example.sudhakar.rfdms_app.pojo.MachineDetails;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {
    private TextView textView;
    private GridView gridView;
    ArrayList<Data> al = new ArrayList<>();
    ActionBar actionBar=null;
    private String list_machineurl="";
    private SharedPreferences sharedPreferences;
    private String clientId=null;
    private ArrayList<MachineDetails>arrayListmachines;
    private ArrayList<Integer>arrayListcolor;
    private String marker="";
    private String sensor="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView=(GridView)findViewById(R.id.gridviewItem);
        textView=(TextView)findViewById(R.id.text);
        arrayListmachines=new ArrayList<>();
        al=new ArrayList<>();
        arrayListcolor=new ArrayList<>();

        //creating object
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7883d9")));
        SharedPreferences sharedPreferences1=getSharedPreferences("map",MODE_PRIVATE);
        marker=sharedPreferences1.getString("marker","");

        textView.setText("RFDMS("+marker+")");

        addingColor();

        getMachineDetails();

        sharedPreferences=this.getSharedPreferences("data",MODE_PRIVATE);
        clientId=sharedPreferences.getString("clientId","");
        Log.e("clientId-----",""+clientId);




//        Intent intent=new Intent(GridViewActivity.this,GraphActivity.class);
//        startActivity(intent);

//        list_machineurl="http://10.10.0.220:8080/RFDMS/ListMachines?client_id="+clientId;
        Log.e("url",""+list_machineurl);
        if(clientId !=null) {
            int i=0;
            for(MachineDetails machineDetails:arrayListmachines)
            {

                if(machineDetails.getClientid().equals(clientId))
                {
                    al.add(new Data(machineDetails.getMachineid(),arrayListcolor.get(i)));
                }
i++;


            }

        }

ListViewAdapter adapter=new ListViewAdapter();
        gridView.setAdapter(adapter);



        //click listener on lisview
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MachineDetails machineDetails=arrayListmachines.get(position);
                String channel=machineDetails.getMachineid();
                if(position ==1 || position ==2 || position ==3 || position==4)
                {

                    Intent intent=new Intent(GridViewActivity.this,SensorActivity.class);
                    intent.putExtra("channel",channel);
                    startActivity(intent);
                }
                if(position == 5)
                {
                    moveTaskToBack(true);
                    finish();
                }
                if(position==0) {
                    Intent intent = new Intent(GridViewActivity.this, GraphActivity.class);
                    startActivity(intent);
                }

            }
        });

    }





    //adapter class
    class ListViewAdapter extends ArrayAdapter<Data>
    {

        public ListViewAdapter() {
            super(GridViewActivity.this,R.layout.drawer_item_layout,al);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View itemView=inflater.inflate(R.layout.drawer_item_layout,parent,false);
            TextView textViewlbl=(TextView)itemView.findViewById(R.id.lbl);
            ImageView textViewimage=(ImageView) itemView.findViewById(R.id.image);
            Data data=al.get(position);
            textViewlbl.setText(data.getTexts());
            textViewimage.setBackgroundColor(data.getResources());
            if(position ==5)
            {
                textViewimage.setBackgroundResource(R.drawable.exit);
            }
            return itemView;
        }
    }



    public void getMachineDetails()
    {
        MachineDetails machine1Details1=new MachineDetails("client1","Electric Load");
        MachineDetails machine1Details2=new MachineDetails("client1","Temperature Sensor");
        MachineDetails machine1Details3=new MachineDetails("client1","Light Sensor");
        MachineDetails machine1Details4=new MachineDetails("client1","Humidity Sensor");
        MachineDetails machine1Details5=new MachineDetails("client1","Door Sensor");
        MachineDetails machine1Details6=new MachineDetails("client1","Exit");
        MachineDetails machine2Details1=new MachineDetails("client2","Electric Load");
        MachineDetails machine2Details2=new MachineDetails("client2","Temperature Sensor");
        MachineDetails machine2Details3=new MachineDetails("client2","Light Sensor");
        MachineDetails machine2Details4=new MachineDetails("client2","Humidity Sensor");
        MachineDetails machine2Details5=new MachineDetails("client2","Door Sensor");
        MachineDetails machine2Details6=new MachineDetails("client2","Exit");

        arrayListmachines.add(machine1Details1);
        arrayListmachines.add(machine1Details2);
        arrayListmachines.add(machine1Details3);
        arrayListmachines.add(machine1Details4);
        arrayListmachines.add(machine1Details5);
        arrayListmachines.add(machine1Details6);

        arrayListmachines.add(machine2Details1);
        arrayListmachines.add(machine2Details2);
        arrayListmachines.add(machine2Details3);
        arrayListmachines.add(machine2Details4);
        arrayListmachines.add(machine2Details5);
        arrayListmachines.add(machine2Details6);



    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//
//        MenuInflater menuInflater=getMenuInflater();
//        menuInflater.inflate(R.menu.menu,menu);
//
//
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId())
//        {
//
//            case R.id.exit:
//                moveTaskToBack(true);
//                finish();
//                break;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }




    public void addingColor()
    {
        arrayListcolor.add(Color.parseColor("#569473"));
        arrayListcolor.add(Color.parseColor("#569473"));
        arrayListcolor.add(Color.parseColor("#569473"));
        arrayListcolor.add(Color.parseColor("#569473"));
        arrayListcolor.add(Color.parseColor("#569473"));
        arrayListcolor.add(R.drawable.exit);

    }


//    private void actionBarTitleGravity() {
//        // TODO Auto-generated method stub
//
//        TextView textview = new TextView(getApplicationContext());
//
//        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
//
//        textview.setLayoutParams(layoutparams);
//
//        textview.setText("Choose LED Driver");
//
//        textview.setTextColor(Color.BLACK);
//
//        textview.setGravity(Gravity.CENTER);
//
//        textview.setTextSize(20);
//
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//
//        actionBar.setCustomView(textview);
//
//    }


}

