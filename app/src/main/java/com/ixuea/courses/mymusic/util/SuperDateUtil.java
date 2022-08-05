package com.ixuea.courses.mymusic.util;

import java.util.Calendar;

public class SuperDateUtil {
    public static int currentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
}
