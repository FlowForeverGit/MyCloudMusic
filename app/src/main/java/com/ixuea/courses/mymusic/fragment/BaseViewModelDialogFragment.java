package com.ixuea.courses.mymusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ixuea.superui.reflect.ReflectUtil;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

public abstract class BaseViewModelDialogFragment<T extends ViewBinding> extends BaseDialogFragment {
    protected T mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ReflectUtil.newViewBinding(getLayoutInflater(), this.getClass());
    }

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding=null;
    }
}
