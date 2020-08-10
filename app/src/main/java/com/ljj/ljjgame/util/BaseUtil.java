package com.ljj.ljjgame.util;


import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 *@author ljj
 *
 *@date 2020/5/18 10:45
 *
 * @description 基础工具类
 */
public class BaseUtil {
    public static BaseUtil baseUtil;

    public static BaseUtil getInstance() {
        if (baseUtil == null) {
            synchronized (BaseUtil.class) {
                if (baseUtil == null) {
                    baseUtil = new BaseUtil();
                }
            }
        }
        return baseUtil;
    }
    public String Local2UTC() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("gmt"));
        return sdf.format(new Date());
    }
    public String getStamp() {
        String test = Local2UTC();
        String utcTime = "";
        try {
//            utcTime = dateToStamp(test).substring(0, 10);
            utcTime = dateToStamp(test);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utcTime;
    }
    public  String getLocalTime(long gpsTime){
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(gpsTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String datestring = df.format(calendar.getTime());

        return datestring;
    }
    private String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

}
