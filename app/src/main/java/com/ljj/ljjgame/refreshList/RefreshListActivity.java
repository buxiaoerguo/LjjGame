package com.ljj.ljjgame.refreshList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class RefreshListActivity extends Activity {
    private SwipeRefreshLayout swiperereshlayout ;
    private ListView listview ;
    private ArrayAdapter<String> adapter;
    private List<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_list);
        initView();
    }


    private void initView (){

        swiperereshlayout = (SwipeRefreshLayout) findViewById(R.id.swiperereshlayout);
        listview = (ListView) findViewById(R.id.listview);
        data = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            data.add("当前的item为 " + i);
        }
        adapter = new ArrayAdapter<String>(RefreshListActivity.this, android.R.layout.simple_list_item_1, data);
        listview.setAdapter(adapter);


        swiperereshlayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light, android.R.color.holo_orange_light);
        //给swipeRefreshLayout绑定刷新监听
        swiperereshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //设置2秒的时间来执行以下事件
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.add(0, "刷新后新增的item");
                        adapter.notifyDataSetChanged();
                        swiperereshlayout.setRefreshing(false);
                    }
                }, 2000);
            }
        });


    }


}