package com.bwie.recyclerview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.recyclerview.adapter.MyAdapter;
import com.bwie.recyclerview.view.DividerGridItemDecoration;

import java.util.ArrayList;

/**
 * 文件描述：
 * 作者：鲁华丰
 * 创建时间：2018/12/12
 */
public class LinearDemoActivity extends AppCompatActivity {
    private RecyclerView mRecy;
    private ArrayList<String> mList = new ArrayList<>();
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_demo);
        initViews();
        mAdapter = new MyAdapter(mList);
        mRecy.setAdapter(mAdapter);
        initData();
        mAdapter.setOnClickListener(new MyAdapter.ItemClick() {
            @Override
            public void setOnItemClick(View view, int position) {
                Toast.makeText(LinearDemoActivity.this, mList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add("luhuafeng" + i);
        }
        mAdapter.notifyDataSetChanged();
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initViews() {
        mRecy = findViewById(R.id.Recy);
        //得让这个RecyclerView显示样式
        GridLayoutManager grid = new GridLayoutManager(this, 3);
       LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        /*DividerGridItemDecoration divider = new DividerGridItemDecoration(this);
        mRecy.addItemDecoration(divider);*/
       DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
       DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);

       /*dividerItemDecoration.setDrawable(getDrawable(R.drawable.recycler_divider));*/
        mRecy.addItemDecoration(dividerItemDecoration);
        mRecy.addItemDecoration(dividerItemDecoration1);
        mRecy.setLayoutManager(grid);
    }
}
