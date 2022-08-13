package com.ixuea.courses.mymusic.util;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ixuea.superui.text.SuperClickableSpan;
import com.qmuiteam.qmui.widget.textview.QMUILinkTextView;

import androidx.annotation.NonNull;

public class SuperTextUtil {
    public static SpannableStringBuilder setHtmlLinkClick(Spanned data, OnLinkClickListener listener) {
        SpannableStringBuilder builder = new SpannableStringBuilder(data);
        URLSpan[] spans = builder.getSpans(0, builder.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = builder.getSpanStart(span);
            int end = builder.getSpanEnd(span);
            int flags = builder.getSpanFlags(span);

            builder.setSpan(new SuperClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    listener.onLinkClick(span.getURL());
                }
            }, start, end, flags);
        }
        return builder;
    }

    /**
     * 设置富文本，超链接颜色
     */
    public static void setLinkColor(TextView view, int color) {
        //设置可点击
        view.setMovementMethod(LinkMovementMethod.getInstance());

        //设置链接颜色
        view.setLinkTextColor(color);
    }

    public interface OnLinkClickListener {
        void onLinkClick(String data);
    }
}
