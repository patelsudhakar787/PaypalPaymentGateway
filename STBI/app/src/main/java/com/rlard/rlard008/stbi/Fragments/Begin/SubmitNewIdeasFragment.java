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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitNewIdeasFragment extends Fragment {


    EditText editTextIdeaTitle, editTextTENKeyWords,editTextKeyUsers,editTextMaxKeyUsers,editTextTargetMarket,editTextDesc,editTextDate;
    Button buttonSubmit, buttonClose;

    String IdeaTitle,TenKeywords,keyUsers,maxKeyUsers,targetMarket,Desc,date;
    private static final String Submit_URL = " http://139.59.78.30:8080/BeginmyStartup/IdeaSubmit";
    String email;


    SharedPreferences sharedPreferencesemail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_submit_new_ideas,container,false);

        editTextIdeaTitle = (EditText) itemview.findViewById(R.id.etIdeasTitle);
        editTextTENKeyWords = (EditText) itemview.findViewById(R.id.etTenkeywords);
        editTextKeyUsers = (EditText) itemview.findViewById(R.id.etKeyUsers);
        editTextMaxKeyUsers = (EditText) itemview.findViewById(R.id.etMaxKeyUsers); http://139.59.78.30:8080/BeginmyStartup
        editTextTargetMarket = (EditText) itemview.findViewById(R.id.etTargetMarket);
        editTextDesc = (EditText) itemview.findViewById(R.id.etIdeasDesc);
        editTextKeyUsers = (EditText) itemview.findViewById(R.id.etKeyUsers);
        editTextDate = (EditText) itemview.findViewById(R.id.etDate);

        buttonClose = (Button) itemview.findViewById(R.id.btn_close);
        buttonSubmit = (Button) itemview.findViewById(R.id.btn_submit);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loadIdeasFragment();


            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData();

                sendSubmitRequest();

                Toast.makeText(getContext(),"Idea Submitted",Toast.LENGTH_LONG).show();

                loadIdeasFragment();
            }
        });

        return itemview;

    }

    void getData() {

        IdeaTitle = editTextIdeaTitle.getText().toString();
        TenKeywords = editTextTENKeyWords.getText().toString();
        keyUsers = editTextKeyUsers.getText().toString();
        maxKeyUsers = editTextMaxKeyUsers.getText().toString();
        targetMarket = editTextTargetMarket.getText().toString();
        Desc = editTextDesc.getText().toString();
        date = editTextDate.getText().toString();

        sharedPreferencesemail = getContext().getSharedPreferences("login_email", MODE_PRIVATE);
        email = sharedPreferencesemail.getString("email", "");
    }


    void sendSubmitRequest() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Submit_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("submit_newidea response",""+response);

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String userId = jsonObject.getString("data");

//                            SharedPreferences  sharedPreferencesuserid = getContext().getSharedPreferences("user",MODE_PRIVATE);
//                            SharedPreferences.Editor editor = sharedPreferencesuserid.edit();
//                            editor.putString("userid",userId);
//                            editor.commit();

                            Log.e("userId response",""+userId);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(LoginActivity.this,DrawerActivity.class);
//                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("submit idea error",""+error);
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();

                params.put("ideas", IdeaTitle);
                params.put("keyword", TenKeywords);
                params.put("solution", keyUsers);
                params.put("keyuser", maxKeyUsers);
                params.put("targetmarket", targetMarket);
                params.put("description", Desc);
                params.put("pic","noimage");
                params.put("today", date);
                params.put("status", "Pending");
                params.put("is_Mobile", "1");
                params.put("email", email);


                Log.e("params",""+params);


                return params;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

    }


    public void loadIdeasFragment()
    {
        IdeasFragment frg=new IdeasFragment();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,frg);
        ft.commit();
    }

}
