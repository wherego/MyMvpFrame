package com.pj.mvp.persenter.support;

import com.pj.mvp.model.base.HttpResult;

import rx.functions.Func1;

/**
 * 将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
        return httpResult.getData();
    }
}