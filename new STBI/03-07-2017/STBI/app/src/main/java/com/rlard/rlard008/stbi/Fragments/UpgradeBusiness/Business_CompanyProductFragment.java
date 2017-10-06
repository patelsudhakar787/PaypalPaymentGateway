package com.rlard.rlard008.stbi.Fragments.UpgradeBusiness;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Business_CompanyProductFragment extends Fragment {

    Button buttonAddDetails;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View itemView = inflater.inflate(R.layout.fragment_business__company_product, container, false);

        buttonAddDetails = (Button) itemView.findViewById(R.id.business_product_AddDetails);

        return itemView;

    }


}
