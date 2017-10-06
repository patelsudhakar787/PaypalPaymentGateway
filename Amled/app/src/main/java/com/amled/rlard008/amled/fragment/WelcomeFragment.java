package com.amled.rlard008.amled.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.activities.SelectLightActivity;
import com.amled.rlard008.amled.adapter.WelcomeRecyclerView;
import com.amled.rlard008.amled.api.CustomClick;
import com.amled.rlard008.amled.pojo.WelcomeImageData;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by sudhakar on 4/26/17.
 */

public class WelcomeFragment extends android.support.v4.app.Fragment{

    private ImageView image;
    private Button btn_oemrequest;
    private Button btn_productinfo;
    private RecyclerView recyclerView;
    private WelcomeImageData welcomeImageData;
    private TextView textv;
//    private RecyclerView recyclerView1;
//    private RecyclerView recyclerView2;
    private ArrayList<WelcomeImageData>arrayList;
    private static int i=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.layout_welcomefgr,container,false);
        image=(ImageView)itemview.findViewById(R.id.image);
        recyclerView=(RecyclerView)itemview.findViewById(R.id.rv);
        textv=(TextView)itemview.findViewById(R.id.text);
//        recyclerView1=(RecyclerView)itemview.findViewById(R.id.rv1);
//        recyclerView2=(RecyclerView)itemview.findViewById(R.id.rv2);

        //callling function
        addingListData();

        LinearLayoutManager llm=new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(llm);
//        LinearLayoutManager llm1=new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
//        recyclerView1.setLayoutManager(llm1);
//
//        LinearLayoutManager llm2=new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
//        recyclerView2.setLayoutManager(llm2);
        WelcomeRecyclerView adapter=new WelcomeRecyclerView(getContext(), recyclerView, arrayList, new CustomClick() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("Position",""+position);
                showDialog(view,position);
            }
        });
        recyclerView.setAdapter(adapter);
//        WelcomeRecyclerView adapter1=new WelcomeRecyclerView(getContext(), recyclerView1, arrayList, new CustomClick() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Log.e("Position",""+position);
//                showDialog(view,position);
//            }
//        });
//        recyclerView1.setAdapter(adapter1);
//        WelcomeRecyclerView adapter2=new WelcomeRecyclerView(getContext(), recyclerView2, arrayList, new CustomClick() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Log.e("Position",""+position);
//                showDialog(view,position);
//            }
//        });
//        recyclerView2.setAdapter(adapter2);

        btn_oemrequest=(Button)itemview.findViewById(R.id.btnoemrequest);
        btn_productinfo=(Button)itemview.findViewById(R.id.btnproductInfo);


       //timer for images

        //click listener on recyclerview
        final Handler handler=new Handler();
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    welcomeImageData=arrayList.get(i);
                        image.setImageResource(welcomeImageData.getImageid());
                        textv.setText(welcomeImageData.getImagename());
                        i++;
                        if(i==5)
                        {
                            i=0;
                        }
                    }
                });
            }
        };
        timer.schedule(timerTask,0,4*1000);


       //click listener on button
        btn_oemrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), SelectLightActivity.class);
                startActivity(intent);

            }
        });


        btn_productinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.amledindia.com/our-products";
                Uri uri=Uri.parse(url);
                Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);

            }
        });

        return itemview;
    }




    public void addingListData() {
        arrayList = new ArrayList<>();
        arrayList.add(new WelcomeImageData(R.drawable.tubelight, "Tube Light"));
        arrayList.add(new WelcomeImageData(R.drawable.baylight, "Bay Light"));
        arrayList.add(new WelcomeImageData(R.drawable.floodlight, "Flood Light"));
        arrayList.add(new WelcomeImageData(R.drawable.streetlight, "Street Light"));
        arrayList.add(new WelcomeImageData(R.drawable.panellight, "Panel Light"));


    }
    public void showDialog(View vIew,int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        ImageView imageView=new ImageView(getContext());
        WelcomeImageData welcomeImageData=arrayList.get(position);
        imageView.setBackgroundResource(welcomeImageData.getImageid());
        builder.setNegativeButton("Back", null).setTitle(welcomeImageData.getImagename());
        builder.setView(imageView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
