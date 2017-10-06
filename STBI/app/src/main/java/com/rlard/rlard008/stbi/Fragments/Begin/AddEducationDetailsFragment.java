package com.rlard.rlard008.stbi.Fragments.Begin;


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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.R;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEducationDetailsFragment extends Fragment {

    EditText editTextName,editTextDegree,editTextField,editTextGrade,editTextFromDate,editTextToDate,editTextDesc;

    Button buttonSaveDetails,buttonCancelDetails;


    private static final String Update_URL = "http://139.59.78.30:8080/BeginmyStartup/InsertUserEducation";

    public static final String KEY_Name = "name";
    public static final String KEY_Degree = "degree";
    public static final String KEY_UserID = "userid";
    public static final String KEY_Field = "field";
    public static final String KEY_Grade = "grade";
    public static final String KEY_FromDate = "fromdate";
    public static final String KEY_ToDate = "todate";
    public static final String KEY_Desc = "description";
    public static final String KEY_is_Mobile = "is_Mobile";

    String Name;
    String Degree;
    String Field;
    String Grade;

    String FromDate;
    String ToDate;
    String Desc;

    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_add_education_details, container, false);

        editTextName = (EditText) itemView.findViewById(R.id.addDetailsSchool);
        editTextDegree = (EditText) itemView.findViewById(R.id.addDetailsDegree);
        editTextField = (EditText) itemView.findViewById(R.id.addDetailsField);
        editTextGrade = (EditText) itemView.findViewById(R.id.addDetailsGrade);

        editTextFromDate = (EditText) itemView.findViewById(R.id.addDetailsEduFrom);
        editTextToDate = (EditText) itemView.findViewById(R.id.addDetailsEduTo);
        editTextDesc = (EditText) itemView.findViewById(R.id.addDetailsDesc);

        buttonSaveDetails = (Button) itemView.findViewById(R.id.addDetailsEdu_btn_save);
        buttonCancelDetails = (Button) itemView.findViewById(R.id.addDetailsEdu_btn_cancel);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_email",MODE_PRIVATE);
        userId = sharedPreferences.getString("userId","");

        Log.e("userId",""+userId);

        buttonSaveDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Name = editTextName.getText().toString();
                Degree = editTextDegree.getText().toString();
                Field = editTextField.getText().toString();
                Grade = editTextGrade.getText().toString();

                FromDate = editTextFromDate.getText().toString();
                ToDate = editTextToDate.getText().toString();
                Desc = editTextDesc.getText().toString();

                sendUpdateRequest();

                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();

                EducationFragment frg=new EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });

        buttonCancelDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EducationFragment frg=new EducationFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
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
                        Log.e("Edu Update_URL","update"+Update_URL);
                        Log.e("Edu Add detai response","regrg"+response);
                      //  try {
                    //        boolean result=false;
                            //String userId;
                           // JSONObject jsonObject = new JSONObject(response);

//                            result = jsonObject.getBoolean("result");
//                            Log.e("result", ""+result);
                           //  if (result == true)
                          //   {

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

                          //      } else {
//
//                                   Toast.makeText(getContext(),"Unable to update",Toast.LENGTH_LONG).show();
                          //   }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Toast.makeText(LoginActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                        Log.e("login error",""+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();

                params.put(KEY_Name, Name);
                params.put(KEY_UserID, userId);
                params.put(KEY_Degree, Degree);
                params.put(KEY_Field, Field);

                params.put(KEY_Grade, Grade);
                params.put(KEY_FromDate, FromDate);
                params.put(KEY_ToDate, ToDate);
                params.put(KEY_Desc, Desc);
                params.put(KEY_is_Mobile, "1");

//                Log.e("email",""+email);
//                Log.e("mobile",""+mobilenumber);
//                Log.e("address",""+address);
//                Log.e("KEY_is_Mobile",""+KEY_is_Mobile);

                Log.e("params",""+params);


                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}
