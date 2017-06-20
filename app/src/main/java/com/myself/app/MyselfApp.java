package com.myself.app;

import android.app.Application;

import com.myself.app.model.greendao.helper.GreenDaoHelper;
import com.myself.app.utils.Utils;
import com.myself.rxretrofitlib.RxRetrofitApp;

/**
 * application
 * Created by Administrator on 2017/6/15 0015.
 */

public class MyselfApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化dao创建应用数据看
        GreenDaoHelper.getInstance(this, Utils.DB_NAME);
        // 初始化网络设置
        RxRetrofitApp.init(this,Utils.BASEURL);
    }
}
