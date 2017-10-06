package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class WorkingDistanceActivity extends AppCompatActivity {

    String workingDistance1;

    Button buttonSubmit;
    EditText editTextWorkingDistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_working_distance);


        buttonSubmit = (Button) findViewById(R.id.Submit);
        editTextWorkingDistance = (EditText) findViewById(R.id.editTextWorkingDistance);


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                workingDistance1 = editTextWorkingDistance.getText().toString();

                if (TextUtils.isEmpty(workingDistance1)) {
                    editTextWorkingDistance.setError(getString(R.string.error_field_required));

                }

                else {


                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("workingDistance", workingDistance1);

                    editor.commit();

                    Intent intent = new Intent(WorkingDistanceActivity.this,SubmitTTLRequestActivity.class);
                    startActivity(intent);
                }

            }
        });

    } //// eof onCreate


}
