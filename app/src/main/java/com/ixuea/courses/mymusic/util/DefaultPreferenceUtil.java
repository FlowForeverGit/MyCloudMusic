package com.ixuea.courses.mymusic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DefaultPreferenceUtil {
    private static final String TERMS_OF_SERVICE = "terms_of_service_agreement";

    private static DefaultPreferenceUtil instance;
    private final Context mContext;
    private final SharedPreferences mPreferences;

    public DefaultPreferenceUtil(Context context) {
        mContext = context.getApplicationContext();
        mPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public synchronized static DefaultPreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance = new DefaultPreferenceUtil(context);
        }
        return instance;
    }

    public void setAcceptTermsOfServiceAgreement(boolean isAccept) {
        mPreferences.edit().putBoolean(TERMS_OF_SERVICE, isAccept).commit();
    }

    public boolean isAcceptTermsOfServiceAgreement() {
        return mPreferences.getBoolean(TERMS_OF_SERVICE, false);
    }
}
