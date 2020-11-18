package com.ljj.ljjgame.chart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.databinding.ActivityChartLineBinding;
import com.ljj.ljjgame.databinding.ActivityMainBinding;
import com.ljj.ljjgame.main.MainActivity;
import com.ljj.ljjgame.main.MainViewModel;

public class ChartLineActivity extends Activity {
    ActivityChartLineBinding binding;
    ChartLineViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_chart_line);
        viewModel = new ChartLineViewModel(getApplication(), ChartLineActivity.this,binding);
        binding.setViewModel(viewModel);
//        initView();
    }

    private void initView() {
        Constant.point = new Point();
        getWindowManager().getDefaultDisplay().getSize(Constant.point);//获取屏幕分辨率

    }
}