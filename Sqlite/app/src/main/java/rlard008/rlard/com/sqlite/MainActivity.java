package rlard008.rlard.com.sqlite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Student>al=null;
    private EditText etrollno;
    private EditText etname;
    private Button btn_submit;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_show;
    private ListView lv;
    private DataBase dataBase=null;
    private Student student=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etrollno=(EditText)findViewById(R.id.rollno);
        etname=(EditText)findViewById(R.id.name);
        lv=(ListView)findViewById(R.id.lv);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_show=(Button)findViewById(R.id.btn_show);
        btn_delete=(Button)findViewById(R.id.btn_delete);
        btn_update=(Button)findViewById(R.id.btn_update);
        al=new ArrayList<>();
        dataBase=new DataBase(this);




        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollno= Integer.parseInt(etrollno.getText().toString());
                String name=etname.getText().toString();
                student=new Student(rollno,name);
              boolean result=dataBase.insertData(student);

                if(result == true)
                {
                    Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al=dataBase.getData();
                ListViewAdapter adapter=new ListViewAdapter();
                lv.setAdapter(adapter);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollno=Integer.parseInt(etrollno.getText().toString());
                String name=etname.getText().toString();
                dataBase.updateData(rollno,name);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rollno=Integer.parseInt(etrollno.getText().toString());
                dataBase.deleteData(rollno);
            }
        });
    }


    class ListViewAdapter extends ArrayAdapter<Student>
    {

        public ListViewAdapter() {
            super(MainActivity.this,R.layout.al_layout,al);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            convertView=inflater.inflate(R.layout.al_layout,parent,false);
            TextView tvrollno=(TextView)convertView.findViewById(R.id.rollno);
            TextView tvname=(TextView)convertView.findViewById(R.id.name);

            Student student=al.get(position);
            Log.e("Student","student"+student);
            tvrollno.setText(""+student.getRollno());
            tvname.setText(student.getName());
            return convertView;
        }
    }
}
