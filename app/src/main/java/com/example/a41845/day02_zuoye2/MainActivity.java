package com.example.a41845.day02_zuoye2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a41845.day02_zuoye2.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private ArrayList<bean> list;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initQueryAll();
    }

    private void initQueryAll() {
        List<bean> query = DbHelper.getDbHelper().query();
        list.addAll(query);
        myAdapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 0; i <20 ; i++) {
            bean beans = new bean();
            beans.setId(Long.valueOf(i));
            beans.setName("林青霞"+i);

            DbHelper.getDbHelper().insert(beans);
        }
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);

        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRv.setAdapter(myAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));

    }
}
