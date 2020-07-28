package com.ljj.ljjgame.util;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

public class AnimationUtil {
    private static AnimationUtil animationUtil;

    public static AnimationUtil getInstance() {
        if (animationUtil == null) {
            synchronized (AnimationUtil.class) {
                if (animationUtil == null) {
                    animationUtil = new AnimationUtil();
                }
            }
        }
        return animationUtil;
    }

    /**
     * animation.setInterpolator();方法可以使用如下效果
     * LinearInterpolator 	匀速
     * AccelerateInterpolator 	先减速后加速
     * AnticipateInterpolator 	动画开始之前有回弹效果
     * BounceInterpolator 	结束回弹效果
     * CycleInterpolator 	跳一跳效果
     * OvershootInterpolator 	动画结束时向前弹一定距离再回到原来位置
     * AccelerateDecelerateInterpolator 	系统默认的动画效果，先加速后减速
     * AnticipateOvershootInterpolator 	开始之前向前甩，结束的时候向后甩
     * DecelerateInterpolator 	开始加速再减速
     */


    public Animation translateAnimation(float fromX,float toX){
        Animation animation = new TranslateAnimation(fromX, toX, 0f, 0f);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setInterpolator(new LinearInterpolator());
//        animation.setRepeatCount(4);
        return animation;
    }

    public Animation rotateAnimation(){
        Animation animation = new RotateAnimation(0, 360,100,0);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setInterpolator(new AccelerateInterpolator(1));
//        animation.setRepeatCount(5);
        return animation;
    }
    public Animation alphaAnimation() {
        Animation animation = new AlphaAnimation(0, 100);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setInterpolator(new AccelerateInterpolator(1));
        return animation;
    }

    public Animation scaleAnimation() {
        Animation animation = new ScaleAnimation(0f, 1.0f, 0f, 1.0f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f, ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setInterpolator(new OvershootInterpolator(10));
        return animation;
    }
}
