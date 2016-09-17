package com.skeeno.android.gamecabinet.Model;

import android.icu.util.Calendar;

public class GameModelBuilder {
    private String mName;
    private Platform mPlatform;
    private Boolean mIsComplete;
    private Calendar mDateCompleted;

    public GameModelBuilder setName(String name) {
        mName = name;
        return this;
    }

    public GameModelBuilder setPlatform(Platform platform) {
        mPlatform = platform;
        return this;
    }

    public GameModelBuilder setIsComplete(Boolean isComplete) {
        mIsComplete = isComplete;
        return this;
    }

    public GameModelBuilder setDateCompleted(Calendar dateCompleted) {
        mDateCompleted = dateCompleted;
        return this;
    }

    public GameModel createGame() {
        return new GameModel(mName, mPlatform, mIsComplete);
    }
}