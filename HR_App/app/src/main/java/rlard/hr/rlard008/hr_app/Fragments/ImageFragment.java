package rlard.hr.rlard008.hr_app.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rlard.hr.rlard008.hr_app.R;

/**
 * Created by sudhakar on 9/26/17.
 */

public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.fragment_image,container,false);

        return itemview;
    }
}
