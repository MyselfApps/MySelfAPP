package com.myself.rxretrofitlib;

import android.app.Application;

/**
 * 全局变量
 * Created by Administrator on 2017/6/15 0015.
 */

public class RxRetrofitApp {
    private static Application application;
    private static boolean debug;

    private RxRetrofitApp() {
    }

    public static void init(Application app) {
        setApplication(app);
        setDebug(true);
    }

    public static void init(Application app, boolean debug) {
        setDebug(debug);
        setApplication(app);
    }

    public static Application getApplication() {
        return application;
    }

    public static void setApplication(Application application) {
        RxRetrofitApp.application = application;
    }

    public static void setDebug(boolean debug) {
        RxRetrofitApp.debug = debug;
    }

    public static boolean isDebug() {
        return debug;
    }


}
