package com.example.mypc.reportlist;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;


/**
 * Created by MyPC on 2018/4/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<Map<String,String>> mData;

    public MyAdapter(ArrayList<Map<String,String>> data) {

        Log.v("gg","m");
                this.mData = data;
    }

    public void updateData(ArrayList<Map<String,String>> data) {
        Log.v("gg","m2");
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.v("gg","m3");
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.new_rv_item, parent, false);
        Log.v("gg", String.valueOf(parent.getContext()));
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // 绑定数据
        holder.mIv.setImageResource(Integer.parseInt(mData.get(position).get("image")));
        holder.mTextViewInfo.setText(mData.get(position).get("info"));

        holder.mTextViewTime.setText(mData.get(position).get("time"));
        holder.mTextViewPro.setText(mData.get(position).get("pro"));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mIv;
        TextView mTextViewInfo;
        TextView mTextViewLoc;
        TextView mTextViewTime;
        TextView mTextViewPro;

        public ViewHolder(View itemView) {
            super(itemView);
            Log.v("gg","m5");
            mIv = itemView.findViewById(R.id.mImageViewImage);
            mTextViewInfo=itemView.findViewById(R.id.mTextViewInfo);
            mTextViewLoc=itemView.findViewById(R.id.mTextViewLoc);
            mTextViewTime=itemView.findViewById(R.id.mTextViewTime);
            mTextViewPro=itemView.findViewById(R.id.mTextViewPro);
        }
    }
}


