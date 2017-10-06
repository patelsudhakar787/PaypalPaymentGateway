package com.example.sudhakar.amled.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sudhakar.amled.R;

import java.util.ArrayList;

import static com.example.sudhakar.amled.R.id.address;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{


    private Button btn_next;
    private Button btn_previous;
    private EditText editTextfname;
    private EditText editTextlname;
    private EditText editTextemail;
    private EditText editTextcontact;
    private EditText editTextaddress;
    private EditText editTextcity;
    private Spinner spinnerstates;
    private SharedPreferences sharedPreferences;
    private ActionBar actionBar=null;
    private ArrayList<String>indianstates;
    private ArrayAdapter<String>adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn_next=(Button)findViewById(R.id.btn_next);
        btn_previous=(Button)findViewById(R.id.btn_previous);
        editTextfname=(EditText)findViewById(R.id.fname);
        editTextlname=(EditText)findViewById(R.id.lname);
        editTextemail=(EditText)findViewById(R.id.email);
        editTextcontact=(EditText)findViewById(R.id.contact);
        editTextaddress=(EditText)findViewById(address);
        editTextcity=(EditText)findViewById(R.id.city);
        spinnerstates=(Spinner)findViewById(R.id.spinner);

        indianstates=new ArrayList<>();
        //db=new DataBaseHelper(this);


        sharedPreferences=getSharedPreferences("regis",MODE_PRIVATE);
        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));

actionBarTitleGravity();

   //calling spinner function
        setSpinner();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_next:
                String fname=editTextfname.getText().toString();
                String lname=editTextlname.getText().toString();
                String name=fname+" "+lname;
                String email=editTextemail.getText().toString();
                String contact=editTextcontact.getText().toString();
                String landmark=editTextaddress.getText().toString();
                String city=editTextcity.getText().toString();
                String state=spinnerstates.getSelectedItem().toString();
                String address=landmark+","+city+","+state;
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name);
                editor.putString("email",email);
                editor.putString("contact",contact);
                editor.putString("address",address);
                editor.commit();

                Intent intent1=new Intent(com.example.sudhakar.amled.activities.RegistrationActivity.this,SelectLightActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_previous:
                Intent intent2=new Intent(com.example.sudhakar.amled.activities.RegistrationActivity.this, com.example.sudhakar.amled.activities.WelComePageActivity.class);
                startActivity(intent2);
                break;

        }
    }
    //disable on back
    @Override
    public void onBackPressed() {

    }

    //setting spinner
    public void setSpinner()
    {
        //adding states to the arraylist
        indianstates.add("Andhra Pradesh");           //1
        indianstates.add("Arunachal Pradesh");            //2
        indianstates.add("Assam");         //3
        indianstates.add("Bihar");                  //4
        indianstates.add("Chhattisgarh");              //5
        indianstates.add("Chandigarh");                 //6
        indianstates.add("Dadra and Nagar Haveli");            //7
        indianstates.add("Daman and Diu");           //8
        indianstates.add("Delhi");            //9
        indianstates.add("Goa");           //10
        indianstates.add("Gujarat");                 //11
        indianstates.add("Haryana");            //12
        indianstates.add("Himachal Pradesh");            //13
        indianstates.add("Jammu and Kashmir");            //14
        indianstates.add("Jharkhand");            //15
        indianstates.add("Karnataka");             //16
        indianstates.add("Kerala");                 //17
        indianstates.add("Madhya Pradesh");             //18
        indianstates.add("Maharashtra");              //19
        indianstates.add("Manipur");              //20
        indianstates.add("Meghalaya");              //21
        indianstates.add("Mizoram");              //22
        indianstates.add("Nagaland");              //23
        indianstates.add("Orissa");             //24
        indianstates.add("Punjab");               //25
        indianstates.add("Pondicherry");             //26
        indianstates.add("Rajasthan");              //27
        indianstates.add("Sikkim");            //28
        indianstates.add("Tamil Nadu");            //29
        indianstates.add("Tripura");            //30
        indianstates.add("Uttar Pradesh");             //31
        indianstates.add("Uttarakhand");              //32
        indianstates.add("West Bengal");              //33
                      //34
        adapter=new ArrayAdapter<String>(com.example.sudhakar.amled.activities.RegistrationActivity.this,android.R.layout.simple_list_item_1,indianstates);
        spinnerstates.setAdapter(adapter);

    }


    private void actionBarTitleGravity() {
        // TODO Auto-generated method stub

        TextView textview = new TextView(getApplicationContext());

        ViewGroup.LayoutParams layoutparams = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

        textview.setLayoutParams(layoutparams);

        textview.setText("Enter Your Persional Details");

        textview.setTextColor(Color.BLACK);

        textview.setGravity(Gravity.CENTER);

        textview.setTextSize(20);

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(textview);

    }

}
