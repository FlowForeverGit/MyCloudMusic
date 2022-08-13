package com.ixuea.courses.mymusic.component.splash.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.fragment.BaseDialogFragment;

import androidx.fragment.app.FragmentManager;

public class TermsOfServiceDialogFragment extends BaseDialogFragment {

    /**
     * 显示对话框
     * @param fragmentManager
     * @param onAgreementClickListener 同意按钮点击回调
     */
    public static void show(FragmentManager fragmentManager, View.OnClickListener onAgreementClickListener) {
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog_terms_of_service, container, false);
    }
}
