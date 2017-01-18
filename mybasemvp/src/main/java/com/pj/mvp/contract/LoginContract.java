package com.pj.mvp.contract;

/**
 * 登录契约接口
 */
public interface LoginContract {

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void login(String userName,String password);
    }

    interface View extends BaseContract.BaseView {
        public void onNameError();
        public void onPassWordError();
    }

}
