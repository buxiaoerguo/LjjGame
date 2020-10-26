package com.ljj.ljjgame.scanIp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljj.ljjgame.R;
import com.ljj.ljjgame.util.LogUtil;

public class ScanIpActivity extends Activity {

    Button button;
    int times = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_ip);
        ScanDeviceUtile s = new ScanDeviceUtile();
//        IpScanner is = new IpScanner();
//        is.startScan();
//     String allIp=    IPAddressUtils.getLocalIpAddress();
//     LogUtil.e("allIp: " + allIp);

        button = findViewById(R.id.button);
        s.scan(times);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                times++;
//                s.getHostName();
                s.scan(times);
            }
        });
    }
}