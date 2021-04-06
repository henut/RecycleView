package com.example.a129;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a129.adapter.BasicAdapter;

import java.util.ArrayList;
import java.util.List;


public class BasicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_list);

        //setContentView(R.layout.activity_main);
        //初始化Recycle
        RecyclerView  rvBasicList = findViewById(R.id.rv_basic_test);
        //此设置可提高性能
        rvBasicList.setHasFixedSize(true);
        //设置布局管理器，默认是垂直方向
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvBasicList .setLayoutManager(linearLayoutManager);

        //初始化列表数据,设置适配器
        List<String> srcList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            srcList.add("第"+(i-1)+"行");
        }

        BasicAdapter basicAdapter = new  BasicAdapter(this,srcList);
        rvBasicList.setAdapter(basicAdapter);
    }
}