package com.myself.app.viewModel;

import android.view.View;

import java.util.Observable;

/**
 * 抽象ViewModel类，其他的具体ViewModel继承此类
 * 继承被观察者类，用于向观察者类的对应的View类发送通知更新UI
 * Created by zhujl on 2017/6/19 0019.
 */

public abstract class ViewModel extends Observable{

    /**
     * 点击事件方法，需要用到的重写，否则可不重
     * onClick方法在xml文件中配置： android:onClick="@{viewModel::onClick}"
     * @param view view
     */
    public  void onClick(View view){}
}
