package rlard.hr.rlard008.hr_app.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import rlard.hr.rlard008.hr_app.R;

public class LoginActivity extends AppCompatActivity {


    SignInButton googleSignButton;
    GoogleApiClient googleApiClient;
    public static final int RC_SIGN = 9001;
    private String picInfo=null;
    private static String personName="";

    String url;
    private static int login=0;
    private ArrayList<String>almepnames=null;

    SharedPreferences sharedPreferences=null;
   // private static int checkempname=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        almepnames=new ArrayList<>();
        /////////////////Google Login

        sharedPreferences = getSharedPreferences("isLog", MODE_PRIVATE);


        googleSignButton = (SignInButton) findViewById(R.id.google_sign_in_button);

        googleSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    signInWithGoogle();

                            }
        });
    } // eof oncreate


    /////////////////Google Login

    void signInWithGoogle() {

        if (googleApiClient != null) {

            googleApiClient.disconnect();
        }

        defaultSignin();


    }
    public void defaultSignin() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();


        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build();

        Log.e("above", "intent");


            Intent googleSignInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
            startActivityForResult(googleSignInIntent, RC_SIGN);
            Log.e("below", "intent");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()) {

               // final  GoogleApiClient client = googleApiClient;

                GoogleSignInAccount googleSignInAccount = result.getSignInAccount();
                 personName = googleSignInAccount.getDisplayName();
                String personEmail = googleSignInAccount.getEmail();
                if(googleSignInAccount.getPhotoUrl() !=null) {
                    picInfo = googleSignInAccount.getPhotoUrl().toString();
                }
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("personName",personName);
                editor.putString("personEmail",personEmail);
                editor.putString("url",picInfo);

                editor.commit();

                personName = personName.replace(" ", "");

                url = "http://139.59.78.52:8080/HR_Application/CreateEmployeeTables?name="+personName;

                Log.e("Login_url", ""+url);

//                checkduplacate(personName);
//
//                if(checkempname == 2)
//                {
//                    setAlertDialogBox();
//
//
//                }
//                else {
                sendLoginRequest();

                 //   handleSignInResult();
                //}
            }

        }
        else {

            Toast.makeText(LoginActivity.this,"Unable To Login. Pls try again",Toast.LENGTH_LONG);
        }
    }

    void handleSignInResult() {

        if(login == 0) {


            createTableRequest();
            Intent intent = new Intent(LoginActivity.this,SettingActivity.class);
            startActivity(intent);

        }


        if(login == 1)
        {
            Intent splash = new Intent(LoginActivity.this, DrawerActivity.class);
            startActivity(splash);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("islog", "yes");
        editor.commit();

    }

    void createTableRequest() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(SettingActivity.this,"Inserted",Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this,"Please Check Your Connection",Toast.LENGTH_LONG).show();
                Log.e("LoginError", ""+error);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);

    }




//    public void checkduplacate(String name)
//    {
//        for(String pname:almepnames)
//        {
//            if(pname.equals(name))
//            {
//                checkempname=2;
//                break;
//            }
//            else
//            {
//                checkempname=1;
//            }
//        }
//    }
    
    public void sendLoginRequest()
    {
        String url="http://139.59.78.52:8080/HR_Application/GetLogin?name="+personName;
        StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("resposne",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);

                    JSONObject jsonObject1=jsonObject.getJSONObject("data");

                    login=Integer.parseInt(jsonObject1.getString("flag"));
                   String empId=jsonObject1.getString("empid");
                    SharedPreferences sharedPreferences1 = getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences1.edit();

                    editor.putString("empId", empId);
                    editor.commit();
                Log.e("login flag",""+login);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                finally {
                    handleSignInResult();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }



}
