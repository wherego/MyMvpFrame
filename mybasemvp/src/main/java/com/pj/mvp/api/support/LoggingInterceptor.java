package com.pj.mvp.api.support;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pj on 17/01/13 013.
 * 打印日志
 */

public class LoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final Logger logger;

    public LoggingInterceptor(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long t2 = System.currentTimeMillis();
        logger.log(request.url().toString()+"\n"+(t2-t1)+"ms");
        return response;
    }
    public interface Logger {
        void log(String message);
    }
}
