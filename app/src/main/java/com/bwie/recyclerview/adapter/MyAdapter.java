package com.bwie.recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.recyclerview.R;

import java.util.ArrayList;

/**
 * 文件描述：
 * 作者：鲁华丰
 * 创建时间：2018/12/12
 */
public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    private ArrayList<String> mList;

    public MyAdapter(ArrayList<String> mList) {
        this.mList = mList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.recy_item, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mName.setText(mList.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.recy_name);
        }
    }
    public interface ItemClick {
        void setOnItemClick(View view, int position);
    }
    private ItemClick mItemClick;

    public void setOnClickListener(ItemClick itemClick) {
        this.mItemClick = itemClick;
    }
    @Override
    public void onClick(View v) {
        if (mItemClick != null) {
            mItemClick.setOnItemClick(v, (int) v.getTag());
        }
    }
}
