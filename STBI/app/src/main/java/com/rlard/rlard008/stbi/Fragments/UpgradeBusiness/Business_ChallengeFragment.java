package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Business_ChallengeFragment extends Fragment {


    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView=inflater.inflate(R.layout.fragment_business__challenge, container, false);


        listView = (ListView) itemView.findViewById(R.id.challenge_listview);
        arrayListIdeaPojo = new ArrayList<>();

        loadExistingideas();

        return itemView;
    }

    void loadExistingideas() {

        String title="Abc";
        String date="08/07/2017";
        String status="";

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
            super(getActivity(),R.layout.upgrade_skill_layout_listview,arrayListIdeaPojo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.ideas_layout_listview,parent,false);
//
//            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaIdSkill);
//            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofSkill);
//            TextView tvdate=(TextView)convertView.findViewById(R.id.dateSkill);

            TextView tvIdeaId = (TextView) convertView.findViewById(R.id.ideaId2);
            TextView tvtitleofidea = (TextView) convertView.findViewById(R.id.titleofidea2);
            TextView tvdate = (TextView) convertView.findViewById(R.id.date2);
            TextView tvstatus = (TextView) convertView.findViewById(R.id.status2);

            TextView respond=(TextView)convertView.findViewById(R.id.mySupport);
            TextView del=(TextView)convertView.findViewById(R.id.updateProgress);

            respond.setText("Apply");
            del.setText("Update Progress");


            final LinearLayout expand =(LinearLayout)convertView.findViewById(R.id.event_expand);
            final TextView expandButton =(TextView)convertView.findViewById(R.id.expand_button);

            expand.setVisibility(View.GONE);


            IdeaPojo pojo=arrayListIdeaPojo.get(position);
            tvIdeaId.setText(pojo.getIdeaId());
            tvtitleofidea.setText(pojo.getTitleofidea());
            tvdate.setText(pojo.getDate());
            tvstatus.setText(pojo.getStatus());
//            tvstatus.setText(pojo.getStatus());
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
