package com.ljj.ljjgame.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(getApplication(),MainActivity.this);
        binding.setViewModel(mainViewModel);
    }
}
