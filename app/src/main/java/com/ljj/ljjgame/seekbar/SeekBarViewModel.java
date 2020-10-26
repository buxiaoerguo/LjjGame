package com.ljj.ljjgame.seekbar;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.SeekBar;

import com.ljj.ljjgame.databinding.ActivitySeekBarBinding;

public class SeekBarViewModel {
    public ActivitySeekBarBinding binding;
    public Context mContext;
    public SeekBarViewModel(Application application, Activity mContext, ActivitySeekBarBinding binding) {
        this.mContext = mContext;
        this.binding = binding;
        initClick();
    }

    private void initClick() {
//        binding.start.setMax();
//        binding.csb1.setProgress();
//        binding.csb1.();
//        binding.start.getProgress()

//        binding.csb1.set(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
//
//            }
//        });
//        binding.csb.
//        binding.start.requestD
        binding.start.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                binding.cpb.setProgress((float)i/100);
                binding.cpb1.setProgress((float)i/100);
                binding.csb.setProgress((float)i/100);
                binding.csb1.setProgress((float)i/100);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void startSeekBar(View view){

    }
}
