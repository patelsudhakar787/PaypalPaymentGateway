package com.example.sudhakar.rfdms_app.api;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

/**
 * Created by sudhakar on 5/16/17.
 */

public class ClearGraphData {


    public static void clearTime(ArrayList<String>arrayList)
    {
        for(int i=0;i<arrayList.size();i++){
            arrayList.clear();
        }
    }

    public static void clearGraphData(ArrayList<Float>arrayList)
    {
        for (int i=0;i<arrayList.size();i++)
        {
            arrayList.clear();
        }
    }


    public static void clearEntry(ArrayList<Entry>arrayList) {
        for (int i = 0; i < arrayList.size(); i++)
        {
            arrayList.clear();
        }

    }
}
