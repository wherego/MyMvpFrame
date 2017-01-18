package com.pj.mvp;

import android.app.Application;
import android.content.Context;

/**
 * 自定义Application
 */

public class App extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }


}
