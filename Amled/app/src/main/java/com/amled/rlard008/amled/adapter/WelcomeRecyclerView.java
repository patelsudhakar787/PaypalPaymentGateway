package com.amled.rlard008.amled.adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.api.CustomClick;
import com.amled.rlard008.amled.pojo.WelcomeImageData;

import java.util.ArrayList;

/**
 * Created by sudhakar on 7/17/17.
 */

public class WelcomeRecyclerView extends RecyclerView.Adapter<WelcomeRecyclerView.RecyclerViewData> {

    private RecyclerView recyclerView;
    private Context context;
    private ArrayList<WelcomeImageData>arrayList;
    private CustomClick customClick;

    public WelcomeRecyclerView(Context context,RecyclerView recyclerView,ArrayList<WelcomeImageData>arrayList,CustomClick customClick)
    {
        this.context=context;
        this.recyclerView=recyclerView;
        this.arrayList=arrayList;
        this.customClick=customClick;
    }

    @Override
    public RecyclerViewData onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.welcomerecyclerviewitems,parent,false);
        final RecyclerViewData recyclerViewData=new RecyclerViewData(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customClick.onItemClick(view,recyclerViewData.getPosition());
            }
        });
        return recyclerViewData;
    }

    @Override
    public void onBindViewHolder(RecyclerViewData holder, final int position) {
        WelcomeImageData welcomeImageData=arrayList.get(position);
        RecyclerViewData.imageView.setImageResource(welcomeImageData.getImageid());
        RecyclerViewData.textView.setText(welcomeImageData.getImagename());
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("Position",""+position);
//                v.setOnClickListener(this);
//                showDialog(v,position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    static class RecyclerViewData extends RecyclerView.ViewHolder
    {
        static ImageView imageView;
        static TextView textView;
        public RecyclerViewData(View itemView) {
            super(itemView);

            imageView=(ImageView)itemView.findViewById(R.id.image);
            textView=(TextView)itemView.findViewById(R.id.tv);

        }
    }


}
