package com.rlard.rlard008.stbi.Fragments.JoinAsMentor;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Fragments.Begin.MyProfileFragment;
import com.rlard.rlard008.stbi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MentorProfileAddDetailsFragment extends Fragment {


    EditText editTextMobile,editTextEmail,editTextAddress;

    Button buttonSaveDetails,buttonCancelDetails;

    private static final String Update_URL = "http://10.10.0.220:8081/STBI/MentorUpdatepersonal";

    public static final String KEY_Mobile = "mobilenumber";
    public static final String KEY_Email = "email";
    public static final String KEY_UserID = "mentorId";
    public static final String KEY_Address = "address";
    public static final String KEY_is_Mobile = "is_Mobile";

    String email;
    String mobilenumber;
    String address;
    String mentorId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_mentor_profile_add_details, container, false);

        editTextAddress = (EditText) itemView.findViewById(R.id.addDetailsAddress);
        editTextEmail = (EditText) itemView.findViewById(R.id.addDetailsEmail);
        editTextMobile = (EditText) itemView.findViewById(R.id.addDetailsMob);

        buttonSaveDetails = (Button) itemView.findViewById(R.id.addDetails_btn_save);
        buttonCancelDetails = (Button) itemView.findViewById(R.id.addDetails_btn_cancel);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        mentorId = sharedPreferences.getString("mentorId","");

        Log.e("mentorId",""+mentorId);


        buttonSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mobilenumber = editTextMobile.getText().toString();
                email = editTextEmail.getText().toString();
                address = editTextAddress.getText().toString();

                sendUpdateRequest();



                Mentor_MyProfileFragment frg=new Mentor_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        buttonCancelDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_MyProfileFragment frg=new Mentor_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }


    public void sendUpdateRequest() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Update_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Update_URL",""+Update_URL);
                        Log.e("prof Add detai response","response"+response);
                        try {
                            boolean result;
                            //String userId;
                            JSONObject jsonObject = new JSONObject(response);

                            result = jsonObject.getBoolean("result");
                            Log.e("result", ""+result);
                            // if (result == true) {

//                                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();

                            //JSONObject jsonDaa = jsonObject.getJSONObject("data");
//
//                                Intent intent = new Intent(LoginActivity.this,DrawerActivity.class);
//                                startActivity(intent);userId = jsonObject.getString("data");
//
//                                SharedPreferences sharedPreferences = getSharedPreferences("login_email",MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString("email",email);
//                                editor.putString("userId",userId);
//                                editor.commit();
//
//                                redirectToNext();

                            //    } else {

                            //       Toast.makeText(getContext(),"Unable to update",Toast.LENGTH_LONG).show();
                            //    }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.e("mentor prof Add detai",""+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //params.put(KEY_USERNAME,username);
                params.put(KEY_Email, email);
                params.put(KEY_UserID, mentorId);
                params.put(KEY_Mobile, mobilenumber);
                params.put(KEY_Address, address);
                params.put(KEY_is_Mobile, "1");

                Log.e("email",""+email);
                Log.e("mobile",""+mobilenumber);
                Log.e("address",""+address);
                Log.e("KEY_is_Mobile",""+KEY_is_Mobile);

                Log.e("params",""+params);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


}
