package com.ljj.ljjgame.start;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;


import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class WaveView extends View {
    private Paint paint;
    private Path path;
    private Paint paint1;
    private Path path1;
    private int waveLength = 800;
    private int waveLength2 = 1000;
    private int dx;
    private int dy;
    private int dx2;
    private int screenHeight;

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST || heightMode == MeasureSpec.EXACTLY) {
            screenHeight = heightSize;
        }
        setMeasuredDimension(widthSize, screenHeight);
    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        path = new Path();
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setARGB(123, 152, 251, 152);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        path1 = new Path();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path1.reset();
        int halfWaveLength2 = waveLength2 / 2;
        int quarterWaveLength = halfWaveLength2 / 2;
        path1.moveTo(-(waveLength2 + quarterWaveLength + dx2), getHeight() - dy);
        for (int i = -waveLength2; i <= getHeight() + waveLength2; i += waveLength2) {
            path1.rQuadTo(quarterWaveLength, -110, halfWaveLength2, 0);
            path1.rQuadTo(quarterWaveLength, 110, halfWaveLength2, 0);
        }
        path1.lineTo(getWidth(), getHeight());
        path1.lineTo(0, getHeight());
        path1.close();
        path.moveTo(-waveLength + dx, getHeight() - dy);
        /**
         * 使用for循环画出几个波长
         */
        int halfWaveLength = waveLength / 2;
        for (int i = -waveLength; i <= getWidth() + waveLength; i += waveLength) {
            path.rQuadTo(halfWaveLength / 2, -80, halfWaveLength, 0);
            path.rQuadTo(halfWaveLength / 2, 80, halfWaveLength, 0);
        }

        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
        canvas.drawPath(path1, paint1);
        canvas.drawPath(path, paint);
    }

    /**
     * 让波纹动起来，利用调用在path.moveTo的时候，将起始点向右移动即可实现移动，
     * 而且只要我们移动一个波长的长度，波纹就会重合，就可以实现无限循环了。
     */
    public void moveWave() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator animator = ValueAnimator.ofInt(0, waveLength);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        ValueAnimator animatorDx = ValueAnimator.ofInt(0, waveLength2);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1500);
        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx2 = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        ValueAnimator animatorDy = ValueAnimator.ofInt(0, 1300);
        animatorDy.setInterpolator(new LinearInterpolator());
        animatorDy.setRepeatCount(ValueAnimator.INFINITE);
        animatorDy.setDuration(4000);
//        animatorDy.setRepeatMode(ValueAnimator.REVERSE);
        animatorDy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dy = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        animatorSet.playTogether(animator, animatorDy, animatorDx);
        animatorSet.start();
    }

}