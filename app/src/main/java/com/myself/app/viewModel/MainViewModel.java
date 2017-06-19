package com.myself.app.viewModel;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.myself.app.R;
import com.myself.app.databinding.ActivityMainBinding;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private ActivityMainBinding binding;

    public MainViewModel(ActivityMainBinding binding) {
        this.binding = binding;
        initView();
    }

    private void initView() {
        binding.tv.setText("hahahahhaha");
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
                setChanged();
                notifyObservers();
                break;
        }
    }
}
