package com.ljj.ljjgame.service;

import android.app.Application;
import android.content.Intent;
import android.view.View;

public class ServiceViewModel {
    private ServiceActivity serviceActivity;
    public ServiceViewModel(Application application,ServiceActivity serviceActivity) {
        this.serviceActivity= serviceActivity;

    }
    public void startServices(View view){


        serviceActivity.startService(new Intent(serviceActivity,MyService.class));
    }
    public void stopServices(View view){
        serviceActivity.stopService(new Intent(serviceActivity,MyService.class));

    }
}
