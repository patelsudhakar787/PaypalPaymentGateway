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
public class IdeaDetails_BeginFragment extends Fragment {


    Button buttonNext,buttonClose;
    private SharedPreferences sfgetideaid;
    TextView textViewideaTitle,textViewTenKeyword,textViewKeyUser,textViewMaxKeyUser,textViewTargetMarket, textViewDesc,textViewDate;
    TextView textViewStatus;

    private static String Idea_Details_URL;
    String userId = null;

    String ideaTitle,TenKeyword,KeyUser,MaxKeyUser,TargetMarket,Desc,ideaDate,Status;

    private String ideaid="";
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_idea_details__begin,container,false);

        textViewideaTitle = (TextView) itemview.findViewById(R.id.tvIdeasTitle);
        textViewTenKeyword = (TextView) itemview.findViewById(R.id.tvTenkeywords);
        textViewKeyUser = (TextView) itemview.findViewById(R.id.tvKeyUsers);
        textViewMaxKeyUser = (TextView) itemview.findViewById(R.id.tvMaxKeyUsers);
        textViewTargetMarket = (TextView) itemview.findViewById(R.id.tvTargetMarket);
        textViewDesc = (TextView) itemview.findViewById(R.id.tvIdeasDesc);
        textViewDate = (TextView) itemview.findViewById(R.id.tvDate);
        textViewStatus = (TextView) itemview.findViewById(R.id.tvStatus);


        sfgetideaid=getContext().getSharedPreferences("sfideaid",MODE_PRIVATE);

        ideaid=sfgetideaid.getString("ideaid","");
        Log.e("IdeaId","id"+ideaid);
        buttonClose=(Button)itemview.findViewById(R.id.btn_close);
        buttonNext=(Button)itemview.findViewById(R.id.btn_next);


        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_email",MODE_PRIVATE);
        userId = sharedPreferences.getString("userId","");

        Log.e("userId",""+userId);

        Idea_Details_URL = " http://139.59.78.30:8080/BeginmyStartup/GetExistingIdeaServlet?userid="+userId+"&is_Mobile=1";//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";

        Log.e("Existing_Ideas_URL",""+Idea_Details_URL);
        ideaDetails();

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IdeasFragment frg = new IdeasFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressRatingFragment frg = new ProgressRatingFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();
            }
        });

        return  itemview;
    }


    public void ideaDetails() {

        StringRequest stringRequest = new StringRequest(Idea_Details_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("existing idea response",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");

                            JSONObject jsonObject1=null;

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);


                                String iid = jsonObject1.getString("ideaid");
                                if(iid.equals(ideaid)) {
                                    ideaTitle = jsonObject1.getString("titlename");
                                    ideaDate = jsonObject1.getString("idaeregidate");
                                    Status = jsonObject1.getString("statusofidea");

                                    TenKeyword = jsonObject1.getString("enterkeywords");
                                    KeyUser = jsonObject1.getString("keyusers");
                                    MaxKeyUser = jsonObject1.getString("maxuser");

                                    TargetMarket = jsonObject1.getString("targetmarket");
                                    Desc = jsonObject1.getString("ideadiscription");
                                }
                            }

                            textViewideaTitle.setText(ideaTitle);
                            textViewTenKeyword.setText(TenKeyword);
                            textViewKeyUser.setText(KeyUser);
                            textViewMaxKeyUser.setText(MaxKeyUser);
                            textViewTargetMarket.setText(TargetMarket);
                            textViewDesc.setText(Desc);
                            textViewDate.setText(ideaDate);
                            textViewStatus.setText(Status);


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
