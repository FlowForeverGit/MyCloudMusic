package com.ixuea.courses.mymusic.activity;

import android.os.Bundle;

import com.ixuea.superui.reflect.ReflectUtil;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

public class BaseViewModelActivity<T extends ViewBinding> extends BaseLogicActivity {
    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ReflectUtil.newViewBinding(getLayoutInflater(), this.getClass());
        setContentView(mBinding.getRoot());
    }
}
