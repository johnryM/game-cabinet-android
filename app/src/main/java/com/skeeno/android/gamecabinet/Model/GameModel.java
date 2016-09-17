package com.skeeno.android.gamecabinet.Model;

import android.icu.util.Calendar;

/**
 * Created by Johnry on 9/4/2016.
 */
public class GameModel {

    private String mName;
    private Platform mPlatform;
    private Boolean mIsComplete;

    public GameModel(String name, Platform platform, Boolean isComplete) {
        mName = name;
        mPlatform = platform;
        mIsComplete = isComplete;
    }

    public String getGameTitle() {
        return mName;
    }

    public void setGameTitle(String name) {
        mName = name;
    }

    public Platform getPlatform() {
        return mPlatform;
    }

    public void setPlatform(Platform platform) {
        mPlatform = platform;
    }

    public Boolean getComplete() {
        return mIsComplete;
    }

    public void setComplete(Boolean complete) {
        mIsComplete = complete;
    }
}
