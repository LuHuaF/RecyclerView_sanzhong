package com.bwie.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Liner_Btn;
    private Button Grid_Btn;
    private Button Stagg_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Liner_Btn = (Button) findViewById(R.id.Liner_Btn);
        Grid_Btn = (Button) findViewById(R.id.Grid_Btn);
        Stagg_Btn = (Button) findViewById(R.id.Stagg_Btn);

        Liner_Btn.setOnClickListener(this);
        Grid_Btn.setOnClickListener(this);
        Stagg_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Liner_Btn:
                startActivity(new Intent(MainActivity.this, LinearDemoActivity.class));
                break;
            case R.id.Grid_Btn:
                startActivity(new Intent(MainActivity.this, MoreItemDemoActivity.class));
                break;
            case R.id.Stagg_Btn:
                startActivity(new Intent(MainActivity.this, StaggDemoActivity.class));
                break;
        }
    }
}
