package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 代码规范
 * 把onPostCreate的实现的业务逻辑拆分成三部分
 * initViews() 找控件
 * initDatum() 设置数据
 * initListeners() 设置监听器
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * 找控件
     */
    protected void initViews() {}

    /**
     * 设置数据
     */
    protected void initDatum() {}

    /**
     * 设置监听器
     */
    protected void initListeners() {}

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }
}
