package com.ljj.ljjgame.sildeChart;

/**
 * Created by zhanghao on 2018/1/13.
 */

public class SlideYChartPoint {

    public SlideYChartPoint(float x, float y) {

        this.x = x;
        this.y = y;
    }

    private float x;
    private float y;

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public void setY(float y) {
//        if (x <0){
//            x = 0;
//        }
        if (y<0){
            y = 0;
        }
        if (y>100){
            y = 100;
        }
        this.y = y;
    }

    public float getY() {
        return y;
    }
}
