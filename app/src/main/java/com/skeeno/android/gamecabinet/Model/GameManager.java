package com.skeeno.android.gamecabinet.Model;

import com.skeeno.android.gamecabinet.Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Johnry on 9/18/2016.
 *
 * Snazzy Singleton that will only create one instance of class
 * can be serialized and avoids synchronization issues
 */
public class GameManager {
    //prevent compiler from throwing error when serializing/deserializing
    //by telling it that it is of the same class
    private static  final long serialVersionUID = 1L;

    private List<GameModel> mGameList;

    private GameManager () {
        mGameList = new ArrayList<>(HelperUtils.addDefaultData());
    }

    private static class GameManagerHolder {
        public static final GameManager INSTANCE = new GameManager();
    }

    public static GameManager getInstance() {
        return GameManagerHolder.INSTANCE;
    }

    protected Object readResolve() {
        return getInstance();
    }


    public void addGameEntry(GameModel game) {
        mGameList.add(game);
    }

    public void removeGameEntry(String id) {
        //TODO think of way to do this
    }

    public GameModel getGameEntry(int position) {
        try {
            return mGameList.get(position);
        } catch (IndexOutOfBoundsException err) {
            err.printStackTrace();
            return  null;
        }
    }

    public GameModel getGameEntry(UUID gameId) {
        for(GameModel game : mGameList) {
            if (game.getUUID().equals(gameId)) {
                return game;
            }
        }
        return null;
    }

    public int getGameCollectionSize() {
        return mGameList.size();
    }

}

