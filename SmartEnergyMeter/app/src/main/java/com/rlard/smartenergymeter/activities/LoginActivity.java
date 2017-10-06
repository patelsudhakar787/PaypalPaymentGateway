package com.rlard.smartenergymeter.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.rlard.smartenergymeter.R;
import com.rlard.smartenergymeter.pojo.LoginDetails;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private AutoCompleteTextView email;
    private AutoCompleteTextView password;
    private String emaildata=null;
    private String passworddata=null;
    String clientId=null;
    private SharedPreferences sharedPreferences;
    private ArrayList<LoginDetails> arrayListlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn_login=(Button)findViewById(R.id.email_sign_in_button);
        email=(AutoCompleteTextView)findViewById(R.id.email);
        password=(AutoCompleteTextView)findViewById(R.id.password);
        arrayListlogin=new ArrayList<>();

        getLoginDetails();
        sharedPreferences=this.getSharedPreferences("data",MODE_PRIVATE);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emaildata=email.getText().toString();
                passworddata=password.getText().toString();
                if(emaildata !=null && passworddata !=null) {

                    for(LoginDetails loginDetails:arrayListlogin)
                    {

                        if(loginDetails.getLoginid().equals(emaildata) && loginDetails.getPassword().equals(passworddata))
                        {
                            clientId=loginDetails.getClientid();
                            Intent intent = new Intent(LoginActivity.this, DrawerActivity.class);
                            startActivity(intent);
                            break;
                        }
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this,"Please Enter Login Details",Toast.LENGTH_LONG).show();
                }
                Log.e("clientId",""+clientId);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("clientId",clientId);
                editor.commit();


            }
        });
    }


    public void getLoginDetails()
    {
        LoginDetails loginDetails1=new LoginDetails("sentinal1","sentinal1","client1");
        LoginDetails loginDetails2=new LoginDetails("sentinal2","sentinal2","client2");
        LoginDetails loginDetails3=new LoginDetails("sentinal3","sentinal3","client3");
        LoginDetails loginDetails4=new LoginDetails("sentinal4","sentinal4","client4");
        arrayListlogin.add(loginDetails1);
        arrayListlogin.add(loginDetails2);
        arrayListlogin.add(loginDetails3);
        arrayListlogin.add(loginDetails4);
    }
}
