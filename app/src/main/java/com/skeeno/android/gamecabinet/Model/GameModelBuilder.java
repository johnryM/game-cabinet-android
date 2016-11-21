package com.skeeno.android.gamecabinet.Model;

import java.util.GregorianCalendar;
import java.util.List;

public class GameModelBuilder {
    private String mName;
    private String mPlatform;
    private GregorianCalendar mReleaseDate;
    private List<String> mDevelopers;
    private List<String> mGenres;
    private Boolean mIsComplete;

    public GameModelBuilder setName(String name) {
        mName = name;
        return this;
    }

    public GameModelBuilder setPlatform(String platform) {
        mPlatform = platform;
        return this;
    }

    public GameModelBuilder setReleaseDate(GregorianCalendar releaseDate) {
        mReleaseDate = releaseDate;
        return this;
    }

    public GameModelBuilder setDevelopers(List<String> developers) {
        mDevelopers = developers;
        return this;
    }

    public GameModelBuilder setGenres(List<String> genres) {
        mGenres = genres;
        return this;
    }

    public GameModelBuilder setIsComplete(Boolean isComplete) {
        mIsComplete = isComplete;
        return this;
    }

    public GameModel createGameModel() {
        return new GameModel(mName, mPlatform, mReleaseDate, mDevelopers, mGenres, mIsComplete);
    }
}