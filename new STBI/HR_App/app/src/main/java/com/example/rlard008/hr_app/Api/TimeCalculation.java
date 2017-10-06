package com.example.rlard008.hr_app.Api;

import java.text.ParseException;

/**
 * Created by sudhakar on 5/9/17.
 */

public class TimeCalculation {


    public static long calculatetime(String time1, String time2) throws ParseException {
        String splittime1[]=time1.split(":");
        String hour1=splittime1[0];
        String minute1=splittime1[1];
        int tminute=0;

        String splittime2[]=time2.split(":");
        String hour2=splittime2[0];
        String minute2=splittime2[1];

        int hourdiff=Integer.parseInt(hour2)-Integer.parseInt(hour1);
        int minutediff=Integer.parseInt(minute2)-Integer.parseInt(minute1);
        tminute=60*hourdiff+minutediff;
        return tminute;
    }




}
