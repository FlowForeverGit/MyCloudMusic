package com.ixuea.courses.mymusic.activity;

import com.ixuea.courses.mymusic.util.PreferenceUtil;

/**
 * 本项目的通用逻辑
 */
public class BaseLogicActivity extends BaseCommonActivity {

    protected PreferenceUtil mPreference;

    @Override
    protected void initDatum() {
        super.initDatum();
        mPreference = PreferenceUtil.getInstance(getHostActivity());
    }

    protected BaseCommonActivity getHostActivity() {
        return this;
    }
}
