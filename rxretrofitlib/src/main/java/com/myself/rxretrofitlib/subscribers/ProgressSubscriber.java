package com.myself.rxretrofitlib.subscribers;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.myself.rxretrofitlib.api.BaseApi;
import com.myself.rxretrofitlib.http.cookie.CookieResult;
import com.myself.rxretrofitlib.listener.HttpOnNextListener;
import com.myself.rxretrofitlib.utils.AppUtil;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.lang.ref.SoftReference;

import rx.Subscriber;

/**
 * 用于在http请求开始时，自动显示一个progress dialog
 * 在http请求结束时，关闭progress dialog
 * Created by Administrator on 2017/6/15 0015.
 */

public class ProgressSubscriber<T> extends Subscriber<T> {
    // 是否弹框
    private boolean showProgress = true;
    // 回调接口
    private SoftReference<HttpOnNextListener> mSubscriberOnNextListener;
    // 软引用
    private SoftReference<Context> mActivity;
    // 加载框
    private ProgressDialog pd;
    // 请求数据
    private BaseApi api;

    public ProgressSubscriber(BaseApi api,
                              SoftReference<HttpOnNextListener> onNextListener,
                              SoftReference<Context> mActivity) {
        this.api = api;
        this.mSubscriberOnNextListener = onNextListener;
        this.mActivity = mActivity;
        setShowProgress(api.isShowProgress());
        if (api.isShowProgress()) {
            initProgressDialog(api.isCancel());
        }

    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    private void initProgressDialog(boolean cancel) {
        Context context = mActivity.get();
        if (pd == null && context != null) {
            pd = new ProgressDialog(context);
            pd.setCancelable(cancel);
            if (cancel) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        onCancelProgress();
                    }
                });
            }
        }
    }

    private void showProgressDialog() {
        if (!isShowProgress()) return;
        Context context = mActivity.get();
        if (pd == null || context == null) return;
        if (!pd.isShowing()) {
            pd.show();
        }
    }

    private void dismissProgressDialog() {
        if (!isShowProgress()) return;
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    private void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onStart() {
        showProgressDialog();
        if (api.isCache() && AppUtil.isNetworkAvailable(mActivity.get())) {
//            CookieResult cookieResult =

        }
    }
}
