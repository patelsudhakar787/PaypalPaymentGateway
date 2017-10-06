package com.rlard.rlard008.stbi.Fragments.JoinAsMentor;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Fragments.Begin.AddSkillsFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.SkillsFragment;
import com.rlard.rlard008.stbi.Pojo.BeginEducationDetails;
import com.rlard.rlard008.stbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_SkillsFragment extends Fragment {

    Button buttonAddDetails;

    ListView listView;

    String Skills_Details_URL;
    private ArrayList<BeginEducationDetails> arrayListSkills;
    String mentorId;
    String skill_Name;

    BeginEducationDetails details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_mentor__skills, container, false);

        buttonAddDetails = (Button) itemView.findViewById(R.id.mentor_skill_AddDetails);
        listView=(ListView)itemView.findViewById(R.id.Skills_listView);

        arrayListSkills = new ArrayList<>();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        mentorId = sharedPreferences.getString("mentorId","");

        Log.e("mentorId",""+mentorId);

        Skills_Details_URL = "http://10.10.0.220:8081/STBI/MentorDashBoardServlet?is_Mobile=1&module=aoe&mid="+mentorId;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
        //STBI/MyAreaofIforIServlet?is_Mobile=1&mid=100
        Log.e("Skills_Details_URL",""+Skills_Details_URL);
        skillsDetails();


        buttonAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_AddSkillsFragment frg=new Mentor_AddSkillsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();

            }
        });

        return itemView;
    }

    public void skillsDetails() {

        StringRequest stringRequest = new StringRequest(Skills_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Skill detail response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");

                            details = null;

                            JSONObject jsonObject1=null;

                            // JSONObject jsonObject1=jsonObject.getJSONObject("data");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);


                                skill_Name=jsonObject1.getString("skill");

                                details = new BeginEducationDetails(skill_Name);
                                arrayListSkills.add(details);
                            }

                            ListViewAdapter adapter=new ListViewAdapter();
                            listView.setAdapter(adapter);


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

    //class
    class ListViewAdapter extends ArrayAdapter<BeginEducationDetails>
    {

        public ListViewAdapter() {
            super(getActivity(),R.layout.skill_layout_listview,arrayListSkills);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.skill_layout_listview,parent,false);

            TextView textViewName = (TextView) convertView.findViewById(R.id.tvSkills);


            BeginEducationDetails pojo=arrayListSkills.get(position);
            textViewName.setText(pojo.getName());


            return convertView;
        }
    }

}
