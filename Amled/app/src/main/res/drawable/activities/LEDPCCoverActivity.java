package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class LEDPCCoverActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_next;
    private Button btn_previous;
    private ListView listView;
    private ArrayList<com.example.sudhakar.amled.pojo.LEDPCCover>arrayList;
    private ActionBar actionBar=null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences sharedPreferences1;
    private  String chooseled="";
    private  String ledconfig1="";
    private String ledconfig2="";
    private String leddriver="";
    private String ledpcb="";
    private  String ledpccover="";
    private String username="";
    private String useremailid="";
    private String usercontact="";
    private String useraddress="";
    private String config="";
    private String ledtype="";
    private com.example.sudhakar.amled.pojo.LEDPCCover ledpcCover1=null;

    static HashMap<String,String> postDataParams = new HashMap();
    private static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private static final String formurl="https://docs.google.com/a/rlard.com/forms/d/e/1FAIpQLScj0acY5RNo3qCsy1W4S7X8m1kIaSY-8LhUZ3dxKE5HnjpFCw/formResponse";
    private static final String usernamekey="entry.773328289";
    private static final String useremailidkey="entry.1996923482";
    private static final String usercontactkey="entry.166429336";
    private static final String useraddresskey="entry.1046569414";
    private static final String ledkey="entry.1068219086";
    private static final String ledpcbkey="entry.659910295";
    private static final String ledconfigkey="entry.1951311065";
    private static final String leddriverkey="entry.335290622";
    private static final String ledpccoverkey="entry.1863649757";
    private static final String ledtypekey="entry.395671749";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pccover);
        btn_next=(Button)findViewById(R.id.btn_next);
        btn_previous=(Button)findViewById(R.id.btn_previous);
      listView=(ListView)findViewById(R.id.listview);
        sharedPreferences=getSharedPreferences("cled5",MODE_PRIVATE);
        sharedPreferences1=getSharedPreferences("cledcost5",MODE_PRIVATE);


        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));


        actionBarTitleGravity();
        setChooseLEDAdapter();




    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                //check network connectivity
                boolean checknetwork= com.example.sudhakar.amled.api.Network.isNwConnected(this);
                if(!checknetwork)
                {
                    Log.e("1","1");
                    Toast.makeText(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this,"Please Check Your Internet",Toast.LENGTH_LONG).show();
                }
                else {
                    Log.e("2","2");
                    getWholeData();
                    if(ledpcCover1 != null)
                    {
                        PostDataTask task = new PostDataTask();
                        task.execute(formurl, username, useremailid, usercontact, useraddress, chooseled, ledpcb, config, leddriver, ledpccover,ledtype);
                        Intent intent=new Intent(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this,TotalCostActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this,"Please Select All Details",Toast.LENGTH_LONG).show();
                    }
                }


                break;

            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this, com.example.sudhakar.amled.activities.LEDDriverActivity.class);
                startActivity(intent2);
                break;


        }

    }


    //function for setting adapter
    public void setChooseLEDAdapter()
    {

        arrayList=new ArrayList<>();
        arrayList.add(new com.example.sudhakar.amled.pojo.LEDPCCover("A",100));
        arrayList.add(new com.example.sudhakar.amled.pojo.LEDPCCover("B",50));
        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);

    }


    //Adapter  function

    class ListViewAdapter extends ArrayAdapter<com.example.sudhakar.amled.pojo.LEDPCCover>
    {

        public ListViewAdapter() {
            super(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this,R.layout.recycler1chooseled,arrayList);
        }


        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View view=inflater.inflate(R.layout.recyclerviewpccover,parent,false);
            TextView textView=(TextView)view.findViewById(R.id.config);
            CheckBox checkBox=(CheckBox)view.findViewById(R.id.check);
           final com.example.sudhakar.amled.pojo.LEDPCCover ledpcCover=arrayList.get(position);
            textView.setText(ledpcCover.getGrade());

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ledpcCover1=arrayList.get(position);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("pccover",ledpcCover1.getGrade());
                    editor.commit();

                    SharedPreferences.Editor editor1=sharedPreferences1.edit();
                    editor1.putFloat("cost5",ledpcCover1.getCost());
                    editor1.commit();
                    Log.e("getCost",""+ledpcCover1.getCost());
                }
            });
            return view;
        }
    }

    //disable on back
    @Override
    public void onBackPressed() {

    }


    public void getWholeData()
    {

        //getting data from registration
        sharedPreferences=getSharedPreferences("regis",MODE_PRIVATE);
        username=sharedPreferences.getString("name","");
        Log.e("Name",""+username);
        useremailid=sharedPreferences.getString("email","");
        Log.e("Email",""+useremailid);
        usercontact=sharedPreferences.getString("contact","");
        Log.e("Contact",""+usercontact);
        useraddress=sharedPreferences.getString("address","");
        Log.e("Address",""+useraddress);

        //getting led type
        sharedPreferences=getSharedPreferences("lights",MODE_PRIVATE);
        ledtype=sharedPreferences.getString("light","");
        Log.e("LEDType",""+ledtype);


//getting data from chooseLED
        sharedPreferences=getSharedPreferences("cled1",MODE_PRIVATE);
        chooseled=sharedPreferences.getString("led1","");
        String cost1=sharedPreferences.getString("cost1","");

        Log.e("cost1wqdsdsa",""+cost1);
        Log.e("ChooseLEd",""+chooseled);


        //getting data from LED Configuration
        sharedPreferences=getSharedPreferences("cled2",MODE_PRIVATE);
        ledconfig1=sharedPreferences.getString("ledconfig1","");
        ledconfig2=sharedPreferences.getString("ledconfig2","");
        config=ledconfig1+":"+ledconfig2;
        Log.e("Config",""+config);

        //getting data from LED Driver
        sharedPreferences=getSharedPreferences("cled3",MODE_PRIVATE);
        leddriver=sharedPreferences.getString("leddriver","");
        Log.e("LEDDriver",""+leddriver);

        //getting data from LED PCB
        sharedPreferences=getSharedPreferences("cled4",MODE_PRIVATE);
        ledpcb=sharedPreferences.getString("ledpcb","");
        Log.e("LEDPcb",""+ledpcb);

        //getting data from LED PC COVER
        sharedPreferences=getSharedPreferences("cled5",MODE_PRIVATE);
        ledpccover=sharedPreferences.getString("pccover","");
        Log.e("LEDPCCover",""+ledpccover);

    }
    class PostDataTask extends AsyncTask<String,Void,Boolean>
    {
        Boolean result=false;

        @Override
        protected Boolean doInBackground(String... params) {

            result=true;
            String postBody="";
            String url="";
            url=params[0];
            String userName=params[1];
            String userEmail=params[2];
            String userContact=params[3];
            String userAddress=params[4];
            String led=params[5];
            String ledPcb=params[6];
            String ledConfig=params[7];
            String ledDriver=params[8];
            String ledPcCover=params[9];
            String userledtypes=params[10];

            try {
                postBody = usernamekey + "=" + URLEncoder.encode(userName, "UTF-8") + "&" + useremailidkey + "=" + URLEncoder.encode(userEmail, "UTF-8") + "&" + usercontactkey + "=" + URLEncoder.encode(userContact, "UTF-8")+ "&" + useraddresskey + "=" + URLEncoder.encode(userAddress, "UTF-8")+ "&" + ledkey + "=" + URLEncoder.encode(led, "UTF-8")+ "&" + ledpcbkey + "=" + URLEncoder.encode(ledPcb, "UTF-8")+ "&" + ledconfigkey + "=" + URLEncoder.encode(ledConfig, "UTF-8")+"&" + leddriverkey + "=" + URLEncoder.encode(ledDriver, "UTF-8")+"&" + ledpccoverkey + "=" + URLEncoder.encode(ledPcCover, "UTF-8")+"&" + ledtypekey + "=" + URLEncoder.encode(userledtypes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                result = false;
                e.printStackTrace();
            }

            OkHttpClient client = new OkHttpClient();
            //Create the request body with the help of Media Type
            RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
            okhttp3.Request request = new okhttp3.Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            //Send the request
            try {
                okhttp3.Response response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
                result=false;
            }

            return result;
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Toast.makeText(com.example.sudhakar.amled.activities.LEDPCCoverActivity.this,result?"Your Request has Been Submitted to Us.\n Thanking You":"No Internet. Please Connect your Device to the InterNet", Toast.LENGTH_LONG).show();

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
