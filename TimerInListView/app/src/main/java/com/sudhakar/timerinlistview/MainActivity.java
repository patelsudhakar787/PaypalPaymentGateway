package com.sudhakar.timerinlistview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Counter>allist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);

        allist=new ArrayList<>();
        Counter counter1 = new Counter(0);
        Counter counter2 = new Counter(1);
        Counter counter3 = new Counter(2);
        Counter counter4 = new Counter(3);
        Counter counter5 = new Counter(4);
        allist.add(counter1);
        allist.add(counter2);
        allist.add(counter3);
        allist.add(counter4);
        allist.add(counter5);

        setAdapter();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Timer timer=new Timer();
                TimerTask timerTask=new TimerTask() {
                    @Override
                    public void run() {



                    }
                };
                timer.schedule(timerTask,0,60*1000);
            }
        });
    }



    public class ListViewAdapter extends ArrayAdapter<Counter>
    {

        public ListViewAdapter() {
            super(MainActivity.this,R.layout.textlayout,allist);
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            convertView=inflater.inflate(R.layout.textlayout,parent,false);
            TextView textView=(TextView)convertView.findViewById(R.id.tv);

            Counter counter=allist.get(position);
            int time=counter.getCounter();
            time++;
            textView.setText(""+time);
            return convertView;
        }
    }
    public void clearData(ArrayList<Counter>allist)
    {
        for(int i=0;i<allist.size();i++)
        {
            allist.clear();
        }
    }
    public void setAdapter()
    {
        clearData(allist);
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
    }

}
