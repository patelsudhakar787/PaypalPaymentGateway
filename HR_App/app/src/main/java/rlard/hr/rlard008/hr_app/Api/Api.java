package rlard.hr.rlard008.hr_app.Api;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by sudhakar on 5/9/17.
 */

public class Api {


    public static long calculatetime(String time1, String time2) throws ParseException {
        String splittime1[]=time1.split(":");
        String date1=splittime1[0];
        String month1=splittime1[1];
        String year1=splittime1[2];
        String hour1=splittime1[3];
        String minute1=splittime1[4];
        int tminute=0;

        String splittime2[]=time2.split(":");
        String date2=splittime2[0];
        String month2=splittime2[1];
        String year2=splittime2[2];
        String hour2=splittime2[3];
        String minute2=splittime2[4];

        int yeardiff=Integer.parseInt(year2)-Integer.parseInt(year1);
        int monthdiff=Integer.parseInt(month2)-Integer.parseInt(month1);
        int datediff=Integer.parseInt(date2)-Integer.parseInt(date1);
        int hourdiff=Integer.parseInt(hour2)-Integer.parseInt(hour1);
        int minutediff=Integer.parseInt(minute2)-Integer.parseInt(minute1);
        tminute=12*30*24*60*yeardiff+30*24*60*monthdiff+24*60*datediff+60*hourdiff+minutediff;
        return tminute;
    }


    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static String getCurrentdate()
    {
        Calendar calendar=Calendar.getInstance();
        int date=calendar.get(Calendar.DATE);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        String currentdate=date+":"+month+":"+year;
        return currentdate;


    }
    public static ArrayList<String> getHour()
    {
        ArrayList<String>al=new ArrayList<>();
        al.add("0");
        al.add("1");
        al.add("2");
        al.add("3");
        al.add("4");
        al.add("5");
        al.add("6");
        al.add("7");
        al.add("8");
        al.add("9");
        al.add("10");
        al.add("11");
        al.add("12");
        al.add("13");
        al.add("14");
        al.add("15");
        al.add("16");
        al.add("17");
        al.add("18");
        al.add("19");
        al.add("20");
        al.add("21");
        al.add("22");
        al.add("23");

       return al;
    }

    public static ArrayList<String> getMinute()
    {
        ArrayList<String>al=new ArrayList<>();
        al.add("0");
        al.add("1");
        al.add("2");
        al.add("3");
        al.add("4");
        al.add("5");
        al.add("6");
        al.add("7");
        al.add("8");
        al.add("9");
        al.add("10");
        al.add("11");
        al.add("12");
        al.add("13");
        al.add("14");
        al.add("15");
        al.add("16");
        al.add("17");
        al.add("18");
        al.add("19");
        al.add("20");
        al.add("21");
        al.add("22");
        al.add("23");
        al.add("24");
        al.add("25");
        al.add("26");
        al.add("27");
        al.add("28");
        al.add("29");
        al.add("30");
        al.add("31");
        al.add("32");
        al.add("33");
        al.add("34");
        al.add("35");
        al.add("36");
        al.add("37");
        al.add("38");
        al.add("39");
        al.add("40");
        al.add("41");
        al.add("42");
        al.add("43");
        al.add("44");
        al.add("45");
        al.add("46");
        al.add("47");
        al.add("48");
        al.add("49");
        al.add("50");
        al.add("51");
        al.add("52");
        al.add("53");
        al.add("54");
        al.add("55");
        al.add("56");
        al.add("57");
        al.add("58");
        al.add("59");

        return al;
    }



}
