package com.rlard.rlard008.stbi.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.rlard.rlard008.stbi.BeginActivity;
import com.rlard.rlard008.stbi.Pojo.IdeaPojo;
import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private ArrayList<IdeaPojo> arrayListIdeaPojo;
    //IdeaPojo pojo,pojo1;

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_events, container, false);

        listView=(ListView)itemview.findViewById(R.id.event_listview);
        arrayListIdeaPojo = new ArrayList<>();

        addEventData();

        return itemview;
    }

    public void addEventData() {

        arrayListIdeaPojo = new ArrayList<>();

//        String title="Abc Event";
//        String date="08/07/2017";
        //String status="Pending";

        arrayListIdeaPojo.add(new IdeaPojo("","ABC Event","21/07/2017","","I am Interested"));


        arrayListIdeaPojo.add(new IdeaPojo("","Please Open this page before 30 minutes " +
                "prior to sale starts.Please make sure your system time " +
                "is synchronized and logged in to mi.com","23/07/2017","","I am Interested"));

        //arrayListIdeaPojo.add(new IdeaPojo("","PQR Event","25/07/2017","","I am Interested"));

        Log.e("arraylist",""+arrayListIdeaPojo);


        EventListViewAdapter adapter=new EventListViewAdapter();
        listView.setAdapter(adapter);

    }


    //class
    class EventListViewAdapter extends ArrayAdapter<IdeaPojo>
    {
        Boolean isExpand = false;

        public EventListViewAdapter() {
            super(getActivity(),R.layout.event_layout_listview,arrayListIdeaPojo);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = getActivity().getLayoutInflater();
            convertView=inflater.inflate(R.layout.event_layout_listview,parent,false);

            //  TextView tvIdeaId=(TextView)convertView.findViewById(R.id.ideaId2);
            TextView tvTitle=(TextView)convertView.findViewById(R.id.event_title);
            TextView tvDate=(TextView)convertView.findViewById(R.id.event_date);

            final LinearLayout expand =(LinearLayout)convertView.findViewById(R.id.event_expand);
            final TextView expandButton =(TextView)convertView.findViewById(R.id.expand_button);
            //  TextView tvstatus=(TextView)convertView.findViewById(R.id.status2);

            //    TextView tvInterested=(TextView)convertView.findViewById(R.id.event_interested);

            expand.setVisibility(View.GONE);

            IdeaPojo pojo=arrayListIdeaPojo.get(position);

            tvTitle.setText(pojo.getTitleofidea());
            tvDate.setText(pojo.getDate());

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
                       // TransitionManager.beginDelayedTransition(expand);
                        //detailsView.setVisibility(View.VISIBLE);
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
