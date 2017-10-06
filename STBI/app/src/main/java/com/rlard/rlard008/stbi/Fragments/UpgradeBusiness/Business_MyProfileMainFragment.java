package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Business_MyProfileMainFragment extends Fragment {

    TextView textViewDetails,textViewProduct,textViewCourse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_business__my_profile_main, container, false);

        textViewProduct = (TextView) itemView.findViewById(R.id.textviewCompanyProduct);
        textViewDetails = (TextView) itemView.findViewById(R.id.textviewCompanyDetails);
        textViewCourse = (TextView) itemView.findViewById(R.id.textviewCompanyCourse);

        textViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_MyProfileFragment frg=new Business_MyProfileFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();

            }
        });

        textViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_CompanyCourseFragment frg=new  Business_CompanyCourseFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();
            }
        });

        textViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Business_CompanyProductFragment frg=new Business_CompanyProductFragment();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.BusinessContainer,frg);
                ft.commit();
            }
        });

        return itemView;
    }

}
