package com.prasanna.rlard008.ergoptixapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutUSActivity extends AppCompatActivity {

    TextView textViewTitle,textViewManish,textViewAnurag,textViewVision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        textViewAnurag = (TextView) findViewById(R.id.textViewAnurag);
        textViewManish = (TextView) findViewById(R.id.textViewManish);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewVision = (TextView) findViewById(R.id.textViewVision);


        textViewTitle.setText("Ergoptix has been designed by Regional Laboratory for Applied Research and Development" +
                "(RLARD), India. Founded by Prof. Manish Patil and Mr Anurag Chugh. RLARD offers a variety of products and"+
                "services which can be read about on our website www.rlard.com");

        textViewManish.setText("RLARD being his 3rd start up venture, Manish's focus area is product design and system integration.  " +
                "He has been active in bridging the gap between industry and academia and brings with him an extensive experience interfacing " +
                "with vendors across the world for product development cycle. With 23 years of experience in electronics product design, " +
                "Manish also holds a successful record of delivering turnkey highway traffic management system for expressways." +
                " To know more about Manish, checkout his LinkedIn profile.");

        textViewAnurag.setText("A Teach For India alumnus, Anurag spent two years working in an underprivileged school in Pune, " +
                "teaching 120 children from the 7th and 8th grade, developing his leadership skills. For 8 years before the fellowship," +
                " Anurag has been involved in developing and debugging embedded software and hardware as part of various design teams. " +
                "His focus lies in Embedded Linux platforms and the Internet of  things. In the past, he has worked at Larsen & Toubro," +
                " Tata Consultancy Services and Greenvity Communications (US based startup which developed a PLC ASIC). ");

        textViewVision.setText("\"We see Ergoptix as becoming a bouquet of holistic services and products centered around enhancing " +
                "ergonomics in the dental workplace.\"");

    }
}
