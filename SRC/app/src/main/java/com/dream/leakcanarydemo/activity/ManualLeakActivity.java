package com.dream.leakcanarydemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dream.leakcanarydemo.MyApplication;
import com.dream.leakcanarydemo.R;

/**
 * Created by hongchen.dong on 2016/3/15.
 */
public class ManualLeakActivity extends Activity {
    
    Button mLeakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manualleak);

        initView();
    }

    private void initView() {
        mLeakBtn = (Button) findViewById(R.id.leakcanary_manualleak_leak_btn);
        mLeakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //监控Button是否回收，显然没有回收
                MyApplication.refWatcher.watch(mLeakBtn);
            }
        });
    }
}
