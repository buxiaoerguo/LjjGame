package com.ljj.ljjgame.button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityServiceBinding;
import com.ljj.ljjgame.databinding.ActivitySwitchButtonBinding;
import com.ljj.ljjgame.dialog.DialogViewModel;

public class SwitchButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_switch_button);
        ActivitySwitchButtonBinding buttonBinding = DataBindingUtil.setContentView(this,R.layout.activity_switch_button);
        SwitchButtonViewModel viewModel = new SwitchButtonViewModel(getApplication(),this,buttonBinding);

        buttonBinding.setViewModel(viewModel);
    }
}
