package com.ljj.ljjgame.main;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ljj.ljjgame.button.SwitchButtonActivity;
import com.ljj.ljjgame.dialog.DialogActivity;
import com.ljj.ljjgame.location.LocationActivity;
import com.ljj.ljjgame.service.ServiceActivity;
import com.ljj.ljjgame.snake.SnakeActivity;
import com.ljj.ljjgame.start.StartActivity;
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
}
