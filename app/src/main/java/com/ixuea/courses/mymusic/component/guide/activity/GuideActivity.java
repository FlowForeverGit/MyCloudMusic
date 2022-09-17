package com.ixuea.courses.mymusic.component.guide.activity;

import android.view.View;

import com.ixuea.courses.mymusic.MainActivity;
import com.ixuea.courses.mymusic.R;
import com.ixuea.courses.mymusic.activity.BaseViewModelActivity;
import com.ixuea.courses.mymusic.databinding.ActivityGuideBinding;


public class GuideActivity extends BaseViewModelActivity <ActivityGuideBinding> implements View.OnClickListener {

    @Override
    protected void initListeners() {
        super.initListeners();

        mBinding.loginOrRegister.setOnClickListener(this);
        mBinding.experienceNow.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_or_register:
                setShowGuide();
                break;
            case  R.id.experience_now:
                startActivityAfterFinishThis(MainActivity.class);
                setShowGuide();
                break;
        }
    }

    private void setShowGuide() {
        mPreference.setShowGuide(false);
    }
}
