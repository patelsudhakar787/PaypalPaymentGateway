package com.rlard.rlard008.stbi.Fragments.Begin;


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
public class EducationFragment extends Fragment {


    Button buttonEducationDetails;
    ListView listView;

    String Name,Degree,Field,Grade,TimeFrom,TimeTo,Desc;

    String userId;
    String Education_Details_URL;


    private ArrayList<BeginEducationDetails> arrayListEducationDetails;

    BeginEducationDetails details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_education, container, false);


//        textViewName = (TextView) itemView.findViewById(R.id.tvSchoolName);
//        textViewDegree = (TextView) itemView.findViewById(R.id.tvDegree);
//        textViewField = (TextView) itemView.findViewById(R.id.tvField);
//        textViewGrade = (TextView) itemView.findViewById(R.id.tvGrade);
//        textViewTime = (TextView) itemView.findViewById(R.id.tvTime);
//        textViewDesc = (TextView) itemView.findViewById(R.id.tvDescription);

        buttonEducationDetails = (Button) itemView.findViewById(R.id.education_AddDetails);

        listView=(ListView)itemView.findViewById(R.id.education_listView);
        arrayListEducationDetails = new ArrayList<>();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_email",MODE_PRIVATE);
        userId = sharedPreferences.getString("userId","");

        Log.e("userId",""+userId);

        Education_Details_URL = " http://139.59.78.30:8080/BeginmyStartup/BeginDashBoardServlet?is_Mobile=1&module=educationdetails&userid="+userId;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
        //GetEducationDetailsServlet?is_Mobile=1&userid=1000000000
        Log.e("Existing_Ideas_URL",""+Education_Details_URL);
        educationDetails();


        buttonEducationDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddEducationDetailsFragment frg=new AddEducationDetailsFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();

            }
        });

        return itemView;
    }


    public void educationDetails() {

        StringRequest stringRequest = new StringRequest(Education_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("edu detail response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");

                            details = null;

                            JSONObject jsonObject1=null;

                           // JSONObject jsonObject1=jsonObject.getJSONObject("data");

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);


                            // String ideaid = jsonObject1.getString("ideaid");
                                Name=jsonObject1.getString("collegename");
                                Degree=jsonObject1.getString("qualifivcation");
                                Field=jsonObject1.getString("stream");
                                Grade=jsonObject1.getString("grade");
                                TimeFrom=jsonObject1.getString("fromday");
                                TimeTo=jsonObject1.getString("today");
                                Desc=jsonObject1.getString("description");


                                details = new BeginEducationDetails(Name,Degree,Field,Grade,TimeFrom,TimeTo,Desc);
                                arrayListEducationDetails.add(details);
                            }

                            ListViewAdapter adapter=new ListViewAdapter();
                            listView.setAdapter(adapter);

//                            textViewName.setText(Name);
//                            textViewEmail.setText(Email);
//                            textViewMobile.setText(Mobile);
//                            textViewDOB.setText(DOB);
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

    //class
    class ListViewAdapter extends ArrayAdapter<BeginEducationDetails>
    {

        public ListViewAdapter() {
            super(getActivity(),R.layout.ideas_layout_listview,arrayListEducationDetails);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.education_layout_listview,parent,false);

            TextView textViewName = (TextView) convertView.findViewById(R.id.tvSchoolName);
            TextView textViewDegree = (TextView) convertView.findViewById(R.id.tvDegree);
            TextView textViewField = (TextView) convertView.findViewById(R.id.tvField);
            TextView textViewGrade = (TextView) convertView.findViewById(R.id.tvGrade);
            TextView textViewTimeFrom = (TextView) convertView.findViewById(R.id.tvTimeFrom);
            TextView textViewTimeTo = (TextView) convertView.findViewById(R.id.tvTimeTo);
            TextView textViewDesc = (TextView) convertView.findViewById(R.id.tvDescription);

//            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaId2);
//            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofidea2);
//            TextView tvdate=(TextView)convertView.findViewById(R.id.date2);
//            TextView tvstatus=(TextView)convertView.findViewById(R.id.status2);
//            TextView tvmyservices=(TextView)convertView.findViewById(R.id.myservices2);


            BeginEducationDetails pojo=arrayListEducationDetails.get(position);
            textViewName.setText(pojo.getName());
            textViewDegree.setText(pojo.getDegree());
            textViewField.setText(pojo.getField());
            textViewGrade.setText(pojo.getGrade());
            textViewTimeFrom.setText(pojo.getTimeFrom());
            textViewTimeTo.setText(pojo.getTimeTo());
            textViewDesc.setText(pojo.getDescription());


//            tvtitleofidea.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Toast.makeText(getContext(),"Title Clicked",Toast.LENGTH_LONG).show();
//                }
//            });



            return convertView;
        }
    }
}
