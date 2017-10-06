package com.rlard.rlard008.stbi.Fragments.JoinAsMentor;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentor_IdeasFragment extends Fragment {


    private Button btn_filter;
    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;
    private static String Existing_Ideas_URL;

    String areaOfSupport = null;

    private SharedPreferences sharedPreferencesideaid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_mentor__ideas, container, false);

        btn_filter = (Button)itemview.findViewById(R.id.mentor_btn_filter);
        listView=(ListView)itemview.findViewById(R.id.mentor_ideas_listview);
        arrayListIdeaPojo = new ArrayList<>();

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("login_mentor",MODE_PRIVATE);
        areaOfSupport = sharedPreferences.getString("areaOfSupport","");

        areaOfSupport = areaOfSupport.replace(" ","_");

        Log.e("areaOfSupport",""+areaOfSupport);

        sharedPreferencesideaid=getContext().getSharedPreferences("sfideaid",MODE_PRIVATE);

        Existing_Ideas_URL = "http://10.10.0.220:8081/STBI/MentorDashBoardServlet?is_Mobile=1&module=mentorideas&aos="+areaOfSupport;//begin-dashboard.jsp?email=sheetal.khankar@rlard.com&is_Mobile=1";
//STBI/MentorDashBoardServlet
        Log.e("Existing_Ideas_URL",""+Existing_Ideas_URL);

        loadExistingideas();

        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                btn_submit.setVisibility(View.GONE);
//                //btn_otheIdeas.setVisibility(View.GONE);
//                listView.setVisibility(View.GONE);
//
//
//
//                SubmitNewIdeasFragment frg=new  SubmitNewIdeasFragment();
//                android.support.v4.app.FragmentManager fm=getFragmentManager();
//                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
//                ft.replace(R.id.container,frg);
//                ft.commit();
//

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getContext(),"Title Clicked",Toast.LENGTH_LONG).show();

                IdeaPojo ideaPojo=arrayListIdeaPojo.get(i);
                String ideaid=ideaPojo.getIdeaId();

                SharedPreferences.Editor editor=sharedPreferencesideaid.edit();
                editor.putString("mideaid",ideaid);
                editor.commit();

                Mentor_IdeaDetailsFragment frg=new Mentor_IdeaDetailsFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.mentorContainer,frg);
                ft.commit();
            }
        });

        return itemview;
    }

    void loadExistingideas() {

//        String title="Abc";
//        String date="08/07/2017";
//        String status="Pending";
//
//        pojo=new IdeaPojo("5252553",title,date,status,"No service");
//        arrayListIdeaPojo.add(pojo);
//
//
//        ListViewAdapter adapter=new ListViewAdapter();
//        listView.setAdapter(adapter);

        StringRequest stringRequest = new StringRequest(Existing_Ideas_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Mentor exist idea resp",""+response);
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            pojo=null;

                            JSONObject jsonObject1=null;

                            for(int i=0;i<jsonArray.length();i++)
                            {
                                jsonObject1=jsonArray.getJSONObject(i);

                                String ideaid = jsonObject1.getString("ideaid");
                                String title=jsonObject1.getString("titlename");
                                String date=jsonObject1.getString("idaeregidate");
                                String status=jsonObject1.getString("statusofidea");

                                pojo=new IdeaPojo(ideaid,title,date,status,"No service");
                                arrayListIdeaPojo.add(pojo);
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

                        Log.e("Mentor exist idea error",""+error);
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    //class
    class ListViewAdapter extends ArrayAdapter<IdeaPojo>
    {

        Boolean isExpand = false;

        public ListViewAdapter() {
            super(getActivity(),R.layout.ideas_layout_listview,arrayListIdeaPojo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.ideas_layout_listview,parent,false);

            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaId2);
            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofidea2);
            TextView tvdate=(TextView)convertView.findViewById(R.id.date2);
            TextView tvstatus=(TextView)convertView.findViewById(R.id.status2);
//            TextView tvmyservices=(TextView)convertView.findViewById(R.id.myservices2);

            TextView respond=(TextView)convertView.findViewById(R.id.mySupport);
            TextView del=(TextView)convertView.findViewById(R.id.updateProgress);

            respond.setText("Respond");
//            del.setVisibility(View.GONE);

//            del.setCompoundDrawablesWithIntrinsicBounds(
//                    0, 0, 0, 0);
//
//            del.setCompoundDrawablesWithIntrinsicBounds(
//                    R.drawable.trashorange, 0, 0, 0);

            final LinearLayout expand =(LinearLayout)convertView.findViewById(R.id.event_expand);
            final TextView expandButton =(TextView)convertView.findViewById(R.id.expand_button);

            expand.setVisibility(View.GONE);



            IdeaPojo pojo=arrayListIdeaPojo.get(position);
            tvIdeaId.setText(pojo.getIdeaId());
            tvtitleofidea.setText(pojo.getTitleofidea());
            tvdate.setText(pojo.getDate());
            tvstatus.setText(pojo.getStatus());
//            tvmyservices.setText(pojo.getMyservices());

//            tvtitleofidea.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    Toast.makeText(getContext(),"Title Clicked",Toast.LENGTH_LONG).show();
//                }
//            });

            expandButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (isExpand == true) {
                        expand.setVisibility(View.GONE);
                        isExpand = false;
                        expandButton.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        // expandButton.setCompoundDrawablesWithIntrinsicBounds(
                        //       R.drawable.expand1, 0, 0, 0);
                    }
                    else {
                        expand.setVisibility(View.VISIBLE);
                        isExpand = true;
                        expandButton.setCompoundDrawablesWithIntrinsicBounds(
                                0, 0, 0, 0);
                        expandButton.setCompoundDrawablesWithIntrinsicBounds(
                                R.drawable.collapse1, 0, 0, 0);
                    }
                }
            });


            return convertView;
        }
    }

}