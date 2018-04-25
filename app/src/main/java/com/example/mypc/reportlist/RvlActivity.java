package com.example.mypc.reportlist;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RvlActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;

    private MyAdapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView=findViewById(R.id.report_rlv);

        //设置布局管理器
//        mLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        //设置适配器(传入数据，可以不传值？)
//        mAdapter=new MyAdapter(getData());
//        mRecyclerView.setAdapter(mAdapter);
        initData();
        initView();


        mAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RvlActivity.this,"onClick"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(RvlActivity.this,"onLongClick"+position,Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void initData() {
        Log.v("gg","r2");
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //mAdapter = new OtherAdapter(getData());
        mAdapter=new MyAdapter(myGetData());
    }

    private void initView() {

        mRecyclerView = findViewById(R.id.report_rlv);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        //分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);


    }

    private ArrayList<Map<String,String>> myGetData() {
        Log.v("gg","r4");
        ArrayList<Map<String,String>> data = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Map<String,String> map=new HashMap<>();
            if (i % 3 == 0) {
                map.put("image",R.mipmap.warning+"");
                map.put("info","警告");
                map.put("pro",R.mipmap.doing_light+"");
            }
            if (i % 3 == 1) {
                map.put("image",R.mipmap.shigu+"");
                map.put("info","事故");
                map.put("pro",R.mipmap.doing_light+"");
            }
            if (i % 3 == 2) {
                map.put("image",R.mipmap.yongdu+"");
                map.put("info","拥堵");
                map.put("pro",R.mipmap.done_light+"");
            }


            map.put("time","2018-02-10 13:13");


            data.add(map);
        }

        return data;
    }
    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for(int i = 0; i < 20; i++) {
            data.add(i + temp);
        }

        return data;
    }


}


