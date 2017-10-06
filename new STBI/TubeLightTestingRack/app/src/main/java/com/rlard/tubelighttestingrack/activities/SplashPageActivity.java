package com.rlard.tubelighttestingrack.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;
import com.rlard.tubelighttestingrack.R;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashPageActivity extends AppCompatActivity {
    private ImageView imagesplash;
    private TextView tvsplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        imagesplash = (ImageView) findViewById(R.id.image);
        tvsplash = (TextView) findViewById(R.id.text);

        imagesplash.setImageResource(R.drawable.dp);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent energymeterintent = new Intent(SplashPageActivity.this, LoginActivity.class);
                startActivity(energymeterintent);
            }
        }, 3000);

        updatetoken();
    }

    public void updatetoken()
    {
        String token= FirebaseInstanceId.getInstance().getToken();
        String tokenurl="http://139.59.78.30:8080/TestingRack/TokenServlet?id=test1&token="+token;
        StringRequest stringRequest1=new StringRequest(tokenurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String data=jsonObject.getString("data");
                    Toast.makeText(SplashPageActivity.this,""+data,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Log.e("ResponseToken",""+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SplashPageActivity.this,"Unable to connect to Server. pls try again",Toast.LENGTH_LONG).show();

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest1);

    }

}
