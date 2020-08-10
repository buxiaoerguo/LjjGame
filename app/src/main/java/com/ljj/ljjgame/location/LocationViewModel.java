package com.ljj.ljjgame.location;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ljj.ljjgame.databinding.ActivityLocationBinding;
import com.ljj.ljjgame.util.BaseUtil;
import com.ljj.ljjgame.util.LogUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class LocationViewModel {
    private ActivityLocationBinding binding;
    private LocationActivity locationActivity;
    public LocationViewModel(Application application, ActivityLocationBinding binding,LocationActivity locationActivity){
        this.binding = binding;
        this.locationActivity = locationActivity;
        getLocation();

    }

    private void getLocation()
    {
        //获取系统的LocationManager对象

        try
        {

            final LocationManager mLocationManager =
                    (LocationManager)locationActivity.getSystemService(Context.LOCATION_SERVICE);
//            List<String> providers = mLocationManager.getProviders(true);
//            Location mLocation = null;
//            for (String provider : providers) {
//                Location l = mLocationManager.getLastKnownLocation(provider);
//                if (l == null) {
//                    continue;
//                }
//                if (mLocation == null || l.getAccuracy() < mLocation.getAccuracy()) {
//                    // Found best last known location: %s", l);
//                    mLocation = l;
//                }
//            }
//           Location mLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            // 判断GPS是否正常启动
            if (!mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Toast.makeText(locationActivity, "请开启GPS导航...", Toast.LENGTH_SHORT).show();
                // 返回开启GPS导航设置界面
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                locationActivity.startActivityForResult(intent, 0);
                return;
            }

            // 为获取地理位置信息时设置查询条件
            String bestProvider = mLocationManager.getBestProvider(getCriteria(), true);
                        List<String> providers = mLocationManager.getProviders(true);
            Location mLocation = null;
            for (String provider : providers) {
//                Location mLocation = mLocationManager.getLastKnownLocation(bestProvider);
                Location l = mLocationManager.getLastKnownLocation(provider);
                if (l == null) {
                    continue;
                }
                if (mLocation == null || l.getAccuracy() < mLocation.getAccuracy()) {
                    // Found best last known location: %s", l);
                    mLocation = l;
                }
            }

//            updateView(location);

            LogUtil.e("provider");
            updateLocation(mLocation);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, new LocationListener() {
                @Override
                public void onLocationChanged(Location location)
                {
                    LogUtil.e("onLocationChanged");
                    updateLocation(location);
                }
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras)
                {
                    switch (status) {
                        // GPS状态为可见时
                        case LocationProvider.AVAILABLE:
                           LogUtil.e( "当前GPS状态为可见状态");
                            break;
                        // GPS状态为服务区外时
                        case LocationProvider.OUT_OF_SERVICE:
                            LogUtil.e(  "当前GPS状态为服务区外状态");
                            break;
                        // GPS状态为暂停服务时
                        case LocationProvider.TEMPORARILY_UNAVAILABLE:
                            LogUtil.e( "当前GPS状态为暂停服务状态");
                            break;

                        default:
                            break;
                    }
                }
                @Override
                public void onProviderEnabled(String provider)
                {
                    try
                    {
                        LogUtil.e("onProviderEnabled");
                        updateLocation(mLocationManager.getLastKnownLocation(provider));
                    }
                    catch (SecurityException e)
                    {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onProviderDisabled(String provider)
                {

                }
            });
        }
        catch (SecurityException e)
        {
            e.printStackTrace();
        }
    }

    private Criteria getCriteria() {
        Criteria criteria = new Criteria();
        // 设置定位精确度 Criteria.ACCURACY_COARSE比较粗略，Criteria.ACCURACY_FINE则比较精细
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        // 设置是否要求速度
        criteria.setSpeedRequired(false);
        // 设置是否允许运营商收费
        criteria.setCostAllowed(false);
        // 设置是否需要方位信息
        criteria.setBearingRequired(false);
        // 设置是否需要海拔信息
        criteria.setAltitudeRequired(false);
        // 设置对电源的需求
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        return criteria;
    }
    private void updateLocation(Location location)
    {
        LogUtil.e("updateLocation");
        LogUtil.e("-----" + location);
        LogUtil.e("---1---" + location.getLongitude());

        LogUtil.e("---1---" + location.getLatitude());

        LogUtil.e("getTime:" + location.getTime());
        LogUtil.e("getGpsLoaalTime:" + getGpsLoaalTime(location.getTime()));
        if (location != null)
        {
            StringBuffer sb = new StringBuffer();
            sb.append("位置信息：\n");
            sb.append("经度： ");
            sb.append(location.getLongitude());
            sb.append("\n纬度： ");
            sb.append(location.getLatitude());
            sb.append("\n高度： ");
            sb.append(location.getAltitude());
            sb.append("\n速度： ");
            sb.append(location.getSpeed());
            sb.append("\n方向： ");
            sb.append(location.getBearing());
            sb.append("\n时间： ");
            sb.append( getGpsLoaalTime(location.getTime()));
            sb.append("\n现在时间： ");

            sb.append(BaseUtil.getInstance().Local2UTC());
            binding.text.setText(sb.toString());
        }
    }
    private static String getGpsLoaalTime(long gpsTime){
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(gpsTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String datestring = df.format(calendar.getTime());

        return datestring;
    }
    public void showLocation(View view){

    }
}
