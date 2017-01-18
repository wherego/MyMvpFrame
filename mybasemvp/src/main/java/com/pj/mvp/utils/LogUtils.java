package com.pj.mvp.utils;

import android.util.Log;

import com.pj.mvp.BuildConfig;


/**
 * 日志--工具类
 * BuildConfig.SHOW_LOG 需要在gradle里配置buildConfigField
 */
public class LogUtils {
    public static final boolean SHOW = BuildConfig.SHOW_LOG;

    public static void log(String msg) {

        if (SHOW) {
            System.out.println(msg);
        }
    }

    public static void e(String tag, String msg) {

        if (SHOW) {
            Log.e(tag, msg);
        }
    }

    public static void d(String tag, String msg) {

        if (SHOW) {
            Log.d(tag, msg);
        }
    }

    public static void v(String tag, String msg) {

        if (SHOW) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {

        if (SHOW) {
            Log.w(tag, msg);
        }
    }

    public static void i(String tag, String msg) {

        if (SHOW) {
            Log.i(tag, msg);
        }
    }
}
