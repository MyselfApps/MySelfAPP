package com.myself.app.viewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

import com.myself.app.R;
import com.myself.app.databinding.ActivityMainBinding;
import com.myself.app.view.HttpTestActivity;

/**
 * 与xml文件匹配的所有参数和方法都要是public类型
 * Created by Administrator on 2017/6/12 0012.
 */

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private Context context;
    public ObservableField<String> tvText;//参数的名字必须与xml文件中的相对应android:text="@{viewModel.tvText}"

    public MainViewModel(Context context) {
        super(context);
        this.context = context;
        tvText = new ObservableField<>("Let's begin");
    }


    /**
     * 重写点击事件
     *
     * @param view view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn:
                Intent intent = new Intent(context, HttpTestActivity.class);
                context.startActivity(intent);
//                update();
                break;
        }
    }
}
