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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Fragments.Begin.SkillsFragment;
import com.rlard.rlard008.stbi.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_AddSkillsFragment extends Fragment {


    EditText editTextSkill;
    Button buttonSave,buttonCancel;

    String email;
    String Skill;

    private static final String Update_URL = "http://10.10.0.220:8081/STBI/MentorAddSkill";

    public static final String KEY_Name = "myskills";
    public static final String KEY_Email = "email";

    public static final String KEY_is_Mobile = "is_Mobile";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_mentor__add_skills, container, false);

        editTextSkill = (EditText) itemView.findViewById(R.id.addNewSkill);

        buttonSave = (Button) itemView.findViewById(R.id.addSkill_btn_save);
        buttonCancel = (Button) itemView.findViewById(R.id.addSkill_btn_cancel);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        email = sharedPreferences.getString("email","");

        Log.e("mentor email",""+email);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Skill = editTextSkill.getText().toString();


                sendUpdateRequest();

                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();

                Mentor_SkillsFragment frg=new Mentor_SkillsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_SkillsFragment frg=new Mentor_SkillsFragment();
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
                        Log.e("Skill Update_URL",""+Update_URL);
                        Log.e("Skill Add response",""+response);
                        try {
                            boolean result;
                            //String userId;
                            JSONObject jsonObject = new JSONObject(response);

                            result = jsonObject.getBoolean("result");
                            Log.e("result", ""+result);
                            if (result == true) {

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

                            } else {

                                Toast.makeText(getContext(),"Unable to update",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

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

                params.put(KEY_Name, Skill);
                params.put(KEY_Email, email);

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
