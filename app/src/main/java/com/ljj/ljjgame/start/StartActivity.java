package com.ljj.ljjgame.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding binding;
    private StartViewModel startViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        startViewModel = new StartViewModel(getApplication(), this, binding);
        binding.setStartViewModel(startViewModel);
    }
}
