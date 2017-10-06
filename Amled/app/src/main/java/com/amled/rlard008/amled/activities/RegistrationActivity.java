package com.amled.rlard008.amled.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.api.Network;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_submit;
    private EditText editTextfname;
    private EditText editTextlname;
    private EditText editTextemail;
    private EditText editTextcontact;
    private EditText editTextaddress;
    private EditText editTextcity;
    private Spinner spinnerstates;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private ActionBar actionBar = null;
    private ArrayList<String> indianstates;
    private ArrayAdapter<String> adapter;
    private OkHttpClient mClient = new OkHttpClient();

    static HashMap<String, String> postDataParams = new HashMap();
    private static final MediaType FORM_DATA_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    private static final String formurl = "https://docs.google.com/a/rlard.com/forms/d/e/1FAIpQLScj0acY5RNo3qCsy1W4S7X8m1kIaSY-8LhUZ3dxKE5HnjpFCw/formResponse";
    private static final String usernamekey = "entry.773328289";
    private static final String genderkey = "entry.1072973855";
    private static final String useremailidkey = "entry.1996923482";
    private static final String usercontactkey = "entry.166429336";
    private static final String useraddresskey = "entry.1046569414";
    private static final String ledkey = "entry.1068219086";
    private static final String ledpcbkey = "entry.659910295";
    private static final String ledconfigkey = "entry.1951311065";
    private static final String leddriverkey = "entry.335290622";
    private static final String ledpccoverkey = "entry.1863649757";
    private static final String ledtypekey = "entry.395671749";
    private SharedPreferences sharedPreferences;
    private String chooseled = "";
    private String ledconfig1 = "";
    private String ledconfig2 = "";
    private String leddriver = "";
    private String ledpcb = "";
    private String ledpccover = "";
    private String username = null;
    private String useremailid = null;
    private String usercontact = null;
    private String useraddress = null;
    private String config = "";
    private String ledtype = "";
    private String fname = null;
    private String lname = null;
    private String landmark = null;
    private String city = null;
    private String state = null;
    private String gender = "";
    private String totalcost = "";
    private String emailurl="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn_submit = (Button) findViewById(R.id.btn_next);

        editTextfname = (EditText) findViewById(R.id.fname);
        editTextlname = (EditText) findViewById(R.id.lname);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextcontact = (EditText) findViewById(R.id.contact);
        editTextaddress = (EditText) findViewById(R.id.address);
        editTextcity = (EditText) findViewById(R.id.city);
        spinnerstates = (Spinner) findViewById(R.id.spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        radioButton1 = (RadioButton) findViewById(R.id.male);
        radioButton2 = (RadioButton) findViewById(R.id.female);

        editTextfname.setInputType(InputType.TYPE_CLASS_TEXT);
        editTextlname.setInputType(InputType.TYPE_CLASS_TEXT);
        editTextemail.setInputType(InputType.TYPE_CLASS_TEXT);
        editTextcontact.setInputType(InputType.TYPE_CLASS_TEXT);
        editTextcity.setInputType(InputType.TYPE_CLASS_TEXT);
        editTextaddress.setInputType(InputType.TYPE_CLASS_TEXT);


        sharedPreferences = getSharedPreferences("cled5", MODE_PRIVATE);
        indianstates = new ArrayList<>();
        //db=new DataBaseHelper(this);


        sharedPreferences = getSharedPreferences("regis", MODE_PRIVATE);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f1aa05")));


//        Intent intent=getIntent();
//        totalcost=intent.getStringExtra("cost");

        actionBarTitleGravity();

        //calling spinner function
        setSpinner();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:


                //check network connectivity
                boolean checknetwork = Network.isNwConnected(this);
                if (!checknetwork) {
                    Toast.makeText(RegistrationActivity.this, "Please Check Your Internet", Toast.LENGTH_LONG).show();
                } else {
                    getWholeData();
                    if (username != null && useremailid != null && usercontact != null && useraddress != null) {

                        if (!fname.matches("^[a-zA-Z]{3,20}$")) {
                            editTextfname.setError("Invalid FirstName");

                        } else if (!lname.matches("^[a-zA-Z]{3,20}$")) {
                            editTextlname.setError("Invalid LastName");

                        } else if (!useremailid.matches("^\\w{1,50}\\.\\w{1,50}@\\w{1,50}\\.\\w{2,3}$")) {
                            editTextemail.setError("Invalid EmailID");
                        } else if (!usercontact.matches("^[0-9]{10}$")) {
                            editTextcontact.setError("Invalid Contact");

                        } else if (TextUtils.isEmpty(landmark)) {
                            editTextaddress.setError(getString(R.string.error_field_required));

                        } else if (TextUtils.isEmpty(city)) {
                            editTextcity.setError(getString(R.string.error_field_required));

                        } else {
                            PostDataTask task = new PostDataTask();
                            task.execute(formurl, username, gender, useremailid, usercontact, useraddress, chooseled, ledpcb, config, leddriver, ledpccover, ledtype);




                            Intent intent = new Intent(RegistrationActivity.this, WelComePageActivity.class);
                            startActivity(intent);





                            //sending mail
                            //spilliting email

                                emailurl = "http://10.10.0.219:8881/AmledBackend/EmailServlet?to="+useremailid+"&name="+fname;
                                Log.e("url", "" + emailurl);
                                sentMailRequest();

                            //sending sms
                           String url="http://219.91.251.69:4567/sms";
                            try {
                                post(url, new Callback() {
                                    @Override
                                    public void onFailure(Call call, IOException e) {
                                    e.printStackTrace();
                                        Log.e("Error","error");
                                    }

                                    @Override
                                    public void onResponse(Call call, Response response) throws IOException {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(RegistrationActivity.this,"SMS Sent!",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                    }
                                });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }

                }


        }
    }
    //disable on back

    //setting spinner
    public void setSpinner() {
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
        adapter = new ArrayAdapter<String>(RegistrationActivity.this, android.R.layout.simple_list_item_1, indianstates);
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


    class PostDataTask extends AsyncTask<String, Void, Boolean> {
        Boolean result = false;

        @Override
        protected Boolean doInBackground(String... params) {

            result = true;
            String postBody = "";
            String url = "";
            url = params[0];
            String userName = params[1];
            String gendEr = params[2];
            String userEmail = params[3];
            String userContact = params[4];
            String userAddress = params[5];
            String led = params[6];
            String ledPcb = params[7];
            String ledConfig = params[8];
            String ledDriver = params[9];
            String ledPcCover = params[10];
            String userledtypes = params[11];

            try {
                postBody = usernamekey + "=" + URLEncoder.encode(userName, "UTF-8") + "&" + genderkey + "=" + URLEncoder.encode(gendEr, "UTF-8") + "&" + useremailidkey + "=" + URLEncoder.encode(userEmail, "UTF-8") + "&" + usercontactkey + "=" + URLEncoder.encode(userContact, "UTF-8") + "&" + useraddresskey + "=" + URLEncoder.encode(userAddress, "UTF-8") + "&" + ledkey + "=" + URLEncoder.encode(led, "UTF-8") + "&" + ledpcbkey + "=" + URLEncoder.encode(ledPcb, "UTF-8") + "&" + ledconfigkey + "=" + URLEncoder.encode(ledConfig, "UTF-8") + "&" + leddriverkey + "=" + URLEncoder.encode(ledDriver, "UTF-8") + "&" + ledpccoverkey + "=" + URLEncoder.encode(ledPcCover, "UTF-8") + "&" + ledtypekey + "=" + URLEncoder.encode(userledtypes, "UTF-8");
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
                result = false;
            }

            return result;
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            Toast.makeText(RegistrationActivity.this, result ? "Your Request has Been Submitted to Us.\n Thanking You" : "No Internet. Please Connect your Device to the InterNet", Toast.LENGTH_LONG).show();

        }
    }


    public void getWholeData() {

//        //getting data from registration
        fname = editTextfname.getText().toString();
        lname = editTextlname.getText().toString();
        username = fname + " " + lname;
        useremailid = editTextemail.getText().toString();
        usercontact = editTextcontact.getText().toString();
        landmark = editTextaddress.getText().toString();
        city = editTextcity.getText().toString();
        state = spinnerstates.getSelectedItem().toString();
        useraddress = landmark + "," + city + "," + state;


        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == R.id.male) {
            gender = "Male";
        }
        if (selectedId == R.id.female) {
            gender = "Female";
        }

        //getting led type
        sharedPreferences = getSharedPreferences("lights", MODE_PRIVATE);
        ledtype = sharedPreferences.getString("light", "");
        Log.e("LEDType", "" + ledtype);


//getting data from chooseLED
        sharedPreferences = getSharedPreferences("chooseledobj", MODE_PRIVATE);
        chooseled = sharedPreferences.getString("chooseled", "");


        //getting data from LED Configuration
        sharedPreferences = getSharedPreferences("mhousingobj", MODE_PRIVATE);
        ledconfig1 = sharedPreferences.getString("mhousing1", "");
        ledconfig2 = sharedPreferences.getString("mhousing2", "");
        config = ledconfig1 + ":" + ledconfig2;
        Log.e("Config", "" + config);
        //getting data from LED DriverLog.e("ChooseLEd",""+j);j

        sharedPreferences = getSharedPreferences("leddriverobj", MODE_PRIVATE);
        leddriver = sharedPreferences.getString("leddriver", "");
        Log.e("LEDDriver", "" + leddriver);

        //getting data from LED PCB
        sharedPreferences = getSharedPreferences("ledpcbobj", MODE_PRIVATE);
        ledpcb = sharedPreferences.getString("ledpcb", "");
        Log.e("LEDPcb", "" + ledpcb);

        //getting data from LED PC COVER
        sharedPreferences = getSharedPreferences("ledpccoverobj", MODE_PRIVATE);
        ledpccover = sharedPreferences.getString("ledpccover", "");
        Log.e("LEDPCCover", "" + ledpccover);

    }


    @Override
    public void onBackPressed() {
        alertDialog();
    }

    public void alertDialog() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Amled");
        builder.setMessage("Are You Sure You don't want to Submit your OEM Request.");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                Intent intent = new Intent(RegistrationActivity.this, WelComePageActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        }).setIcon(R.drawable.app).show();


    }





    //whatsapp

    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

    public void sendSms(String contactnumber, String message) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + contactnumber));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }


    //sms service
    Call post(String url,Callback callback) throws IOException
        {
            RequestBody formBody = new FormBody.Builder()
                    .add("To","+91"+usercontact )
                    .add("Body","SuccessfullyRegistered")
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            Call response = mClient.newCall(request);
            response.enqueue(callback);
            return response;

        }






        public void sentMailRequest()
        {
            StringRequest stringRequest=new StringRequest(emailurl, new com.android.volley.Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                Toast.makeText(RegistrationActivity.this,"Mail Sent",Toast.LENGTH_LONG).show();
                }
            }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Log.e("Error",""+error);
                    }
            });
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }


}
