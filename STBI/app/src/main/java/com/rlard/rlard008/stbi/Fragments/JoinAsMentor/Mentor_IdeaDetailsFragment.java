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
import com.rlard.rlard008.stbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_IdeaDetailsFragment extends Fragment {

    Button buttonNext,buttonClose;
    private SharedPreferences sharedPreferencesideamid;
    private String ideaId=null;
    private String areaOfSupport=null;
    private static String Existing_Ideas_URL;
    private TextView tvideatitle;
    private TextView tvkeyword;
    private TextView tvkeyuser;
    private TextView tvmaxnum;
    private TextView tvtargetmarket;
    private TextView tvideadescription;
    private TextView tvdate;
    private TextView tvstatus;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_mentor__idea_details, container, false);

        buttonClose=(Button)itemview.findViewById(R.id.mentor_btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.mentor_btn_next);

        tvideatitle=(TextView)itemview.findViewById(R.id.tvIdeasTitle);
        tvkeyword=(TextView)itemview.findViewById(R.id.tvTenkeywords);
        tvkeyuser=(TextView)itemview.findViewById(R.id.tvKeyUsers);
        tvmaxnum=(TextView)itemview.findViewById(R.id.tvMaxKeyUsers);
        tvtargetmarket=(TextView)itemview.findViewById(R.id.tvTargetMarket);
        tvideadescription=(TextView)itemview.findViewById(R.id.tvIdeasDesc);
        tvdate=(TextView)itemview.findViewById(R.id.tvDate);
        tvstatus=(TextView)itemview.findViewById(R.id.tvStatus);

        //getting ideaId from sharedpreferences
        sharedPreferencesideamid=getContext().getSharedPreferences("sfideaid",MODE_PRIVATE);
        ideaId=sharedPreferencesideamid.getString("mideaid","");


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        areaOfSupport = sharedPreferences.getString("areaOfSupport","");

        areaOfSupport=areaOfSupport.replace(" ","_");
        Existing_Ideas_URL = "http://10.10.0.220:8081/STBI/ListofIdeasMentorServlet?is_Mobile=1&aos="+areaOfSupport;
        getideaDetailsRequest();


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_IdeasFragment frg = new Mentor_IdeasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Mentor_ProgressRatingFragment frg = new Mentor_ProgressRatingFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();
            }
        });

        return  itemview;
    }



    public void getideaDetailsRequest()
    {
        StringRequest stringRequest=new StringRequest(Existing_Ideas_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response",""+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=null;
                    for(int i=0;i<jsonArray.length();i++)
                    {
                       jsonObject1=jsonArray.getJSONObject(i);
                        String ideaid=jsonObject1.getString("ideaid");
                        if(ideaId.equals(ideaid))
                        {
                            String ideatitle=jsonObject1.getString("titlename");
                            String keyword=jsonObject1.getString("enterkeywords");
                            String keyusers=jsonObject1.getString("keyusers");
                            String maxuser=jsonObject1.getString("maxuser");
                            String targetmarket=jsonObject1.getString("targetmarket");
                            String description=jsonObject1.getString("ideadiscription");
                            String date=jsonObject1.getString("idaeregidate");
                            String status=jsonObject1.getString("statusofidea");

                            tvideatitle.setText(""+ideatitle);
                            tvkeyword.setText(""+keyword);
                            tvkeyuser.setText(""+keyusers);
                            tvmaxnum.setText(""+maxuser);
                            tvtargetmarket.setText(""+targetmarket);
                            tvideadescription.setText(""+description);
                            tvdate.setText(""+date);
                            tvstatus.setText(""+status);
                            break;
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error",""+error);
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }





}
