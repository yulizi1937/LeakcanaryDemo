package com.dream.leakcanarydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dream.leakcanarydemo.activity.AutomaticLeakActivity;
import com.dream.leakcanarydemo.activity.ManualLeakActivity;

public class MainActivity extends AppCompatActivity {

    private ListView navigationLv;
    private String[] str_name = new String[]{"自动监听Activity", "手动监听对象"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    
    private void initView() {
        /**初始化导航列表*/
        navigationLv = (ListView) findViewById(R.id.leakcanary_main_navigation_lv);
        navigationLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str_name));
        navigationLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0://自动监听Activity
                        intent = new Intent(MainActivity.this, AutomaticLeakActivity.class);
                        startActivity(intent);
                        break;
                    case 1://手动监听对象
                        intent = new Intent(MainActivity.this, ManualLeakActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
