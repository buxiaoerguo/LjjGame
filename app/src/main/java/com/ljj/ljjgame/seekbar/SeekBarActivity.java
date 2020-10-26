package com.ljj.ljjgame.seekbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityMainBinding;
import com.ljj.ljjgame.databinding.ActivitySeekBarBinding;
import com.ljj.ljjgame.main.MainActivity;
import com.ljj.ljjgame.main.MainViewModel;

public class SeekBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_seek_bar);
        ActivitySeekBarBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_seek_bar);
        SeekBarViewModel seekBarViewModel = new SeekBarViewModel(getApplication(), this,binding);
        binding.setViewModel(seekBarViewModel);
    }
}
