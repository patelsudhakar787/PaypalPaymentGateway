package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SubmitTTLRequestActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButtonMale,radioButtonFemale;
    String radioData="";

    ActionBar actionBar=null;

    Button buttonNext;
    EditText editTextName,editTextEmail,editTextPhone,editTextAddress;


    private static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    String url = "https://docs.google.com/a/rlard.com/forms/d/e/1FAIpQLSd3mOsUMksDbYTLTYuFKOfMpXG9oog6nt11EGnqLI0lwu8VFw/formResponse";

    String name = "entry.2125919453";
    String email = "entry.1119680154";
    String phone = "entry.1538701496";
    String gender = "entry.1870888056";
    String address = "entry.81383690";
    String leftDistance = "entry.664491386";
    String rightDistance = "entry.1554598054";
    String height = "entry.1813867633";
    String workingDistance = "entry.821942134";

    String name1;
    String email1;
    String phone1;
    String address1;
    String leftPupil1;
    String rightPupil1;
    String height1;
    String workingDistance1;
    String gender1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_ttlrequest);

        buttonNext = (Button) findViewById(R.id.next);
        editTextAddress = (EditText) findViewById(R.id.editTextaddress);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);

        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioButtonMale=(RadioButton)findViewById(R.id.radioMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioFemale);



        actionBar=getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name1 = editTextName.getText().toString();
                 email1 = editTextEmail.getText().toString();
                 phone1 = editTextPhone.getText().toString();
                 address1 = editTextAddress.getText().toString();

                getRadioButtonData();


                if (TextUtils.isEmpty(name1)) {
                    editTextName.setError(getString(R.string.error_field_required));



                }
                else if (!isEmailValid(email1)) {

                    editTextEmail.setError("Invalid Email!! Email must contain '@'");
                }

                else if (TextUtils.isEmpty(email1)) {
                    editTextEmail.setError(getString(R.string.error_field_required));



                }

                else if (!isPhoneValid(phone1)) {

                    editTextPhone.setError("Phone no must be 10 digit");
                }

                else if (TextUtils.isEmpty(phone1)) {
                    editTextPhone.setError(getString(R.string.error_field_required));

                }

                else if (TextUtils.isEmpty(address1)) {
                    editTextAddress.setError(getString(R.string.error_field_required));

                }

                else {

                    SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);

                    leftPupil1 = sharedPreferences.getString("leftPupil","");
                    rightPupil1 = sharedPreferences.getString("rightPupil","");
                    height1 = sharedPreferences.getString("height","");
                    workingDistance1 = sharedPreferences.getString("workingDistance","");
                    gender1 = radioData;


                    //sending excel sheet request
                    PostData postData = new PostData();

                    //execute asynctask
                    postData.execute(url, name1, email1, phone1, address1, leftPupil1, rightPupil1, height1, workingDistance1, gender1);
                }
            }
        });
    }

    public void getRadioButtonData()
    {
        int selectedId=radioGroup.getCheckedRadioButtonId();
        if(selectedId==R.id.radioMale)
        {
            radioData="Male";
        }
        if(selectedId==R.id.radioFemale)
        {
            radioData="Female";
        }

    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPhoneValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() == 10;
    }

    class PostData extends AsyncTask<String,Void,Boolean> {

        String postBody;


        @Override
        protected Boolean doInBackground(String... strings) {

            Boolean result = true;

            String url1 = strings[0];
            String s1 = strings[1];
            String s2 = strings[2];
            String s3= strings[3];
            String s4=strings[4];
            String s5=strings[5];
            String s6=strings[6];
            String s7=strings[7];
            String s8=strings[8];
            String s9=strings[9];


            try {
                postBody = name+"="+ URLEncoder.encode(s1, "UTF-8")+"&"+email+"="+URLEncoder.encode(s2, "UTF-8")
                        +"&"+phone+"="+URLEncoder.encode(s3, "UTF-8")+"&"+gender+"="+URLEncoder.encode(s9, "UTF-8")
                        +"&"+address+"="+URLEncoder.encode(s4, "UTF-8")
                        +"&"+leftDistance+"="+URLEncoder.encode(s5, "UTF-8")+"&"+rightDistance+"="+URLEncoder.encode(s6, "UTF-8")
                        +"&"+height+"="+URLEncoder.encode(s7, "UTF-8")+"&"+workingDistance+"="+URLEncoder.encode(s8, "UTF-8");
                Log.e("postBody",""+postBody);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                result = false;
            }

            //Create OkHttpClient for sending request
            OkHttpClient client = new OkHttpClient();
            //Create the request body with the help of Media Type
            RequestBody body = RequestBody.create(FORM_DATA_TYPE, postBody);
            Request request = new Request.Builder()
                    .url(url1)
                    .post(body)
                    .build();
            //Send the request
            try {
                Response response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
                result = false;
            }

            return result;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {

            Toast.makeText(SubmitTTLRequestActivity.this,aBoolean?"Request successfully submitted!":"There was some error while submitting your request. Please try again after some time.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SubmitTTLRequestActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

}
