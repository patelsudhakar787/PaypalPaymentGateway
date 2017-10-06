package com.rlard.rlard008.stbi.Fragments.FindOpportinuty;


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
import android.widget.Toast;

import com.rlard.rlard008.stbi.Fragments.ManageSIG.GrantsAndFundFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.HackathonFragment;
import com.rlard.rlard008.stbi.Fragments.ManageSIG.MyOpportinutyFragment;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Find_MyOppFragment extends Fragment {

    private Button btn_filter;

    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_find__my_opp, container, false);


        btn_filter=(Button)itemView.findViewById(R.id.find_intern_btn_filter);

        listView=(ListView)itemView.findViewById(R.id.find_intern_Listview);
        arrayListIdeaPojo = new ArrayList<>();

        loadExistingideas();


        return itemView;
    }

    void loadExistingideas() {

        String title="Abc";
        String date="08/07/2017";
        String status="Pending";

        pojo=new IdeaPojo("5252553",title,date,status,"No service");
        arrayListIdeaPojo.add(pojo);


        ListAdapter adapter=new ListAdapter();
        listView.setAdapter(adapter);
    }


    //class
    class ListAdapter extends ArrayAdapter<IdeaPojo>
    {

        Boolean isExpand = false;

        public ListAdapter() {
            super(getActivity(),R.layout.ideas_layout_listview,arrayListIdeaPojo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.project_layout_listview,parent,false);

            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaIdProject);
            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofProect);
            TextView tvdate=(TextView)convertView.findViewById(R.id.dateProject);
            TextView tvstatus=(TextView)convertView.findViewById(R.id.statusProject);
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
