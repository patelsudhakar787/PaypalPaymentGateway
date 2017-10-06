package com.rlard.tubelighttestingrack.pojo;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

/**
 * Created by sudhakar on 5/16/17.
 */

public class ClearGraphData {


    public static void clearTime(ArrayList<String>arrayList)
    {
        if(!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.clear();
            }
        }
    }

    public static void clearGraphData(ArrayList<Float>arrayList)
    {
        if(!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.clear();
            }
        }
    }


    public static void clearEntry(ArrayList<Entry>arrayList) {

        if(!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.clear();
            }
        }

    }
}
