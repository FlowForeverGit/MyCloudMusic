package com.ixuea.courses.mymusic.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtil {
    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        //获取Window管理器
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        //创建显示对象
        DisplayMetrics metrics = new DisplayMetrics();

        //获取默认显示对象
        manager.getDefaultDisplay().getMetrics(metrics);

        return metrics.widthPixels;
    }
}
