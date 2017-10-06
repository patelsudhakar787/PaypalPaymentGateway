package com.prasanna.rlard008.ergoptixapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CalcEyeDistanceActivity extends AppCompatActivity {


    ImageView imageViewPupil;

    Button buttonNext;
    EditText editTextLeftPupil,editTextRightPupil,editTextHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_eye_distance);

        imageViewPupil = (ImageView) findViewById(R.id.imageViewPupil);

        buttonNext = (Button) findViewById(R.id.nextPupil);

        editTextLeftPupil = (EditText) findViewById(R.id.editTextLeftPupil);
        editTextRightPupil = (EditText) findViewById(R.id.editTextRightPupil);
        editTextHeight = (EditText) findViewById(R.id.editTextHeight);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String leftPupil = editTextLeftPupil.getText().toString();
                String rightPupil = editTextRightPupil.getText().toString();
                String height = editTextHeight.getText().toString();

                if (TextUtils.isEmpty(leftPupil)) {
                    editTextLeftPupil.setError(getString(R.string.error_field_required));

                }

                else if (TextUtils.isEmpty(rightPupil)) {
                    editTextRightPupil.setError(getString(R.string.error_field_required));

                }

                else if (TextUtils.isEmpty(height)) {
                    editTextHeight.setError(getString(R.string.error_field_required));

                }

                else {
                    SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("leftPupil", leftPupil);
                    editor.putString("rightPupil", rightPupil);
                    editor.putString("height", height);
                    editor.commit();

                    Intent intent = new Intent(CalcEyeDistanceActivity.this, WorkingDistanceActivity.class);
                    startActivity(intent);

                    Log.e("leftPupil", "" + leftPupil);
                    Log.e("right", "" + rightPupil);
                    Log.e("height", "" + height);
                }
            }
        });
    }
}
