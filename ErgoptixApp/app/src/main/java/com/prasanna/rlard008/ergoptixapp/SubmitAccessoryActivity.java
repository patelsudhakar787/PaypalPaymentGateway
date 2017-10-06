package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class SubmitAccessoryActivity extends AppCompatActivity {

    EditText editTextName,editTextEmail,editTextPhone,editTextAddress,editTextCity,editTextState;

    Button buttonSubmit;

    RadioGroup radioGroup;
    RadioButton radioButtonMale,radioButtonFemale;
    String radioData;

    String name;
    String email;
    String phone;
    String address,city,state;
    String model;

    String accessories;

    // for uploading to google sheet

    private static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    String url = "https://docs.google.com/a/rlard.com/forms/d/e/1FAIpQLSfJveE6q4QuXCTIp4m9I1pOXu504bewspUrjuUAutArzdR1NQ/formResponse";

    String sheetName = "entry.770718543";
    String sheetEmail = "entry.972433426";
    String sheetPhone = "entry.1915027258";
    String sheetGender = "entry.894385239";
    String sheetAddress = "entry.195280333";
    String sheetModel = "entry.88713364";
    String sheetAccessories = "entry.1738861035";
    String sheetCity = "entry.1243038032";
    String sheetState = "entry.784228264";


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_accessory);

        editTextAddress = (EditText) findViewById(R.id.editTextaddressAccessory);
        editTextCity = (EditText) findViewById(R.id.editTextCityAccessory);
        editTextEmail = (EditText) findViewById(R.id.editTextEmailAccessory);
        editTextName = (EditText) findViewById(R.id.editTextNameAccessory);
        editTextPhone = (EditText) findViewById(R.id.editTextPhoneAccessory);
        editTextState = (EditText) findViewById(R.id.editTextStateAccessory);

        buttonSubmit = (Button) findViewById(R.id.submitAccessory);

        radioGroup =(RadioGroup) findViewById(R.id.radiogroupAccessory);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioFemaleAccessory);
        radioButtonMale = (RadioButton) findViewById(R.id.radioMale);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();

                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError(getString(R.string.error_field_required));

                }

                else if (!isEmailValid(email)) {

                    editTextEmail.setError("Invalid Email!! Email must contain '@'");
                }

                else if (TextUtils.isEmpty(phone)) {
                    editTextPhone.setError(getString(R.string.error_field_required));

                }

                else if (!isPhoneValid(phone)) {

                    editTextPhone.setError("Phone no must be 10 digit");
                }


                else {

                    sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);

                    model = sharedPreferences.getString("model","");
                    accessories = sharedPreferences.getString("accessories","");

                    //sending excel sheet request
                    PostAccessory  postAccessory = new PostAccessory();

                    //execute asynctask
                    postAccessory.execute(url,name,email,phone,model,accessories,radioData,address,city,state);


                }
                }



