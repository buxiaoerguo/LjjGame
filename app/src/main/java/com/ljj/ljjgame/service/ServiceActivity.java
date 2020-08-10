package com.ljj.ljjgame.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityServiceBinding;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ActivityServiceBinding binding =
        DataBindingUtil.setContentView(this,R.layout.activity_service);
        ServiceViewModel serviceViewModel = new ServiceViewModel(getApplication(),this);
        binding.setServiceViewModel(serviceViewModel);
    }
}
