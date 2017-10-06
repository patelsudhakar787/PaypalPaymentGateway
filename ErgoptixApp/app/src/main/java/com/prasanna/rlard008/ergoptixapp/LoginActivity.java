package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;


    SignInButton signInButtonGoogle;
    GoogleApiClient googleApiClient;
    private static final int RC_SIGN_IN = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        setContentView(R.layout.activity_login);


        loginButton = (LoginButton) findViewById(R.id.facebook_sign_in_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                handleSignInResult();
            }

            @Override
            public void onCancel() {

                Toast.makeText(LoginActivity.this, "onCancel", Toast.LENGTH_LONG);
            }

            @Override
            public void onError(FacebookException error) {

                Log.d(MainActivity.class.getCanonicalName(), error.getMessage());
                Toast.makeText(LoginActivity.this, "onError", Toast.LENGTH_LONG);
            }


        });

        //end of FaceBook Login

        //////////////////////////////////////////////

        //Login using Google


        signInButtonGoogle = (SignInButton) findViewById(R.id.google_sign_in_button);

        signInButtonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signInWithGoogle();
            }
        });

    } ////eof oncreate



    void signInWithGoogle() {

        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();


        Intent googleSignInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(googleSignInIntent,RC_SIGN_IN);

    }

    public void handleSignInResult() {

       // LoginManager.getInstance().logOut();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess()) {

                SharedPreferences sharedPreferences = getSharedPreferences("isLog", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("islog", "yes");

                editor.commit();

                final  GoogleApiClient client = googleApiClient;
                handleSignInResult();

            } else {
                Toast.makeText(LoginActivity.this,"Unable To Login. Pls try again",Toast.LENGTH_LONG);
            }
        }

        else {

            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }
}
