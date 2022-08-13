package com.ixuea.superui.process;


import android.os.Process;

public class SuperProcessUtil {
    public static void killApp() {
        Process.killProcess(Process.myPid());
    }
}
