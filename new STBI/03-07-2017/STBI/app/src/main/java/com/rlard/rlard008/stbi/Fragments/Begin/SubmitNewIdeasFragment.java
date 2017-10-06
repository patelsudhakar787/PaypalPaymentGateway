package com.rlard.rlard008.stbi.Fragments.Begin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubmitNewIdeasFragment extends Fragment {


    Button buttonSubmit, buttonClose;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview=inflater.inflate(R.layout.fragment_submit_new_ideas,container,false);


        buttonClose = (Button) itemview.findViewById(R.id.btn_close);
        buttonSubmit = (Button) itemview.findViewById(R.id.btn_submit);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                loadIdeasFragment();


            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getData();
//
//                sendSubmitRequest();
//
                Toast.makeText(getContext(),"Idea Submitted",Toast.LENGTH_LONG).show();

                loadIdeasFragment();
            }
        });

        return itemview;

    }

    public void loadIdeasFragment()
    {
        IdeasFragment frg=new IdeasFragment();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,frg);
        ft.commit();
    }

}
