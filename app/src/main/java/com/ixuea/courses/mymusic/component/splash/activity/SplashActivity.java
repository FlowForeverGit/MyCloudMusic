package com.ixuea.courses.mymusic.component.splash.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.util.SuperDarkUtil;
import com.ixuea.courses.mymusic.util.SuperDateUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        QMUIStatusBarHelper.translucent(this);
        if (SuperDarkUtil.isDark(this)) {
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
        else {
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        }

        TextView copyright = findViewById(R.id.copyright);
        copyright.setText(getResources().getString(R.string.copyright, SuperDateUtil.currentYear()));
    }
}