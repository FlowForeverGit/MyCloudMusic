package com.ixuea.courses.mymusic.util;

import android.content.Context;
import android.content.res.Configuration;

public class SuperDarkUtil {

    public static boolean isDark(Context context) {
        return (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_NO;
    }
}