//                sharedPreferences = getSharedPreferences("Accessory",MODE_PRIVATE);
//                acc1 = sharedPreferences.getString("acc1","NA");
//                acc2 = sharedPreferences.getString("acc2","NA");
//                acc3 = sharedPreferences.getString("acc3","NA");
//                acc4 = sharedPreferences.getString("acc4","NA");
//
//                Log.e("buttonSubmit acc1", "" + acc1);
//                Log.e("buttonSubmit acc2", "" + acc2);
//                Log.e("buttonSubmit acc3", "" + acc3);
//                Log.e("buttonSubmit acc4", "" + acc4);
//
//
//
//
//                float total = sharedPreferences.getFloat("total",0.0f);
//
//                float priceAcc1 = sharedPreferences.getFloat("priceAcc1",0.0f);
//                float priceAcc2 = sharedPreferences.getFloat("priceAcc2",0.0f);
//                float priceAcc3 = sharedPreferences.getFloat("priceAcc3",0.0f);
//                float priceAcc4 = sharedPreferences.getFloat("priceAcc4",0.0f);
//
//
////                if (!acc1.equals("null") && !acc2.equals("null") && !acc3.equals("null") && !acc1.isEmpty() && !acc2.isEmpty() && !acc3.isEmpty()) {// && acc4.equals("null")) {
////
//                   access3 = acc3+": Price: "+priceAcc3;
////                    msg = "Your Details:\n"+access1+"\n"+access2+"\n"+access3+"\nTotal Price"+total;
////
////                }
////
////                if (!acc1.equals("null") && !acc2.equals("null") && !acc1.isEmpty() && !acc2.isEmpty()) { // && acc3.equals("null") && acc4.equals("null")) {
////
//                    access2 = acc2+": Price: "+priceAcc2;
////                    msg = "Your Details:\n"+access1+"\n"+access2+"\nTotal Price"+total;
////
////                    Log.e("acc1,2", "" + msg);
////
////                }
////
////                if (!acc1.equals("null") && !acc1.isEmpty()){//&& acc2.equals("null") && acc3.equals("null") && acc4.equals("null")) {
////
////
//                    access1 = acc1+": Price: "+priceAcc1;
////                    msg = "Your Details:\n"+access1+"\nTotal Price: "+total;
////
////                    Log.e("if_acc1", "" + msg);
////                }
//
////
//
////                else
//
////
////                if (!acc1.equals("null") && !acc2.equals("null") && !acc3.equals("null") && !acc4.equals("null")) {
////
//                    access4 = acc4+": Price: "+priceAcc4;
//
//                Log.e("buttonSubmit access1", "" + access1);
//                Log.e("buttonSubmit access2", "" + access2);
//                Log.e("buttonSubmit access3", "" + access3);
//                Log.e("buttonSubmit access4", "" + access4);
//
//                    msg = "Your Details:\n"+(!acc1.equals("NA")? access1:"")
//                            +"\n"+(!acc2.equals("NA")? access2:"")
//                            +"\n"+(!acc3.equals("NA")? access3:"")
//                            +"\n"+(!acc4.equals("NA")? access4:"")
//                            +"\nTotal Price:" +total;
////                }
//
//                Log.e("b4 alert", "" + msg);
//
//                AlertDialog alertDialog = new AlertDialog.Builder(SubmitAccessoryActivity.this)
//                    .setTitle("Confirmation")
//                    //.setMessage("Your Details:'\n"+access1+"'\n"+access2+"'\n"+access3+"'\n"+access4+"'\n Total Price"+total)
//                    .setMessage(""+msg)
//                    .setPositiveButton("OK",new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog,int id) {
//
//                            getData();
//
//                            //sending excel sheet request
////                            PostAccessoryData  postAccessoryData = new PostAccessoryData();
////
////                            //execute asynctask
////                            postAccessoryData.execute(url,name,email,phone,model,accessories,gender,address,sheetCity1,sheetState1);
//
//
//                        }
//                    })
//                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Intent intent = new Intent(SubmitAccessoryActivity.this,MainActivity.class);
//                            startActivity(intent);
//                        }
//                    })
//                    .create();
//
//            //alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//            alertDialog.show();
//

        });


    }// eof onCreate


    public void getData() {

        name = editTextName.getText().toString();
        email = editTextEmail.getText().toString();
        phone = editTextPhone.getText().toString();
        address = editTextAddress.getText().toString();
        city = editTextCity.getText().toString();
        state = editTextState.getText().toString();

        getRadioButtonData();

        Log.e("name", "" + name);
        Log.e("email", "" + email);
        Log.e("phone", "" + phone);
        Log.e("gender", "" + radioData);
        Log.e("address", "" + address);

        Log.e("city", "" + city);
        Log.e("state", "" + state);

    }

    void getRadioButtonData() {

        int selectedId=radioGroup.getCheckedRadioButtonId();
        if(selectedId==R.id.radioMaleAccessory)
        {
            radioData="Male";
        }
        if(selectedId==R.id.radioFemaleAccessory)
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

    class PostAccessory extends AsyncTask<String,Void,Boolean>
    {

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
                postBody = sheetName+"="+ URLEncoder.encode(s1, "UTF-8")
                        +"&"+sheetEmail+"="+URLEncoder.encode(s2, "UTF-8")
                        +"&"+sheetPhone+"="+URLEncoder.encode(s3, "UTF-8")
                        +"&"+sheetModel+"="+URLEncoder.encode(s4, "UTF-8")
                        +"&"+sheetAccessories+"="+URLEncoder.encode(s5, "UTF-8")
                        +"&"+sheetGender+"="+URLEncoder.encode(s6, "UTF-8")
                        +"&"+sheetAddress+"="+URLEncoder.encode(s7, "UTF-8")
                        +"&"+sheetCity+"="+URLEncoder.encode(s8, "UTF-8")
                        +"&"+sheetState+"="+URLEncoder.encode(s9, "UTF-8");

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

            Toast.makeText(SubmitAccessoryActivity.this,aBoolean?"Request successfully submitted!":"There was some error while submitting your request. Please try again after some time.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SubmitAccessoryActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }

}
