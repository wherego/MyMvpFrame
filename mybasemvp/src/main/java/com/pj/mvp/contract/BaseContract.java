package com.pj.mvp.contract;

/**
 * BasePresenter和BaseView 方便管理放在了BaseContract里
 */
public interface BaseContract {

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }

    interface BaseView {
        void showError();

        void complete();
    }

}
