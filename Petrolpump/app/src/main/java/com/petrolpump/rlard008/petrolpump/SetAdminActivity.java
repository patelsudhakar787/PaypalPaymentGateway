package com.petrolpump.rlard008.petrolpump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetAdminActivity extends AppCompatActivity {

    Button buttonRegAdmin, buttonMrgLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_admin);

        buttonMrgLogin = (Button) findViewById(R.id.mgr_login);
        buttonRegAdmin = (Button) findViewById(R.id.reg_admin);


        buttonMrgLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetAdminActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        buttonRegAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SetAdminActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
