package com.pj.mvp.persenter.support;

import android.widget.Toast;

import com.pj.mvp.App;
import com.pj.mvp.api.support.ApiException;
import com.pj.mvp.utils.LogUtils;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 基类Subscriber 处理接口定义的统一参数
 * @param <T>
 */
public class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(final Throwable e) {
        if (e instanceof HttpException) {
            LogUtils.d("httpLog: ",((HttpException) e).code()+((HttpException) e).message());
        } else if (e instanceof IOException) {
            LogUtils.d("httpLog: ","IOException");
        } else if (e instanceof ApiException) {
            ApiException exception = (ApiException) e;
            if (exception.isTokenExpried()) {
                //处理token失效对应的逻辑
            } else {
                Toast.makeText(App.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } 
    }

    @Override
    public void onNext(T t) {

    }

}