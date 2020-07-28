package com.ljj.ljjgame.main;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ljj.ljjgame.snake.SnakeActivity;
import com.ljj.ljjgame.start.StartActivity;

public class MainViewModel {
    public Context mContext;
    public MainViewModel(Application application, Context mContext){
        this.mContext = mContext;
    }
    public void goToGameOne(View view){
        Intent intent = new Intent(mContext, SnakeActivity.class);
        mContext.startActivity(intent);
    }
    public void gotoView(View view){
        Intent intent = new Intent(mContext, StartActivity.class);
        mContext.startActivity(intent);
    }
}
