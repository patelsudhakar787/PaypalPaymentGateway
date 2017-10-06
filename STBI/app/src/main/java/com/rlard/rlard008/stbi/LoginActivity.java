package com.rlard.rlard008.stbi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.LoaderManager.LoaderCallbacks;
import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Fragments.Begin.ResetPassword;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private LinearLayout linearLayout;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private CheckBox checkBox;
   // private TextView textViewReg;

    ProgressDialog dialog;

    String clickedButton;

    private String LOGIN_URL;// = "http://10.10.0.219:8881/STBI/LoginServlet";


    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_is_Mobile = "is_Mobile";



    String email;
    String password;
    private ProgressBar progressBar;

    SharedPreferences sharedPreferences;

    String Pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        linearLayout=(LinearLayout)findViewById(R.id.email_login_form);
        progressBar=(ProgressBar)findViewById(R.id.login_progress);
        populateAutoComplete();


        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        sharedPreferences = getSharedPreferences("ActivityName",MODE_PRIVATE);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkBox.isChecked())
                {
                    linearLayout.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    email=mEmailView.getText().toString();
             //       send_reset_password_request();
                    loadresetFragment();
                    Toast.makeText(LoginActivity.this,"Checked",Toast.LENGTH_LONG).show();
                }
                else {


                    attemptLogin();
                }



//                clickedButton = sharedPreferences.getString("clickedButton","");
//
//                if (clickedButton.equals("Begin")) {
//
//                    Intent intent = new Intent(LoginActivity.this, BeginActivity.class);
//                    startActivity(intent);
//                }
//
////                if (clickedButton.equals("ManageSIG")) {
////
////                    Intent intent = new Intent(LoginActivity.this, ManageSigActivity.class);
////                    startActivity(intent);
////                }
//
//                if (clickedButton.equals("FindOpportinuty")) {
//
//                    Intent intent = new Intent(LoginActivity.this, FindOpportinutyActivity.class);
//                    startActivity(intent);
//                }
//
//                if (clickedButton.equals("JoinMentor")) {
//
//                    Intent intent = new Intent(LoginActivity.this, JoinMentorActivity.class);
//                    startActivity(intent);
//                }
//
//                if (clickedButton.equals("JoinInvestor")) {
//
//                    Intent intent = new Intent(LoginActivity.this, JoinInvesterActivity.class);
//                    startActivity(intent);
//                }
//
//                if (clickedButton.equals("UpgradeSkill")) {
//
//                    Intent intent = new Intent(LoginActivity.this, UpradeSkillActivity.class);
//                    startActivity(intent);
//                }
//
//                if (clickedButton.equals("UpgradeBusiness")) {
//
//                    Intent intent = new Intent(LoginActivity.this, UpgradeBusinessActivity.class);
//                    startActivity(intent);
//                }
//
//                else {
//
//                    Toast.makeText(LoginActivity.this,"Invalid",Toast.LENGTH_LONG);
//                }
            }
        });


        dialog=new ProgressDialog(this);

