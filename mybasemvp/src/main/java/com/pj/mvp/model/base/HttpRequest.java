package com.pj.mvp.model.base;

import java.io.Serializable;

/**
 * Created by pj on 17/01/12 012.
 * 统一的请求类
 */

public class HttpRequest<T> implements Serializable {
    /**
     * 会话session值
     */
    private String session;

    /**
     * 版本号
     */
    private String versionCode;

    /**
     * 数据
     */
    private T data;// 数据

    public T getData() {

        return data;
    }

    public void setData(T data) {

        this.data = data;
    }

    public String getSession() {

        return session;
    }

    public void setSession(String session) {

        this.session = session;
    }

    public String getVersionCode() {

        return versionCode;
    }

    public void setVersionCode(String versionCode) {

        this.versionCode = versionCode;
    }
}
