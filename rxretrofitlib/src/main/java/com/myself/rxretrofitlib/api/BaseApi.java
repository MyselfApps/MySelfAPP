package com.myself.rxretrofitlib.api;


import com.myself.rxretrofitlib.RxRetrofitApp;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * 请求数据统一封装类
 * Created by zhujl on 2017/6/15 0015.
 */
public abstract class BaseApi {
    // 是否能取消加载框
    private boolean cancel = false;
    // 是否显示加载框
    private boolean showProgress = true;
    // 是否需要缓存处理
    private boolean cache = false;
    // 基础url
    private String baseUrl = RxRetrofitApp.getBaseUrl();
    //方法--如果需要设置缓存则必须设置这个参数，不需要缓存则不需要设置
    private String method = "";
    //这只超时时间6s
    private int connectionTime = 6;
    //有网的情况下本地缓存时间默认为60s
    private int cookieNetWorkTime = 60;
    //无网的情况下本地缓存时间默认为30d
    private int cookieNoNetWorkTime = 24 * 60 * 60 * 30;
    // retry次数
    private int retryCount = 1;
    // retry延迟
    private long retryDelay = 100;
    //retry 叠加延迟
    private long retryIncreaseDelay = 100;

    public abstract Observable getObservable(Retrofit retrofit);

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getConnectionTime() {
        return connectionTime;
    }

    public void setConnectionTime(int connectionTime) {
        this.connectionTime = connectionTime;
    }

    public int getCookieNetWorkTime() {
        return cookieNetWorkTime;
    }

    public void setCookieNetWorkTime(int cookieNetWorkTime) {
        this.cookieNetWorkTime = cookieNetWorkTime;
    }

    public int getCookieNoNetWorkTime() {
        return cookieNoNetWorkTime;
    }

    public void setCookieNoNetWorkTime(int cookieNoNetWorkTime) {
        this.cookieNoNetWorkTime = cookieNoNetWorkTime;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public long getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(long retryDelay) {
        this.retryDelay = retryDelay;
    }

    public long getRetryIncreaseDelay() {
        return retryIncreaseDelay;
    }

    public void setRetryIncreaseDelay(long retryIncreaseDelay) {
        this.retryIncreaseDelay = retryIncreaseDelay;
    }

    public String getUrl() {
        return baseUrl + method;
    }
}
