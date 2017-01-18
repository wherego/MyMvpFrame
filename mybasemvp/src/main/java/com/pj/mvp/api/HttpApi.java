package com.pj.mvp.api;

import com.pj.mvp.api.support.CustomGsonConverterFactory;
import com.pj.mvp.api.support.HttpClient;
import com.pj.mvp.model.SessionRequest;
import com.pj.mvp.model.SessionResult;
import com.pj.mvp.persenter.support.HttpResultFunc;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by pj on 17/01/12 012.
 * 网络请求
 */

public class HttpApi {
    public static HttpApi instance;
    private HttpApiService service;

    private HttpApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(CustomGsonConverterFactory.create()) // 添加Gson转换器
                .client(okHttpClient)
                .build();
        service = retrofit.create(HttpApiService.class);
    }
    public static HttpApi getInstance() {
        if (instance == null) {
            instance = new HttpApi(new HttpClient().provideOkHttpClient());
        }
        return instance;
    }

    public Observable<SessionResult> getSession(){
        SessionRequest session = new SessionRequest();
        session.setChannel("xinfushe");
        session.setCode("fwrewrewrr32");
        session.setIsFirst("1");
        session.setSource("2");
        return service.getSession(session).map(new HttpResultFunc<SessionResult>());
    }
}
