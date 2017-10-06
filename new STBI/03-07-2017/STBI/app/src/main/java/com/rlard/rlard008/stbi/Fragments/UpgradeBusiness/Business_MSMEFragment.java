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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_CommercializationFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_DepartmentFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.SIG_MyPofileFragment;
import com.rlard.rlard008.stbi.Fragments.UpgradeSkills.JuniorSkillsFragment;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Business_MSMEFragment extends Fragment {

    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView=inflater.inflate(R.layout.fragment_business__msme, container, false);


        listView=(ListView)itemView.findViewById(R.id.MSME_listview);
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
            convertView=inflater.inflate(R.layout.upgrade_skill_layout_listview,parent,false);

            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaIdSkill);
            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofSkill);
            TextView tvdate=(TextView)convertView.findViewById(R.id.dateSkill);
//            TextView tvstatus=(TextView)convertView.findViewById(R.id.status2);
//            TextView tvmyservices=(TextView)convertView.findViewById(R.id.myservices2);

            TextView respond=(TextView)convertView.findViewById(R.id.tvApply);
            TextView del=(TextView)convertView.findViewById(R.id.tvupdateProgress);

            respond.setText("View Update");
            del.setText("View Response");

            final LinearLayout expand =(LinearLayout)convertView.findViewById(R.id.event_expand);
            final TextView expandButton =(TextView)convertView.findViewById(R.id.expand_button);

            expand.setVisibility(View.GONE);

            IdeaPojo pojo=arrayListIdeaPojo.get(position);
            tvIdeaId.setText(pojo.getIdeaId());
            tvtitleofidea.setText(pojo.getTitleofidea());
            tvdate.setText(pojo.getDate());
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
