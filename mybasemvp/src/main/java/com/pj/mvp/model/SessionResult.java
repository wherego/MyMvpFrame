package com.pj.mvp.model;

import java.io.Serializable;

/**
 * Created by pj on 17/01/12 012.
 */

public class SessionResult implements Serializable{
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
