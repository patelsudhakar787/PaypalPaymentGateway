package com.rlard.tubelighttestingrack.pojo;

/**
 * Created by sudhakar on 4/5/17.
 */

public class SetTimeFormat {

    public static String setTimeFormat(String createdtime)
    {
        String converteddate="";
        String convertedtime="";
        String settime="";

        //2017-04-05T07:40:15Z
        String []time=createdtime.split("");
        converteddate=""+time[0]+""+time[1]+""+time[2]+""+time[3]+""+time[4]+""+time[5]+""+time[6]+""+time[7]+""+time[8]+""+time[9]+""+time[10];
        convertedtime=""+time[12]+""+time[13]+""+time[14]+""+time[15]+""+time[16]+""+time[17]+""+time[18]+""+time[19];
        String[]ttime=convertedtime.split(":");

        int hour=Integer.parseInt(ttime[0])+5;
        if(hour>24)
        {
            hour=hour%24;
        }

        int minute=Integer.parseInt(""+ttime[1])+30;
        if(minute>60)
        {
            hour=hour+1;
            minute=minute%60;
        }
        int second=Integer.parseInt(""+ttime[2]);
        if(second>60)
        {
            minute=minute+1;
            second=second%60;
        }
        String setltime=""+hour+":"+minute+":"+second;
        settime=setltime;
        return settime;
    }

}
