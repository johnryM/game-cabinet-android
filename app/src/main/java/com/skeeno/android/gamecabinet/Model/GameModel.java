package com.skeeno.android.gamecabinet.Model;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Johnry on 9/4/2016.
 */
public class GameModel {

    private UUID mUUID;
    private String mName;
    private String mPlatform;
    private GregorianCalendar mReleaseDate;
    private List<String> mDevelopers;
    private List<String> mGenres;
    private Boolean mIsComplete;

    public GameModel() {
        mUUID = UUID.randomUUID();
    }

    public GameModel(String name, String platform, GregorianCalendar releaseDate, List<String> developers, List<String> genres, Boolean isComplete) {
        mUUID = UUID.randomUUID();
        mName = name;
        mPlatform = platform;
        mReleaseDate = releaseDate;
        mDevelopers = developers;
        mGenres = genres;
        mIsComplete = isComplete;
    }


    public UUID getUUID() {
        return mUUID;
    }

    public String getGameTitle() {
        return mName;
    }

    public void setGameTitle(String name) {
        mName = name;
    }

    public String getPlatform() {
        return mPlatform;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getReleaseDate() {
        return mReleaseDate.getTime();
    }

    public List<String> getDevelopers() {
        return mDevelopers;
    }


    public List<String> getGenres() {
        return mGenres;
    }


    public void setPlatform(String platform) {
        mPlatform = platform;
    }

    public Boolean getComplete() {
        return mIsComplete;
    }

}
