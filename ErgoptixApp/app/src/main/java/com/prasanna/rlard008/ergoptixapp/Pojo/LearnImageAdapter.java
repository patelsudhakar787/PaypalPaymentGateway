package com.prasanna.rlard008.ergoptixapp.Pojo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.prasanna.rlard008.ergoptixapp.R;


/**
 * Created by rlard008 on 28-04-2017.
 */

public class LearnImageAdapter extends PagerAdapter {
    Context mContext;

    public LearnImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d, R.drawable.e, R.drawable.f,R.drawable.g, R.drawable.h,
            R.drawable.i,R.drawable.j, R.drawable.k, R.drawable.l,R.drawable.m, R.drawable.n, R.drawable.o,R.drawable.p,
            R.drawable.q, R.drawable.r, R.drawable.s, R.drawable.t, R.drawable.u,R.drawable.v, R.drawable.w, R.drawable.x,
            R.drawable.y, R.drawable.z, R.drawable.aa,R.drawable.bb, R.drawable.cc, R.drawable.dd,
            R.drawable.ee, R.drawable.ff, R.drawable.gg,R.drawable.hh, R.drawable.ii, R.drawable.jj

    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v ==  obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        container.addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((ImageView) obj);
    }
}
