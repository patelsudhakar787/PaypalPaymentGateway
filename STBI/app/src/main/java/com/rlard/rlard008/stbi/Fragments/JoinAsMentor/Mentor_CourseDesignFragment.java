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
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Pojo.BeginEducationDetails;
import com.rlard.rlard008.stbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_CourseDesignFragment extends Fragment {

    Button buttonAddDetails;
    TextView textViewName,textViewDesc,textViewPrerequisite,textViewDuration,textViewCredit,textViewObjective, textViewOutcome;
    TextView textViewModules,textViewTools,textViewReference,textViewLevel;//, textViewPin;


    String Name,Description,Prerequisite,Duration,Credit,Objective,Outcome,Modules,Tools,Reference,Level,Days,Months;

    String mentorId;
    String Course_Details_URL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_mentor__course_design, container, false);


        buttonAddDetails = (Button) itemView.findViewById(R.id.mentor_course_AddDetails);

        textViewName = (TextView) itemView.findViewById(R.id.tvName);
        textViewDesc = (TextView) itemView.findViewById(R.id.tvDescription);
        textViewLevel = (TextView) itemView.findViewById(R.id.tvLevel);
        textViewPrerequisite = (TextView) itemView.findViewById(R.id.tvPrerequisite);

        textViewDuration = (TextView) itemView.findViewById(R.id.tvDuration);
        textViewCredit = (TextView) itemView.findViewById(R.id.tvCredit);
        textViewObjective = (TextView) itemView.findViewById(R.id.tvObjectives);

        textViewOutcome = (TextView) itemView.findViewById(R.id.tvOutcome);

        textViewModules = (TextView) itemView.findViewById(R.id.tvModules);
        textViewTools = (TextView) itemView.findViewById(R.id.tvTools);
        textViewReference = (TextView) itemView.findViewById(R.id.tvRefrence);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        mentorId = sharedPreferences.getString("mentorId","");

        Log.e("mentorId",""+mentorId);

        Course_Details_URL = "http://10.10.0.220:8081/STBI/MentorDashBoardServlet?is_Mobile=1&module=coursedesign&mid="+mentorId;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
//STBI/MentorCourseDesignServlet?is_Mobile=1&mid=100
        Log.e("Existing_Ideas_URL",""+Course_Details_URL);

        CourseDetails();



        buttonAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                ProfileAddDetailsFragment frg=new ProfileAddDetailsFragment();
//                FragmentManager fm=getFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();

            }
        });


        return itemView;
    }

    public void CourseDetails() {

        StringRequest stringRequest = new StringRequest(Course_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Course detail response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");

                           // details = null;

                            JSONObject jsonObject1=null;

                            // JSONObject jsonObject1=jsonObject.getJSONObject("data");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);


                                // String ideaid = jsonObject1.getString("ideaid");
                                //String ,,,,,,,,,

                                Name=jsonObject1.getString("coursename");
                                Description=jsonObject1.getString("description");
                                Prerequisite=jsonObject1.getString("prerequisite");
                                //Duration=jsonObject1.getString("duration");
                                Credit=jsonObject1.getString("coursecredit");
                                Objective=jsonObject1.getString("courseobjective");
                                Outcome=jsonObject1.getString("courseoutcomes");
                                Level = jsonObject1.getString("couserlevel");

                                Days = jsonObject1.getString("duration");
                                Months = jsonObject1.getString("weekmonth");

                                Modules=jsonObject1.getString("coursemodule");
                                Tools=jsonObject1.getString("coursetool");
                                Reference=jsonObject1.getString("referencebook");

                                Duration = Days+" "+Months;

                            }

//                            textViewName.setText(Name);
                            //String ,,,,,,,,,,,Days,Months;

                            textViewName.setText(Name);
                            textViewDesc.setText(Description);
                            textViewLevel.setText(Level);
                            textViewPrerequisite.setText(Prerequisite);

                            textViewDuration.setText(Duration);
                            textViewCredit.setText(Credit);
                            textViewObjective.setText(Objective);

                            textViewOutcome.setText(Outcome);

                            textViewModules.setText(Modules);
                            textViewTools.setText(Tools);
                            textViewReference.setText(Reference);

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
