package com.amled.rlard008.amled.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.amled.rlard008.amled.R;
import com.amled.rlard008.amled.pojo.Drawerdata;

import java.util.ArrayList;


/**
 * Created by sudhakar on 4/26/17.
 */

public class DrawerListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Drawerdata> arrayListdata;


    public DrawerListAdapter(Context context, ArrayList<Drawerdata> arrayListdata) {
        this.context = context;
        this.arrayListdata = arrayListdata;
    }

    @Override
    public int getCount() {
        return arrayListdata.size();
    }

    @Override
    public Drawerdata getItem(int position) {
        return arrayListdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item_layout, null);
        TextView imageView=(TextView) convertView.findViewById(R.id.imageview);
        TextView textView=(TextView)convertView.findViewById(R.id.textdata);

        Drawerdata drawerdata=arrayListdata.get(position);
        Log.e("drawerdata",""+drawerdata);
        textView.setText(""+drawerdata.getItemname());
        imageView.setCompoundDrawablesWithIntrinsicBounds(drawerdata.getImage(),0,0,0);
        return convertView;
    }
}