package com.bwie.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwie.recyclerview.adapter.BeautyAdapter;
import com.bwie.recyclerview.bean.BeautyBean;

import java.util.ArrayList;


public class StaggDemoActivity extends AppCompatActivity {
    private RecyclerView mRecy;
        private ArrayList<BeautyBean> mList = new ArrayList<>();
    private int[] mImages = {R.mipmap.meinv, R.mipmap.xingan, R.mipmap.meizi};
    private BeautyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagg_demo);
        initViews();
        initData();
        mAdapter = new BeautyAdapter(mList, this);
        mRecy.setAdapter(mAdapter);
    }

    private void initViews() {
        mRecy = findViewById(R.id.Stagg_Recy);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecy.setLayoutManager(staggeredGridLayoutManager);
        //这个地方是默认加上的
        mRecy.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add(new BeautyBean("luhuafeng" + i, mImages[i % mImages.length]));
        }
    }

}
