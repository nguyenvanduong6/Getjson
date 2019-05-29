package com.example.getdatajson.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.getdatajson.Model.myModel;
import com.example.getdatajson.R;
import com.example.getdatajson.ShowIMG;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class myAdapter extends PagerAdapter {
    List<myModel> mModelList;
    LayoutInflater mLayoutInflater;
    Context mContext;


    public myAdapter(){

    }
    public myAdapter(List<myModel> mModelList, Context mContext) {
        this.mModelList = mModelList;
        this.mContext = mContext;
    }

    public List<myModel> getmModelList() {
        return mModelList;
    }

    public void setmModelList(List<myModel> mModelList) {
        this.mModelList = mModelList;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View mView, @NonNull Object mO) {
        return mView.equals(mO);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View rowView = inflater.inflate(R.layout.item, container , false);

            //TODO: references_to_widgets from layout_item
            TextView description = (TextView) rowView.findViewById(R.id.description);
            ImageView image_view = (ImageView)rowView.findViewById(R.id.image_view);


        //TODO: Set Data
//            Picasso.get().load(mModelList.get(position).getName()).into(image_view);
            Log.d("URL_IMAGES", mModelList.get(position).getName());

            Glide.with(mContext).load(mModelList.get(position).getName()).into(image_view);
            description.setText(mModelList.get(position).getDescription());

            container.addView(rowView,0);
        return rowView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}
