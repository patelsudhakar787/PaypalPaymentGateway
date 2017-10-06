package com.example.sudhakar.rfdms_app.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhakar.rfdms_app.R;
import com.example.sudhakar.rfdms_app.pojo.LoginDetails;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private ImageView imageView;
    private AutoCompleteTextView email;
    private AutoCompleteTextView password;
    private TextView textViewtext;
    private String emaildata=null;
    private String passworddata=null;
    String clientId=null;
    String token=null;
    private SharedPreferences sharedPreferences;
    private ArrayList<LoginDetails>arrayListlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=(Button)findViewById(R.id.email_sign_in_button);
        imageView=(ImageView)findViewById(R.id.image);
        textViewtext=(TextView)findViewById(R.id.text);
        email=(AutoCompleteTextView)findViewById(R.id.email);
        password=(AutoCompleteTextView)findViewById(R.id.password);
        arrayListlogin=new ArrayList<>();

        //calling animation function
        scaleView(imageView,0f,1f);

        textViewtext.setText("Remote Data Feeder \nMonitoring System");
        getLoginDetails();
        sharedPreferences=this.getSharedPreferences("data",MODE_PRIVATE);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 emaildata=email.getText().toString();
                passworddata=password.getText().toString();
//                loginurl="http://10.10.0.220:8080/RFDMS/LoginServlet?email="+emaildata+"&password="+passworddata;
                if(emaildata !=null && passworddata !=null) {

                   for(LoginDetails loginDetails:arrayListlogin)
                   {

                       if(loginDetails.getLoginid().equals(emaildata) && loginDetails.getPassword().equals(passworddata))
                       {
                       clientId=loginDetails.getClientid();
                           Intent intent = new Intent(LoginActivity.this, MapsActivity.class);
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

                token=FirebaseInstanceId.getInstance().getToken();
                if(clientId !=null && token !=null) {

                }
            }
        });
    }

//    public void getLoginRequest()
//    {
//        StringRequest stringRequest=new StringRequest(loginurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                if(!response.isEmpty()) {
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
//                        String email = jsonObject1.getString("email");
//                        clientId = jsonObject1.getString("clientId");
//                        if (email.equals(emaildata)) {
//                            Intent intent = new Intent(LoginActivity.this, GridViewActivity.class);
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Invalid Login/Password", Toast.LENGTH_LONG).show();
//                        }
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    @Override
    public void onBackPressed() {

    }


//    public void refreshToken()
//    {
//        refreshtokenurl="http://10.10.0.220/RFDMS/TokenServlet?client_id="+clientId+"&token_id="+token;
//        Log.e("RefreshUrl",""+refreshtokenurl);
//
//        StringRequest stringRequest=new StringRequest(refreshtokenurl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                Log.e("response",""+response);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("error",""+error);
//            }
//        });
//        RequestQueue requestQueue=Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }
//

    public void getLoginDetails()
    {
        LoginDetails loginDetails1=new LoginDetails("sen1","sen1","client1");
        LoginDetails loginDetails2=new LoginDetails("sen2","sen2","client2");
        LoginDetails loginDetails3=new LoginDetails("sen3","sen3","client3");
        LoginDetails loginDetails4=new LoginDetails("sen4","sen4","client4");
        arrayListlogin.add(loginDetails1);
        arrayListlogin.add(loginDetails2);
        arrayListlogin.add(loginDetails3);
        arrayListlogin.add(loginDetails4);
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
