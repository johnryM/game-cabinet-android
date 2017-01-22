package com.skeeno.android.gamecabinet.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by skeeno on 22/01/2017.
 */

public class GameCabinetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
