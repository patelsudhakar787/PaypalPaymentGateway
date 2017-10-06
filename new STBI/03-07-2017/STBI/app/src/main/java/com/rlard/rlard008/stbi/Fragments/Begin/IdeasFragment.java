package com.rlard.rlard008.stbi.Fragments.Begin;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class IdeasFragment extends Fragment {


    private Button btn_submit;
    private Button btn_otheIdeas;
    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_ideas,container,false);

        btn_submit=(Button)itemview.findViewById(R.id.btn_sbt);
        //btn_otheIdeas=(Button)itemview.findViewById(R.id.btn_otherIdeas);
        listView=(ListView)itemview.findViewById(R.id.listview);
        arrayListIdeaPojo = new ArrayList<>();

        loadExistingideas();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                btn_submit.setVisibility(View.GONE);
                //btn_otheIdeas.setVisibility(View.GONE);
                listView.setVisibility(View.GONE);



                SubmitNewIdeasFragment frg=new  SubmitNewIdeasFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();


            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getContext(),"Title Clicked",Toast.LENGTH_LONG).show();

                IdeaDetails_BeginFragment frg=new IdeaDetails_BeginFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.container,frg);
                ft.commit();
            }
        });

        return itemview;
    }

    void loadExistingideas() {

        String title="Please Open this page before 30 minutes " +
                "prior to sale starts.Please make sure your system time " +
                "is synchronized and logged in to mi.com";
        String date="08/07/2017";
        String status="Pending";

        pojo=new IdeaPojo("5252553",title,date,status,"No service");
        arrayListIdeaPojo.add(pojo);


        ListViewAdapter adapter=new ListViewAdapter();
        listView.setAdapter(adapter);
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
