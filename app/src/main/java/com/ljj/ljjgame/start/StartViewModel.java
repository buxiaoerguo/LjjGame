package com.ljj.ljjgame.start;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import com.ljj.ljjgame.databinding.ActivityStartBinding;
import com.ljj.ljjgame.util.AnimationUtil;

import androidx.databinding.BaseObservable;

public class StartViewModel extends BaseObservable {
    ActivityStartBinding binding;
    private StartActivity startActivity;

    public StartViewModel(Application application, StartActivity startActivity, ActivityStartBinding binding) {
        this.binding = binding;
        this.startActivity= startActivity;
    }

    public void back(View view){
        startActivity.finish();
    }
    public void alpha(View view) {
        Animation animation = AnimationUtil.getInstance().alphaAnimation();
        binding.ivAnim.setVisibility(View.VISIBLE);
        binding.ivAnim.startAnimation(animation);
    }

    public void rotate(View view) {
        Animation animation = AnimationUtil.getInstance().rotateAnimation();
        binding.ivAnim.setVisibility(View.VISIBLE);
        binding.ivAnim.startAnimation(animation);
    }

    public void leftRight(View view) {

        Animation animation = AnimationUtil.getInstance().translateAnimation(-200f, 200f);
        binding.ivAnim.setVisibility(View.VISIBLE);
        binding.ivAnim.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation = AnimationUtil.getInstance().translateAnimation(200f, -150f);
                binding.ivAnim.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animation = AnimationUtil.getInstance().translateAnimation(-150f, 100f);
                        binding.ivAnim.startAnimation(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void centerScale(View view) {
        Animation animation = AnimationUtil.getInstance().scaleAnimation();
        binding.ivAnim.setVisibility(View.VISIBLE);
        binding.ivAnim.startAnimation(animation);
    }

    public void all(View view) {
        Animation animation = AnimationUtil.getInstance().scaleAnimation();
        binding.ivAnim.setVisibility(View.VISIBLE);
        binding.ivAnim.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation = AnimationUtil.getInstance().alphaAnimation();
                binding.ivAnim.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        animation = AnimationUtil.getInstance().translateAnimation(-200f, 200f);
                        binding.ivAnim.startAnimation(animation);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                animation = AnimationUtil.getInstance().rotateAnimation();
                                binding.ivAnim.setVisibility(View.VISIBLE);
                                binding.ivAnim.startAnimation(animation);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
