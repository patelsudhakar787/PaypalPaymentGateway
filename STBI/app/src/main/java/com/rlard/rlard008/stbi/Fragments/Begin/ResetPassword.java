package com.rlard.rlard008.stbi.Fragments.Begin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rlard.rlard008.stbi.R;

/**
 * Created by sudhakar on 8/28/17.
 */

public class ResetPassword extends Fragment {

    private EditText etenterpassword;
    private Button btn_reset;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View itemview=inflater.inflate(R.layout.fragment_begin_reset_password,container,false);
        etenterpassword=(EditText)itemview.findViewById(R.id.reset);
        btn_reset=(Button)itemview.findViewById(R.id.btn_reset);

        String password=etenterpassword.getText().toString();
        password=password.replace(" ","");

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return itemview;
    }
}
