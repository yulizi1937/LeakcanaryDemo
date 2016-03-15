package com.dream.leakcanarydemo.service;

import android.util.Log;
import android.widget.Toast;

import com.squareup.leakcanary.AnalysisResult;
import com.squareup.leakcanary.DisplayLeakService;
import com.squareup.leakcanary.HeapDump;

/**
 * Created by hongchen.dong on 2016/3/15.
 */
public class LeakUploadService extends DisplayLeakService {
    @Override
    protected void afterDefaultHandling(HeapDump heapDump, AnalysisResult result, String leakInfo) {
        super.afterDefaultHandling(heapDump, result, leakInfo);
        if (!result.leakFound || result.excludedLeak) {
            return;
        }

        Log.e("leak", "-----------------------------------------------------------");
        Log.e("leak", leakInfo);
        Log.e("leak", "-----------------------------------------------------------");

    }
}