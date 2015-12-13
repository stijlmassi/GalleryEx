package com.example.android.galleryex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by wdc on 13/11/15.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String mUrl;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter(Context c, String url) {
        mContext = c;
        mUrl = url;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            // imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        Glide.with(mContext).load(mUrl).into(imageView);

        // imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

 /*   public View getView(int position, View recycled, ViewGroup container) {
        final ImageView myImageView;
        if (recycled == null) {
            myImageView = (ImageView) inflater.inflate(R.layout.my_image_view, container, false);
        } else {
            myImageView = (ImageView) recycled;
        }

        String url = myUrls.get(position);

        Glide.with(myFragment)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.loading_spinner)
                .crossFade()
                .into(myImageView);

        return myImageView;
    }*/

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5,
            R.drawable.sample_6, R.drawable.sample_7
    };


}