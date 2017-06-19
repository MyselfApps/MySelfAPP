package com.myself.app.view;

import android.app.Activity;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class BaseActivity extends Activity implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("o----" + o);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
