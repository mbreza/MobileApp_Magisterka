package com.example.mbreza.wnb.service;

import android.app.Application;
import android.content.Context;

public class ContextProvider extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        ContextProvider.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return ContextProvider.context;
    }
}