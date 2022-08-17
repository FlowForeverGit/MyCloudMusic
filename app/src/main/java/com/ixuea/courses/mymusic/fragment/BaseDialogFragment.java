package com.ixuea.courses.mymusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ixuea.courses.mymusic.activity.BaseCommonActivity;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * 代码规范
 * 把onPostCreate的实现的业务逻辑拆分成三部分
 * initViews() 找控件
 * initDatum() 设置数据
 * initListeners() 设置监听器
 */
public abstract class BaseDialogFragment extends DialogFragment {

    /**
     * 找控件
     */
    protected void initViews() {
    }

    /**
     * 设置数据
     */
    protected void initDatum() {
    }

    /**
     * 设置监听器
     */
    protected void initListeners() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutView(inflater, container, savedInstanceState);
        return view;
    }

    /**
     * 获取View
     */
    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        initDatum();
        initListeners();
    }

    /**
     * 给DialogFragment增加一个findViewById方法
     */
    public <T extends View> T findViewById(@IdRes int id) {
        return getDialog().findViewById(id);
    }

    protected BaseCommonActivity getHostActivity() {
        return (BaseCommonActivity) getActivity();
    }
}
