package com.ljj.ljjgame.button;

import android.app.Application;
import android.view.View;

import com.ljj.ljjgame.databinding.ActivitySwitchButtonBinding;
import com.ljj.ljjgame.util.LogUtil;

public class SwitchButtonViewModel {
    SwitchButtonActivity switchButtonActivity;
    ActivitySwitchButtonBinding binding;
    public SwitchButtonViewModel(Application application, SwitchButtonActivity switchButtonActivity, ActivitySwitchButtonBinding binding){
        this.switchButtonActivity = switchButtonActivity;
        this.binding = binding;
        initView();
        initClick();
    }

    private void initClick() {
        switchClick();
    }

    private void initView() {
        binding.switchButton.setChecked(true);
        binding.switchButton.isChecked();
        binding.switchButton.toggle();     //switch state
        binding.switchButton.toggle(true);//switch without animation
        binding.switchButton.setShadowEffect(true);//disable shadow effect
        binding.switchButton.setEnabled(true);//disable button
        binding.switchButton.setEnableEffect(true);//disable the switch animation
        binding.switchButton.setShowIndicator(false);
    }

    public void switchClick( ){
        binding.switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                LogUtil.e("isChecked:" + isChecked);
            }
        });
    }
}
