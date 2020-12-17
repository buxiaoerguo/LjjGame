package com.ljj.ljjgame.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ljj.ljjgame.ratePic.TempActivity;
import com.ljj.ljjgame.barChart.BarChartActivity;
import com.ljj.ljjgame.button.SwitchButtonActivity;
import com.ljj.ljjgame.chart.ChartLineActivity;
import com.ljj.ljjgame.dialog.DialogActivity;
import com.ljj.ljjgame.location.LocationActivity;
import com.ljj.ljjgame.mvp.MvpTestActivity;
import com.ljj.ljjgame.refreshList.RefreshListActivity;
import com.ljj.ljjgame.scanIp.ScanIpActivity;
import com.ljj.ljjgame.seekbar.SeekBarActivity;
import com.ljj.ljjgame.service.ServiceActivity;
import com.ljj.ljjgame.sildeChart.SildeChartActivity;
import com.ljj.ljjgame.snake.SnakeActivity;
import com.ljj.ljjgame.start.StartActivity;
import com.ljj.ljjgame.text.TextViewActivity;
import com.ljj.ljjgame.util.BaseUtil;
import com.ljj.ljjgame.util.LogUtil;

public class MainViewModel {
    public Context mContext;
    public MainViewModel(Application application, Activity mContext){
        this.mContext = mContext;
        BaseUtil.getInstance().getWindowWm(mContext);
        LogUtil.e("width:"+ BaseUtil.getInstance().width);
        LogUtil.e("realWidth:"+ BaseUtil.getInstance().realWidth);
        LogUtil.e("height:"+ BaseUtil.getInstance().height);
        LogUtil.e("realHeight:"+ BaseUtil.getInstance().realHeight);

    }
    public void goToGameOne(View view){
        Intent intent = new Intent(mContext, SnakeActivity.class);
        mContext.startActivity(intent);
    }

    public void gotoView(View view){
        Intent intent = new Intent(mContext, StartActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoService(View view){
        Intent intent = new Intent(mContext, ServiceActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoLocation(View view){
        Intent intent = new Intent(mContext, LocationActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoDialog(View view){
        Intent intent = new Intent(mContext, DialogActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoSwitchButton(View view){
        Intent intent = new Intent(mContext, SwitchButtonActivity.class);
        mContext.startActivity(intent);
    }

    public void gotoSeekBar(View view){
        Intent intent = new Intent(mContext, SeekBarActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoText(View view ){
        Intent intent = new Intent(mContext, TextViewActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoMvp(View view ){
        Intent intent = new Intent(mContext, MvpTestActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoScanIp(View view ){
        Intent intent = new Intent(mContext, ScanIpActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoChartLine(View view){
        Intent intent = new Intent(mContext, ChartLineActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoRefreshList(View view){
        Intent intent = new Intent(mContext, RefreshListActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoSildeChart(View view){
        Intent intent = new Intent(mContext, SildeChartActivity.class);
        mContext.startActivity(intent);

    }
    public void gotoBarChart(View view){
        Intent intent = new Intent(mContext, BarChartActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoTemp(View view){
        Intent intent = new Intent(mContext, TempActivity.class);
        mContext.startActivity(intent);
    }
}
