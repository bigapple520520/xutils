/* 
 * @(#)FriendlyTimeUtils.java    Created on 2013-6-21
 * Copyright (c) 2013 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.xuan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 友好时间显示工具类
 * 
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2013-6-21 下午3:04:51 $
 */
public abstract class FriendlyTimeUtils {

    private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 以友好的方式显示时间
     * 
     * @param sdate
     * @return
     */
    public static String friendly_time(String sdate) {
        Date time = toDate(sdate);
        if (time == null) {
            return "unknown";
        }

        String ftime = "";
        Calendar cal = Calendar.getInstance();
        long intervals = cal.getTimeInMillis() - time.getTime();
        if (intervals < 0) {
            return "刚刚";
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            // 当天
            int hour = (int) (intervals / 3600000);
            if (hour == 0) {
                int minutes = (int) (intervals / 60000);
                ftime = minutes < 1 ? "刚刚" : minutes + "分钟前";
            }
            else {
                ftime = hour + "小时前";
            }
        }
        else if (days == 1) {
            ftime = "昨天";
        }
        else if (days == 2) {
            ftime = "前天";
        }
        else if (days > 2 && days <= 10) {
            ftime = days + "天前";
        }
        else if (days > 10) {
            ftime = dateFormater2.get().format(time);
        }
        return ftime;
    }

    /**
     * 将字符串转位日期类型
     * 
     * @param sdate
     * @return
     */
    private static Date toDate(String sdate) {
        try {
            return dateFormater.get().parse(sdate);
        }
        catch (ParseException e) {
            return null;
        }
    }

}
