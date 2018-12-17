package com.bwie.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.bwie.recyclerview.R;
import com.bwie.recyclerview.bean.BeautyBean;

import java.util.ArrayList;
import java.util.Random;


public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.ViewHolder> {
    private ArrayList<BeautyBean> mList;
    private Context mContext;

    public BeautyAdapter(ArrayList<BeautyBean> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //如果用到瀑布流 因为需要改里面高度，所以要把ViewGroup放进去 所以就用LayoutInflater就好
//        View view = View.inflate(mContext, R.layout.beauty_item, viewGroup);
        View view = LayoutInflater.from(mContext).inflate(R.layout.beauty_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BeautyBean bean = mList.get(i);
        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
        Random random = new Random();
        int height = random.nextInt(300) + 300;
        params.height = height;
        viewHolder.itemView.setLayoutParams(params);
        viewHolder.mImage.setImageResource(bean.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.Beauty_Image);
        }
    }
}
