package com.ljj.ljjgame.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * @author ljj
 * @date 2020/8/11 16:55
 * @description 获取屏幕宽高工具，用于获取屏幕的宽高，以及真实宽高
 * 可以选择使用3种方法
 * 1.getWindowManager
 * 2.getResources
 * 3.getSystemService
 */

public class WindowUtil {
    public int width;
    public int height;
    public int realWidth;
    public int realHeight;

    public void getWindowWm(Activity activity) {
        WindowManager wm = activity.getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.heightPixels;

        //获取真实的屏幕宽高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        realWidth = displayMetrics.widthPixels;
        realHeight = displayMetrics.heightPixels;
    }

    public void getWindowRes(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        float density = dm.density;
    }

    public void getWindowSs(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //获取真实的屏幕亮度
        DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getRealMetrics(displayMetrics);
        int realWidth = displayMetrics.widthPixels;
        int realHeight = displayMetrics.heightPixels;
    }
}
