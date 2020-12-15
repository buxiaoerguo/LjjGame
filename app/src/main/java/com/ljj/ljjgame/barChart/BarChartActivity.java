package com.ljj.ljjgame.barChart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ljj.ljjgame.R;

import java.util.ArrayList;
import java.util.List;

public class BarChartActivity extends AppCompatActivity {
    private BarChartView columnChartView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        Screen.initScreen(this);
        initView();
    }
    private void initView(){
        columnChartView = (BarChartView)findViewById(R.id.columnChartView);

        List<Double> data = new ArrayList<Double>();
        List<String> monthList = new ArrayList<String>();

        data.add(1000.00);
        data.add(5000.00);
        data.add(1820.00);
        data.add(1130.00);
        data.add(1253.10);
        data.add(2000.00);
        monthList.add("7");
        monthList.add("8");
        monthList.add("9");
        monthList.add("10");
        monthList.add("11");
        monthList.add("12");

        columnChartView.setMonthList(monthList);
        columnChartView.setData(data);
        columnChartView.setOnDraw(true);
        columnChartView.start();
    }


    public void init(View v){
        columnChartView.start();
    }
}