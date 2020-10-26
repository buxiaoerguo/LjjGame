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
        buttonClick();
        button2Click();
    }

    private void button2Click() {
        binding.buttons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.e("buttons :" + binding.switchButton.isChecked());
                if (binding.switchButton.isChecked()) {
                    binding.switchButton.setChecked(false);
//                    binding.switchButton.setChecked(false,true);
//                    binding.switchButton.set(false);setChecked
                }else {
                    binding.switchButton.setChecked(true);
                }
            }
        });
    }

    private void buttonClick() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.e("switchButton.isChecked() :" + binding.switchButton.isChecked());
                if (binding.switchButton.isChecked()) {
                    binding.switchButton.toggle(false);
//                    binding.switchButton.setChecked(false);
//                    binding.switchButton.set(false);setChecked
                }else {
                    binding.switchButton.toggle(true);
                }
            }
        });
    }

    private void initView() {
//        binding.switchButton.setChecked(true);
//        binding.switchButton.isChecked();
//        binding.switchButton.toggle();     //switch state
//        binding.switchButton.toggle(true);//switch without animation
//        binding.switchButton.setShadowEffect(true);//disable shadow effect
//        binding.switchButton.setEnabled(true);//disable button
//        binding.switchButton.setEnableEffect(true);//disable the switch animation
//        binding.switchButton.setShowIndicator(false);
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
