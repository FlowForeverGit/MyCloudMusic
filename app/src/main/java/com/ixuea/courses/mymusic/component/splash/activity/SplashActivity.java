package com.ixuea.courses.mymusic.component.splash.activity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.BaseLogicActivity;
import com.ixuea.courses.mymusic.component.splash.fragment.TermsOfServiceDialogFragment;
import com.ixuea.courses.mymusic.util.SuperDarkUtil;
import com.ixuea.courses.mymusic.util.SuperDateUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends BaseLogicActivity {

    private static final String TAG = "SplashActivity";
    private TextView copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void initViews() {
        super.initViews();

        // 设置状态栏
        QMUIStatusBarHelper.translucent(this);
        if (SuperDarkUtil.isDark(this)) {
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
        else {
            QMUIStatusBarHelper.setStatusBarDarkMode(this);
        }

         copyright = findViewById(R.id.copyright);
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        copyright.setText(getResources().getString(R.string.copyright, SuperDateUtil.currentYear()));

        showTermsOfServiceAgreementDialog();
    }

    /**
     * 同意服务条款
     */
    private void showTermsOfServiceAgreementDialog() {
        TermsOfServiceDialogFragment.show(getSupportFragmentManager(), view -> Log.d(TAG, "onClick: "+"用户已经同意！"));
    }
}