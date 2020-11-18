package com.ljj.ljjgame.chart;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;

import com.ljj.ljjgame.databinding.ActivityChartLineBinding;

import java.util.ArrayList;


public class ChartLineViewModel {
    public Context mContext;
    public ActivityChartLineBinding binding;
    public ChartLineViewModel(Application application, Activity mContext, ActivityChartLineBinding binding){
        this.mContext = mContext;
        this.binding = binding;
        initData();
//        initMyChartView();

    }

//    private void initMyChartView() {
////        Constant.point = new Point();
////
////MyChartView        myChartView = new MyChartView(mContext);
//////        setContentView(myView);
////        binding.myChartView =myChartView;
//        binding.myChartView .SetInfo(new String[] { "7-11", "7-12", "7-13", "7-14", "7-15",
//                        "7-16", "7-17" }, // X轴刻度
//                new String[] { "", "50", "100", "150", "200", "250" }, // Y轴刻度
//                new String[] { "15", "23", "10", "36", "45", "40", "12" }, // 数据
//                "图标的标题");
//    }

    private void initData() {
        ArrayList<String> listX = new ArrayList<>();
        ArrayList<Float> listData = new ArrayList<>();

        float[] data = new float[24];
        data[0] = Float.valueOf(1);
        data[1] = Float.valueOf(1);
        data[2] = Float.valueOf(1);
        data[3] = Float.valueOf(1);
        data[4] = Float.valueOf(1);
        data[5] = Float.valueOf(33);
        data[6] = Float.valueOf(23);
        data[7] = Float.valueOf(7);
        for(int i = 0;i<24;i++){
            listData.add(Float.valueOf(i*3));
            listX.add( i + ":00");

        }
//        binding.lineView.setData(listX,listY);
        binding.lineView.setTextX(listX);
        binding.lineView.setBrokenData(data);
        binding.lineView.setTextY(0,100,10,"");

    }

}
