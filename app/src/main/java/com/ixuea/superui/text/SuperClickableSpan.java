package com.ixuea.superui.text;

import android.text.TextPaint;
import android.text.style.ClickableSpan;

import androidx.annotation.NonNull;

public abstract class SuperClickableSpan extends ClickableSpan {
    /**
     * 更新绘制状态
     */
    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        //设置颜色
        ds.setColor(ds.linkColor);

        //去掉下划线
        ds.setUnderlineText(false);

    }
}
