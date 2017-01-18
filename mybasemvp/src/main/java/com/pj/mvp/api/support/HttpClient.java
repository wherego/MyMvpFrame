package com.pj.mvp.api.support;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by pj on 17/01/13 013.
 */

public class HttpClient {

    public OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new LoggingInterceptor(new LoggerImpl()))
                ;
        return builder.build();
    }

}
