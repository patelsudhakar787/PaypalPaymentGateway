package com.rlard.rlard008.stbi.Fragments.ManageSIG;


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

import com.rlard.rlard008.stbi.Fragments.Begin.IdeaDetails_BeginFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.IdeasFragment;
import com.rlard.rlard008.stbi.Fragments.Begin.SubmitNewIdeasFragment;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class IdeaSIGFragment extends Fragment {


    private Button btn_filter;

    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    private ListView listView;

    IdeaPojo pojo;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemview=inflater.inflate(R.layout.fragment_idea_sig, container, false);


        btn_filter=(Button)itemview.findViewById(R.id.btn_filter);

        listView=(ListView)itemview.findViewById(R.id.sig_Listview);
        arrayListIdeaPojo = new ArrayList<>();

        loadExistingideas();

//        btn_filter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                btn_filter.setVisibility(View.GONE);
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
//
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getContext(),"Title Clicked",Toast.LENGTH_LONG).show();

                IdeaDetails_SIGFragment frg=new IdeaDetails_SIGFragment();
                android.support.v4.app.FragmentManager fm=getFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.ManageSigContainer,frg);
                ft.commit();
            }
        });

        return itemview;
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
            super(getActivity(),R.layout.sig_idea_listview_layout,arrayListIdeaPojo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater=getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.sig_idea_listview_layout,parent,false);

            TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaId2);
            TextView tvtitleofidea=(TextView)convertView.findViewById(R.id.titleofidea2);
            TextView tvdate=(TextView)convertView.findViewById(R.id.date2);
            TextView tvstatus=(TextView)convertView.findViewById(R.id.status2);
//            TextView tvmyservices=(TextView)convertView.findViewById(R.id.myservices2);

            TextView respond=(TextView)convertView.findViewById(R.id.mySupport);
           // TextView del=(TextView)convertView.findViewById(R.id.updateProgress);

            respond.setText("My Support");
            //del.setVisibility(View.GONE);

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
