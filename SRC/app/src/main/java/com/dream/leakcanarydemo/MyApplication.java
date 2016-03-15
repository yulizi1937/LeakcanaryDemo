package com.dream.leakcanarydemo;

import android.app.Application;

import com.dream.leakcanarydemo.service.LeakUploadService;
import com.squareup.leakcanary.AndroidExcludedRefs;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by hongchen.dong on 2016/3/15.
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        //初始化leak监听对象
        MyApplication.refWatcher = installLeakCanary();
    }


    //leak监听对象
    public static RefWatcher refWatcher;

    protected RefWatcher installLeakCanary() {
//        //没有leak回调
//        return LeakCanary.install(this);

        //指定leak回调的 Service
        return LeakCanary.install(this, LeakUploadService.class, AndroidExcludedRefs.createAppDefaults().build());
    }
}
