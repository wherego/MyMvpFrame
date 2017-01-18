package com.pj.mvp.model.base;

import com.pj.mvp.api.Constant;

import java.io.Serializable;

/**
 * Created by pj on 17/01/12 012.
 * 统一的返回类
 */

public class HttpResult<T> implements Serializable{
    /**
     * 返回状态
     */
    private int state;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {

        this.state = state;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    /**
     * API是否请求成功
     *
     * @return 失败返回false, 成功返回true
     */
    public boolean isSuccess() {
        return state == Constant.WEB_RESP_CODE_SUCCESS;
    }
}
