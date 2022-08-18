package com.ixuea.courses.mymusic.component.splash.activity;


import android.Manifest;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.BaseLogicActivity;
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;
import com.ixuea.courses.mymusic.component.splash.fragment.TermsOfServiceDialogFragment;
import com.ixuea.courses.mymusic.databinding.ActivitySplashBinding;
import com.ixuea.courses.mymusic.util.DefaultPreferenceUtil;
import com.ixuea.courses.mymusic.util.SuperDarkUtil;
import com.ixuea.courses.mymusic.util.SuperDateUtil;
import com.ixuea.superui.process.SuperProcessUtil;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class SplashActivity extends BaseViewModelActivity<ActivitySplashBinding> {

    private static final String TAG = "SplashActivity";

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
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        mBinding.copyright.setText(getResources().getString(R.string.copyright, SuperDateUtil.currentYear()));
        if (DefaultPreferenceUtil.getInstance(getHostActivity()).isAcceptTermsOfServiceAgreement()) {
            checkPermission();
        }
        else {
            showTermsOfServiceAgreementDialog();
        }
    }

    /**
     * 同意服务条款
     */
    private void showTermsOfServiceAgreementDialog() {
        TermsOfServiceDialogFragment.show(getSupportFragmentManager(), new OnClickListener() {
            @Override
            public void onClick(View view) {
                DefaultPreferenceUtil.getInstance(getHostActivity()).setAcceptTermsOfServiceAgreement(true);
                checkPermission();
            }
        });
    }

    /**
     * 权限授权了就会调用该方法
     * 请求相机权限目的是扫描二维码，拍照
     */
    @NeedsPermission({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void onPermissionGranted() {
        prepareNext();
    }

    private void prepareNext() {
        System.out.println(TAG + "下一步");
    }

    /**
     * 显示权限授权对话框
     * 目的是提示用户
     */
    @OnShowRationale({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showRequestPermission(PermissionRequest request) {
        new AlertDialog.Builder(getHostActivity())
                .setMessage(R.string.permission_hint)
                .setPositiveButton(R.string.allow, (dialog, which) -> request.proceed())
                .setNegativeButton(R.string.deny, (dialog, which) -> request.cancel()).show();
    }
    /**
     * 拒绝了权限调用
     */
    @OnPermissionDenied({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showDenied() {
        System.out.println(TAG + "停止应用");
        SuperProcessUtil.killApp();
    }

    /**
     * 再次获取权限的提示
     */
    @OnNeverAskAgain({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showNeverAskAgain() {
        checkPermission();
    }

    /**
     * 授权后回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void checkPermission() {
        SplashActivityPermissionsDispatcher.onPermissionGrantedWithPermissionCheck(this);
    }

}