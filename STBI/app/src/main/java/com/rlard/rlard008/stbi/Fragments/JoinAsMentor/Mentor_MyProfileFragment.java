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
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Fragments.Begin.EducationFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.MyProfileFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.ProfileAddDetailsFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.SkillsFragment;
import com.rlard.rlard008.stbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_MyProfileFragment extends Fragment {

    TextView textViewName,textViewEmail,textViewMobile,textViewAddress,textViewAge, textViewGender;

    Button buttonAddDetails;

    String Name,Email,Mobile,DOB,Age,Gender;

    String mentorId;
    String Personal_Details_URL;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_mentor__my_profile, container, false);

      //  textViewName = (TextView) itemView.findViewById(R.id.tvMentorName);
        textViewEmail = (TextView) itemView.findViewById(R.id.tvMentorEmail);
        textViewMobile = (TextView) itemView.findViewById(R.id.tvMentorMobile);
        textViewAddress = (TextView) itemView.findViewById(R.id.tvMentorDOB);
//        textViewAge = (TextView) itemView.findViewById(R.id.tvMentorAge);
//        textViewGender = (TextView) itemView.findViewById(R.id.tvMentorGender);


        buttonAddDetails = (Button) itemView.findViewById(R.id.mentor_profile_AddDetails);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        mentorId = sharedPreferences.getString("mentorId","");

        Log.e("mentorId",""+mentorId);

        Personal_Details_URL = "http://10.10.0.220:8081/STBI/MentorDashBoardServlet?is_Mobile=1&module=personaldetails&mid="+mentorId;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
//STBI/MentorPersonalDetailsServlet?is_Mobile=1&mid=100
        Log.e("Existing_Ideas_URL",""+Personal_Details_URL);
        personalDetails();


        buttonAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MentorProfileAddDetailsFragment frg=new MentorProfileAddDetailsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }


    public void personalDetails() {

        StringRequest stringRequest = new StringRequest(Personal_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("personaldetail response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");

                             JSONObject jsonObject1=null;

                            //JSONObject jsonObject1=jsonObject.getJSONObject("data");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);


                            // String ideaid = jsonObject1.getString("ideaid");
                           // Name=jsonObject1.getString("fullname");
                            Email=jsonObject1.getString("emailid");
                            Mobile=jsonObject1.getString("contact");

                            DOB=jsonObject1.getString("address");
//                            Age=jsonObject1.getString("age");
//                            Gender=jsonObject1.getString("gender");

                            }

                            //textViewName.setText(Name);
                            textViewEmail.setText(Email);
                            textViewMobile.setText(Mobile);
                            textViewAddress.setText(DOB);
//                            textViewAge.setText(Age);
//                            textViewGender.setText(Gender);


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
