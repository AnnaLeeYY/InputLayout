package com.alex.inputlayout;

import android.app.Application;

import org.alex.util.BaseUtil;

/**
 * 作者：Alex
 * 时间：2017/3/25 17:11
 * 简述：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseUtil.getInstance().init(this);
    }
}
