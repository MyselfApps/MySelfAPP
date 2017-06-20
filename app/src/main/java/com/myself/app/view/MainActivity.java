package com.myself.app.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.Toast;

import com.myself.app.R;
import com.myself.app.databinding.ActivityMainBinding;
import com.myself.app.utils.Utils;
import com.myself.app.viewModel.MainViewModel;

import java.util.Observable;


public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel;
        binding.setViewModel((viewModel = new MainViewModel(context)));
        setupObservable(viewModel, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MainViewModel) {

        }
    }
}
