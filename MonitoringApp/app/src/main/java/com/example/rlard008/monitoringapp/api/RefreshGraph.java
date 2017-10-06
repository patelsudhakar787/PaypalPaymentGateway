package com.example.rlard008.monitoringapp.api;

import com.example.rlard008.monitoringapp.codeandReason.CodeReason;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by sudhakar on 4/12/17.
 */

public class RefreshGraph {

    public static void refresh(ArrayList<Float> arraylistgraphdata, ArrayList<String> arraylisttime, ArrayList<Entry> arraylistentry, LineDataSet dataset, LineData data, LineChart linechart,String channelname) {
        if(arraylistgraphdata !=null) {
            try {
                for (int i = 0; i < arraylisttime.size(); i++) {
                    arraylistentry.add(new Entry(arraylistgraphdata.get(i), i));
                }
                if (channelname.equals("RefilTime")) {
                    dataset = new LineDataSet(arraylistentry, "On X axis:TimeStamp \n On y axis:RifilTime");
                }
                if (channelname.equals("InjectionTime")) {
                    dataset = new LineDataSet(arraylistentry, "On X axis:TimeStamp \n On y axis:InjectionTime");
                }
                if (channelname.equals("CycleTime")) {
                    dataset = new LineDataSet(arraylistentry, "On X axis:TimeStamp \n On y axis:CycleTime");
                }
                if (channelname.equals("RejectionCode")) {
                    dataset = new LineDataSet(arraylistentry, "On X axis:TimeStamp \n On y axis:RejectionCode");
                }
                if (channelname.equals("DownTime")) {
                    dataset = new LineDataSet(arraylistentry, "On X axis:TimeStamp \n On y axis:DownTime");
                }
                data = new LineData(arraylisttime, dataset);
                dataset.setColors(ColorTemplate.COLORFUL_COLORS);
                dataset.setDrawCubic(true);
                dataset.setDrawFilled(true);
                linechart.setData(data);
                linechart.animateY(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearData(ArrayList<Float> arrayListgraphdata, ArrayList<String> arrayListtime, ArrayList<Entry> arrayListentry) {
        if (arrayListgraphdata !=null) {

            try {
                for (int i = 0; i < arrayListgraphdata.size(); i++) {
                    arrayListentry.clear();
                    arrayListgraphdata.clear();
                    arrayListtime.clear();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    public static void clearAdapter(ArrayList<CodeReason> arrayListcodereason) {
        if (arrayListcodereason != null) {
            try {

                for (int i = 0; i < arrayListcodereason.size(); i++) {
                    arrayListcodereason.clear();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}