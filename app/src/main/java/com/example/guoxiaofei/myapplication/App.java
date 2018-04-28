package com.example.guoxiaofei.myapplication;

import android.app.Application;
import android.text.format.DateFormat;

import java.io.File;
import java.io.IOException;

public class App extends Application implements Thread.UncaughtExceptionHandler {

    @Override
    public void onCreate() {
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //logcat to file

        File logFile = new File(this.getExternalCacheDir(),
                DateFormat.format("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()) + ".log");
        try {
            Runtime.getRuntime().exec("logcat -f " + logFile.getAbsolutePath());
            System.exit(1);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
