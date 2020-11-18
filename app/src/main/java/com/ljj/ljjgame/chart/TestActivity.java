package com.ljj.ljjgame.chart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;

import com.ljj.ljjgame.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Constant.point = new Point();
        getWindowManager().getDefaultDisplay().getSize(Constant.point);//获取屏幕分辨率

        MyChartView myView=new MyChartView(this);
        setContentView(myView);
        myView.SetInfo(new String[] { "7-11", "7-12", "7-13", "7-14", "7-15",
                        "7-16", "7-17" }, // X轴刻度
                new String[] { "", "50", "100", "150", "200", "250" }, // Y轴刻度
                new String[] { "15", "23", "10", "36", "45", "40", "12" }, // 数据
                "图标的标题");
    }
}