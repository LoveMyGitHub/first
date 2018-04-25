package com.example.mypc.reportlist;


import android.support.v7.widget.RecyclerView;

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
    public interface  onItemClickListener{
        void onItemClick(View view ,int position);
        void  onItemLongClick(View view,int position);
    }
    private onItemClickListener onItemClickListener;
    public void setOnItemClickListener(onItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }
    private ArrayList<Map<String,String>> mData;

    public MyAdapter(ArrayList<Map<String,String>> data) {
                this.mData = data;
    }

    public void updateData(ArrayList<Map<String,String>> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // 绑定数据
        holder.mIv.setImageResource(Integer.parseInt(mData.get(position).get("image")));
        holder.mTextViewInfo.setText(mData.get(position).get("info"));

        holder.mTextViewTime.setText(mData.get(position).get("time"));
       // holder.mTextViewPro.setText(mData.get(position).get("pro"));
        holder.mTextViewPro.setImageResource(Integer.parseInt(mData.get(position).get("pro")));

        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int layoutPos=holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView,layoutPos);

                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPos=holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView,layoutPos);
                    return false;
                }
            });
        }
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
       //TextView mTextViewPro;
        ImageView mTextViewPro;

        public ViewHolder(View itemView) {
            super(itemView);

            mIv = itemView.findViewById(R.id.mImageViewImaget);
            mTextViewInfo=itemView.findViewById(R.id.mTextViewInfot);
            mTextViewLoc=itemView.findViewById(R.id.mTextViewLoct);
            mTextViewTime=itemView.findViewById(R.id.mTextViewTimet);
            mTextViewPro=itemView.findViewById(R.id.imageView2t);

//            mIv = itemView.findViewById(R.id.mImageViewImage);
//            mTextViewInfo=itemView.findViewById(R.id.mTextViewInfo);
//            mTextViewLoc=itemView.findViewById(R.id.mTextViewLoc);
//            mTextViewTime=itemView.findViewById(R.id.mTextViewTime);
//            mTextViewPro=itemView.findViewById(R.id.mTextViewPro);


        }
    }
}


