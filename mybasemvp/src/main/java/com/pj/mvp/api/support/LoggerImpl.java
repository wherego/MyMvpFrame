package com.pj.mvp.api.support;


import com.pj.mvp.utils.LogUtils;

/**
 * @author yuyh.
 * @date 2016/12/13.
 */
public class LoggerImpl implements LoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtils.i("httpLog: ", message);
    }
}
