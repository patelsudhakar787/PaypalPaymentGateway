package com.rlard.rlard008.stbi.Pojo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rlard.rlard008.stbi.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by rlard008 on 29-07-2017.
 */

public class DrawerOptionAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DrawerData> arrayListdata;

    int flag=0;

    public DrawerOptionAdapter(Context context, ArrayList<DrawerData> arrayListdata) {
        this.context = context;
        this.arrayListdata = arrayListdata;
    }


    @Override
    public int getCount() {
        return arrayListdata.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListdata.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.drawer_option_item_layout, null);

        //TextView imageView=(TextView) view.findViewById(R.id.imageview);
        TextView textView=(TextView)view.findViewById(R.id.textViewOption);

        DrawerData drawerdata=arrayListdata.get(i);
        Log.e("drawerdata",""+drawerdata);
        if (i==0) {
            textView.setBackgroundColor(Color.parseColor("#33b5e5"));
           // flag++;
        }
        if (i==1) {
            textView.setBackgroundColor(Color.parseColor("#f2b009"));
           // flag++;
        }
        if (i>1) {
            textView.setBackgroundColor(Color.parseColor("#33b5e5"));
            //flag=0;
        }
        textView.setText(""+drawerdata.getItemname());
        //imageView.setCompoundDrawablesWithIntrinsicBounds(drawerdata.getImage(),0,0,0);
        return view;
    }
}
