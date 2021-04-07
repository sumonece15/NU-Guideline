package com.sumon.nuguideline.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sumon.nuguideline.R;

/**
 * Created by sumon on 5/11/2018.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    int images[];
    LayoutInflater layoutInflater;


    public SliderAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.slider_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_slider_image);
        imageView.setImageResource(images[position]);

        container.addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
