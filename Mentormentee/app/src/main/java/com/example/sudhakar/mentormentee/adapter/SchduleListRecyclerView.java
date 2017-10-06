package com.example.sudhakar.mentormentee.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sudhakar.mentormentee.R;
import com.example.sudhakar.mentormentee.pojo.MeetingInfo;

import java.util.ArrayList;

/**
 * Created by sudhakar on 4/24/17.
 */

public class SchduleListRecyclerView extends RecyclerView.Adapter<SchduleListRecyclerView.Schdule>{
    public ArrayList<MeetingInfo>arrayListdata;

    public SchduleListRecyclerView(ArrayList<MeetingInfo>arrayListdata)
    {
        this.arrayListdata=arrayListdata;
    }


    @Override
    public Schdule onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutunder_listview,parent,false);
        return new Schdule(view);
    }

    @Override
    public void onBindViewHolder(Schdule holder, int position) {
    if(arrayListdata != null) {
        MeetingInfo info = arrayListdata.get(position);
        Schdule.textviewtime.setText(info.getTime());
        Schdule.textViewwith.setText(info.getTime());
        Schdule.textviewvenue.setText(info.getVenue());
        Schdule.textviewpurpose.setText(info.getPurpose());

    }

    }

    @Override
    public int getItemCount() {
     return arrayListdata.size();
    }

    public static class Schdule extends RecyclerView.ViewHolder
    {
       static TextView textviewtime;
       static TextView textViewwith;
        static TextView textviewvenue;
        static TextView textviewpurpose;

        public Schdule(View itemView) {
            super(itemView);
            textviewtime=(TextView)itemView.findViewById(R.id.textviewtime);
            textViewwith=(TextView)itemView.findViewById(R.id.textviewwith);
            textviewvenue=(TextView)itemView.findViewById(R.id.textviewvenue);
            textviewpurpose=(TextView)itemView.findViewById(R.id.textviewpurpose);

        }

    }




}

