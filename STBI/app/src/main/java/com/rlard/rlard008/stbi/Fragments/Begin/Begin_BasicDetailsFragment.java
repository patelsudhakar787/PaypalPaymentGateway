package com.rlard.rlard008.stbi.Fragments.Begin;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.R;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Begin_BasicDetailsFragment extends Fragment {


    TextView textViewName,textViewMiddleName,textViewLastName,textViewDOB,textViewMobile,textViewEmail, textViewGender;
    TextView textViewAadhar,textViewTempAddress,textViewPerAddress,textViewCity, textViewPin;

    String Name,MiddleName,LastName,Email,Mobile,DOB,Aadhar,Gender,tempAddresss,perAddress,City,Pincode;

    String userId;
    String Personal_Details_URL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_begin__basic_details, container, false);


        textViewName = (TextView) itemView.findViewById(R.id.tvName);
        textViewMiddleName = (TextView) itemView.findViewById(R.id.tvMiddleName);
        textViewLastName = (TextView) itemView.findViewById(R.id.tvLastName);

        textViewEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        textViewMobile = (TextView) itemView.findViewById(R.id.tvMobile);
        textViewDOB = (TextView) itemView.findViewById(R.id.tvDOB);

        textViewGender = (TextView) itemView.findViewById(R.id.tvGender);

        textViewAadhar = (TextView) itemView.findViewById(R.id.tvAdhar);
        textViewTempAddress = (TextView) itemView.findViewById(R.id.tvTempAdd);
        textViewPerAddress = (TextView) itemView.findViewById(R.id.tvPerAdd);

        textViewCity = (TextView) itemView.findViewById(R.id.tvCity);
        textViewPin = (TextView) itemView.findViewById(R.id.tvPincode);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_email",MODE_PRIVATE);
        userId = sharedPreferences.getString("userId","");

        Log.e("userId",""+userId);

        Personal_Details_URL = " http://139.59.78.30:8080/BeginmyStartup/BeginDashBoardServlet?&module=basicdetails&is_Mobile=1&userid="+userId;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
//STBI/STBI/BeginDashBoardServlet?userid=1000000000&module=basicdetails&is_Mobile=1
        Log.e("Existing_Ideas_URL",""+Personal_Details_URL);
        BasicDetails();

        return itemView;
    }


    public void BasicDetails() {

        StringRequest stringRequest = new StringRequest(Personal_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("basicdetail response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            //JSONArray jsonArray=jsonObject.getJSONArray("data");

                            //  JSONObject jsonObject1=null;

                            JSONObject jsonObject1=jsonObject.getJSONObject("data");

//                            for(int i=0;i<jsonArray.length();i++)
//                            {
//                                jsonObject1=jsonArray.getJSONObject(i);

                            //String ,,,,,,,;

                            // String ideaid = jsonObject1.getString("ideaid");
                            Name=jsonObject1.getString("firstname");
                            MiddleName=jsonObject1.getString("middlename");
                            LastName=jsonObject1.getString("lastname");

                            Email=jsonObject1.getString("emailid");
                            Mobile=jsonObject1.getString("contact");

                            DOB=jsonObject1.getString("dob");
                            Aadhar=jsonObject1.getString("adharuino");
                            Gender=jsonObject1.getString("gender");

                            tempAddresss=jsonObject1.getString("temperaryaddress");
                            perAddress=jsonObject1.getString("permanentaddress");
                            City=jsonObject1.getString("city");

                            Pincode=jsonObject1.getString("pincode");

//                            Log.e("basicdetail Name",""+Name);
//                            Log.e("basicdetail MiddleName",""+MiddleName);
//                            Log.e("basicdetail LastName",""+LastName);
//                            Log.e("basicdetail Email",""+Email);
//                            Log.e("basicdetail Mobile",""+Mobile);
//                            Log.e("basicdetail DOB",""+DOB);
//                            Log.e("basicdetail Aadhar",""+Aadhar);
//                            Log.e("basicdetail Gender",""+Gender);
//                            Log.e("basic tempAddresss",""+tempAddresss);
//                            Log.e("basic perAddress",""+perAddress);
//                            Log.e("basic  City",""+ City);
//                            Log.e("basic  Pincode",""+Pincode);

                            // }

                            //textViewName.setText(Name);
                            textViewName.setText(Name);
                            textViewMiddleName.setText(MiddleName);
                            textViewLastName.setText(LastName);

                            textViewEmail.setText(Email);
                            textViewMobile.setText(Mobile);
                            textViewDOB.setText(DOB);

                            textViewGender.setText(Gender);

                            textViewAadhar.setText(Aadhar);
                            textViewTempAddress.setText(tempAddresss);
                            textViewPerAddress.setText(perAddress);

                            textViewCity.setText(City);
                            textViewPin.setText(Pincode);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("existing idea error",""+error);
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }


}
