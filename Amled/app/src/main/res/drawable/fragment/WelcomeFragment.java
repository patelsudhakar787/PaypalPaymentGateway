package com.example.sudhakar.amled.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sudhakar.amled.R;
import com.example.sudhakar.amled.activities.RegistrationActivity;

/**
 * Created by sudhakar on 4/26/17.
 */

public class WelcomeFragment extends android.support.v4.app.Fragment{


    private ImageView imagewelcome1;
    private ImageView imagewelcome2;
    private ImageView imagewelcome3;

    private Button btn_oemrequest;
    private Button btn_productinfo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.layout_welcomefgr,container,false);
        imagewelcome1=(ImageView)itemview.findViewById(R.id.imagewelcome1);
        imagewelcome2=(ImageView)itemview.findViewById(R.id.imagewelcome2);
    //    imagewelcome3=(ImageView)itemview .findViewById(R.id.imagewelcome3);

        btn_oemrequest=(Button)itemview.findViewById(R.id.btnoemrequest);
        btn_productinfo=(Button)itemview.findViewById(R.id.btnproductInfo);




       //click listener on button
        btn_oemrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), RegistrationActivity.class);
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






}
