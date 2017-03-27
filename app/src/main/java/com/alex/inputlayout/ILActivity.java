package com.alex.inputlayout;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import org.alex.baseui.AbsActivity;

/**
 * 作者：Alex
 * 时间：2017/3/25 17:09
 * 简述：
 */
public abstract class ILActivity extends AbsActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
    }
}