//        textViewReg.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.setMessage("Sorry Registration is allowed only on our Web Portal");
//                dialog.setIcon(R.drawable.stop_icon1);
//               // dialog.setProgress(ProgressDialog.STYLE_SPINNER);
//                dialog.show();
//            }
//        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        getLoaderManager().initLoader(0, null, this);
    }

    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (shouldShowRequestPermissionRationale(READ_CONTACTS)) {
            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok, new View.OnClickListener() {
                        @Override
                        @TargetApi(Build.VERSION_CODES.M)
                        public void onClick(View v) {
                            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
                        }
                    });
        } else {
            requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                populateAutoComplete();
            }
        }
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        email = mEmailView.getText().toString();
        password = mPasswordView.getText().toString();
       // String Pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



        clickedButton = sharedPreferences.getString("clickedButton","");

        if (clickedButton.equals("Begin")) {
            if (email.matches(Pattern) && email.length() > 0)
            {
                LOGIN_URL = "http://139.59.78.30:8080/BeginmyStartup/LoginController";
                sendLoginRequest_Begin();

                Log.e("clicked","clicked");

            }
            else {
                mEmailView.setError("Invalid Email id");
            }

        }

        if (clickedButton.equals("JoinMentor")) {

            if (email.matches(Pattern) && email.length() > 0)
            {
                LOGIN_URL = "http://10.10.0.220:8081/STBI/MentorLogin";
                sendLoginRequest_Mentor();

            }
            else {
                mEmailView.setError("Invalid Email id");
            }

        }


    }

    void sendLoginRequest_Begin() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Begin login response",""+response);
                        try {
                            boolean result;
                            String userId;
                            JSONObject jsonObject = new JSONObject(response);

                            result = jsonObject.getBoolean("result");
                            Log.e("result", ""+result);
                            if (result == true) {

                                JSONObject jsonData = jsonObject.getJSONObject("data");
                                userId = jsonData.getString("userid");

                                SharedPreferences sharedPreferences = getSharedPreferences("login_email",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("email",email);
                                editor.putString("userId",userId);
                                editor.commit();

                                Log.e("login response userId",""+userId);

//                                redirectToNext();
////                                Intent intent = new Intent(LoginActivity.this,DrawerActivity.class);
////                                startActivity(intent);

                                Intent intent = new Intent(LoginActivity.this, BeginActivity.class);
                                startActivity(intent);

                            } else {

                                Toast.makeText(LoginActivity.this,"Wrong Username/Password Or Your Registration is in Approved Stage...." +
                                        "",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.e("login error",""+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //params.put(KEY_USERNAME,username);
                params.put(KEY_EMAIL, email);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_is_Mobile, "1");

                Log.e("email",""+email);
                Log.e("password",""+password);
                Log.e("KEY_is_Mobile",""+KEY_is_Mobile);

                Log.e("params",""+params);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

//    public void send_reset_password_request()
//    {
//        String Reset_Url="http://10.10.0.220:8881/STBI/UserForgotpass";
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, Reset_Url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//            Log.e("Reponse","res"+response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Error","err"+error);
//            }
//        })
//        {
//            @Override
//            protected Map<String,String> getParams(){
//                Map<String,String> params = new HashMap<String, String>();
//                //params.put(KEY_USERNAME,username);
//                params.put(KEY_EMAIL, email);
//                params.put(KEY_is_Mobile, "1");
//
//                Log.e("params",""+params);
//
//
//                return params;
//            }
//
//        };
//        RequestQueue requestQueue=Volley.newRequestQueue(this);
//        requestQueue.add(stringRequest);
//    }

    void sendLoginRequest_Mentor() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Mentor login response",""+response);
                        try {
                            boolean result;
                            String mentorId;
                            String areaOfSupport;

                            JSONObject jsonObject = new JSONObject(response);

                            result = jsonObject.getBoolean("result");
                            Log.e("result", ""+result);
                            if (result == true) {

                                JSONObject jsonObject1 = jsonObject.getJSONObject("data");

                                mentorId = jsonObject1.getString("mid");
                                areaOfSupport = jsonObject1.getString("aos");


                                SharedPreferences sharedPreferences = getSharedPreferences("login_mentor",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("areaOfSupport",areaOfSupport);
                                editor.putString("mentorId",mentorId);
                                editor.putString("email",email);
                                editor.commit();

                                Log.e("Mentorlog resp mentorId",""+mentorId);
                                Log.e("Mentorlog resp area sup",""+areaOfSupport);



                                Intent intent = new Intent(LoginActivity.this, JoinMentorActivity.class);
                                startActivity(intent);

                            } else {

                                Toast.makeText(LoginActivity.this,"Wrong Username/Password Or Your Registration is in Approved Stage...." +
                                        "",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.e("login error",""+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //params.put(KEY_USERNAME,username);
                params.put(KEY_EMAIL, email);
                params.put(KEY_PASSWORD, password);
                params.put(KEY_is_Mobile, "1");

                Log.e("email",""+email);
                Log.e("password",""+password);
                Log.e("KEY_is_Mobile",""+KEY_is_Mobile);

                Log.e("params",""+params);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    void redirectToNext() {

//        clickedButton = sharedPreferences.getString("clickedButton","");

//        if (clickedButton.equals("Begin")) {
//
//            Intent intent = new Intent(LoginActivity.this, BeginActivity.class);
//            startActivity(intent);
//        }

//                if (clickedButton.equals("ManageSIG")) {
//
//                    Intent intent = new Intent(LoginActivity.this, ManageSigActivity.class);
//                    startActivity(intent);
//                }

        if (clickedButton.equals("FindOpportinuty")) {

            Intent intent = new Intent(LoginActivity.this, FindOpportinutyActivity.class);
            startActivity(intent);
        }

//        if (clickedButton.equals("JoinMentor")) {
//
//            Intent intent = new Intent(LoginActivity.this, JoinMentorActivity.class);
//            startActivity(intent);
//        }

        if (clickedButton.equals("JoinInvestor")) {

            Intent intent = new Intent(LoginActivity.this, JoinInvesterActivity.class);
            startActivity(intent);
        }

        if (clickedButton.equals("UpgradeSkill")) {

            Intent intent = new Intent(LoginActivity.this, UpradeSkillActivity.class);
            startActivity(intent);
        }

        if (clickedButton.equals("UpgradeBusiness")) {

            Intent intent = new Intent(LoginActivity.this, UpgradeBusinessActivity.class);
            startActivity(intent);
        }

        else {

            Toast.makeText(LoginActivity.this,"Invalid",Toast.LENGTH_LONG);
        }

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }


    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */


    @Override
    protected void onStop() {
        super.onStop();

        // clear shared preference
        SharedPreferences sp = getSharedPreferences("ActivityName", MODE_PRIVATE);
        sp.edit().remove("clickedButton").commit();
    }


    public void loadresetFragment()
    {
        ResetPassword resetPasswordfrg=new ResetPassword();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,resetPasswordfrg);
        ft.commit();
    }





        }