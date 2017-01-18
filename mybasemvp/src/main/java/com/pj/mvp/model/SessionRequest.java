package com.pj.mvp.model;

import java.io.Serializable;

/**
 * 会话接口 启动后的第一个访问接口
 */
public class SessionRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     */
    private String code;

    private String isFirst;

    private String channel;

    private String source;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getIsFirst() {

        return isFirst;
    }

    public void setIsFirst(String isFirst) {

        this.isFirst = isFirst;
    }

    public String getSource() {

        return source;
    }

    public void setSource(String source) {

        this.source = source;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
