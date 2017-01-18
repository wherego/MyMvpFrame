package com.pj.mvp.persenter;

import android.text.TextUtils;

import com.pj.mvp.api.HttpApi;
import com.pj.mvp.contract.LoginContract;
import com.pj.mvp.model.SessionResult;
import com.pj.mvp.persenter.support.BaseSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 登录Presenter的实现类
 */
public class LoginPresenter<T extends LoginContract.View> implements LoginContract.Presenter<T> {
    private T mView;
    private HttpApi httpApi;

    public LoginPresenter() {
        httpApi = HttpApi.getInstance();
    }

    @Override
    public void login(String userName, String passWord) {
        if (TextUtils.isEmpty(userName)) {
            mView.onNameError();
            return;
        }
        if (TextUtils.isEmpty(passWord)) {
            mView.onPassWordError();
            return;
        }
        httpApi.getSession()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<SessionResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }

                    @Override
                    public void onNext(SessionResult sessionResult) {
                        mView.complete();
                    }
                });
    }

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
    }
}
