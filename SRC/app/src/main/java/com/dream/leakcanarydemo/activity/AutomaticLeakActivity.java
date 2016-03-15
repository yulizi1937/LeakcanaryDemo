package com.dream.leakcanarydemo.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.dream.leakcanarydemo.R;

/**
 * Created by hongchen.dong on 2016/3/15.
 */
public class AutomaticLeakActivity extends Activity {

    Button mLeakBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automaticleak);

        initView();
    }

    private void initView() {
        mLeakBtn = (Button) findViewById(R.id.leakcanary_automaticleak_leak_btn);
        mLeakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //监控Button是否回收，显然没有回收
                startAsyncTask();
                finish();
            }
        });
    }

    private void startAsyncTask() {

        /*
        * 由于 AsyncTask 在异步执行，会对Activity保持引用。
        *当Activity销毁后依旧会保持引用(直到AsyncTask结束前)，
        * 所以会导致 Activity 实例的泄露。
        * */
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // Do some slow work in background
                SystemClock.sleep(20000);
                return null;
            }
        }.execute();
    }


}
