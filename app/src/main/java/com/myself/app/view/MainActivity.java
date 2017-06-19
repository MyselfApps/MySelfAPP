package com.myself.app.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.myself.app.R;
import com.myself.app.databinding.ActivityMainBinding;
import com.myself.app.viewModel.MainViewModel;
import com.myself.app.viewModel.ViewModel;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends Activity implements Observer {
    private static final String TAG = "MainActivity";
    private Context context;
    private MainViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel((viewModel = new MainViewModel(binding)));
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof MainViewModel) {
            Toast.makeText(context, "arg:" + arg, Toast.LENGTH_SHORT).show();
        }
    }
}
