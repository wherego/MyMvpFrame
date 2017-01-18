package com.pj.mvp.api.support;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by pj on 17/01/13 013.
 * 拦截器中添加请求头
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .addHeader("Content-Type","plain/text")
                .addHeader("session","")
                .build();
        return chain.proceed(request);
    }
}
