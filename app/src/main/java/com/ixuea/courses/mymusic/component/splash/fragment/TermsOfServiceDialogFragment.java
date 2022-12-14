package com.ixuea.courses.mymusic.component.splash.fragment;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.databinding.FragmentDialogTermsOfServiceBinding;
import com.ixuea.courses.mymusic.fragment.BaseViewModelDialogFragment;
import com.ixuea.courses.mymusic.util.ScreenUtil;
import com.ixuea.courses.mymusic.util.SuperTextUtil;
import com.ixuea.superui.process.SuperProcessUtil;

import androidx.fragment.app.FragmentManager;


public class TermsOfServiceDialogFragment extends BaseViewModelDialogFragment<FragmentDialogTermsOfServiceBinding> {
    private static final String TAG = "TermsOfServiceDialogFragment";
    private View.OnClickListener onAgreementClickListener;

    @Override
    protected void initViews() {
        super.initViews();

        //点击窗口外边不能关闭
        setCancelable(false);

        SuperTextUtil.setLinkColor(mBinding.content, getActivity().getColor(R.color.link));
    }

    @Override
    protected void initDatum() {
        super.initDatum();

        Spanned content = Html.fromHtml(getString(R.string.term_service_privacy_content));

        SpannableStringBuilder builder = SuperTextUtil.setHtmlLinkClick(content, data -> Log.d(TAG, "onLinkClick: "+data));
        mBinding.content.setText(builder);
    }

    @Override
    protected void initListeners() {
        super.initListeners();

        mBinding.agree.setOnClickListener(view -> {
            dismiss();
            onAgreementClickListener.onClick(view);
        });

        mBinding.disagree.setOnClickListener(view -> {
            dismiss();
            SuperProcessUtil.killApp();
        });
    }

    public static TermsOfServiceDialogFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TermsOfServiceDialogFragment fragment = new TermsOfServiceDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 显示对话框
     * @param onAgreementClickListener 同意按钮点击回调
     */
    public static void show(FragmentManager fragmentManager, View.OnClickListener onAgreementClickListener) {
        TermsOfServiceDialogFragment fragment = newInstance();
        fragment.onAgreementClickListener = onAgreementClickListener;
        fragment.show(fragmentManager, "TermsOfServiceDialogFragment");
    }

    @Override
    public void onResume() {
        super.onResume();

        // 修改宽度，默认AlertDialog.Builder显示对话框的宽度窄，不好看
        // 参考：https://
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();

        params.width = (int) (ScreenUtil.getScreenWidth(getContext()) * 0.9);
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((WindowManager.LayoutParams) params);
    }


}
