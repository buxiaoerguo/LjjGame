package com.ljj.ljjgame.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityLocationBinding;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_location);
        ActivityLocationBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_location);
                              LocationViewModel viewModel = new LocationViewModel(getApplication(),binding,this);
        binding.setViewModel(viewModel);
    }
}
