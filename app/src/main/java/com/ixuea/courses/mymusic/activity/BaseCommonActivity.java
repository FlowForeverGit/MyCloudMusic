package com.ixuea.courses.mymusic.activity;

import android.content.Intent;

import com.ixuea.courses.mymusic.component.guide.activity.GuideActivity;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 跟App无关的通用界面逻辑
 */
public class BaseCommonActivity extends BaseActivity {

    protected void startActivityAfterFinishThis(Class<? extends AppCompatActivity> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);

        finish();
    }
}
