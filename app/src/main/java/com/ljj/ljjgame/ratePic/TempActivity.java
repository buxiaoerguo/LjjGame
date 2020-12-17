package com.ljj.ljjgame.ratePic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.ljj.ljjgame.R;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        TempControlView tempControl = findViewById(R.id.temp_control);
        // 设置三格代表温度1度
        tempControl.setAngleRate(1);
        tempControl.setTemp(1, 100, 1);
        //设置旋钮是否可旋转
        tempControl.setCanRotate(true);

        tempControl.setOnTempChangeListener(new TempControlView.OnTempChangeListener() {
            @Override
            public void change(int temp) {
                Toast.makeText(TempActivity.this, temp + "°", Toast.LENGTH_SHORT).show();
            }
        });

        tempControl.setOnClickListener(new TempControlView.OnClickListener() {
            @Override
            public void onClick(int temp) {
                Toast.makeText(TempActivity.this, temp + "°", Toast.LENGTH_SHORT).show();
            }
        });
    }

}