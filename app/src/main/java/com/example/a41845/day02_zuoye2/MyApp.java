package com.example.a41845.day02_zuoye2;

import android.app.Application;

public class MyApp extends Application {

    private static MyApp app;

    @Override
    public void onCreate() {

        super.onCreate();
        app = this;
    }

    public static MyApp getApp() {
        return app;
    }
}
