package com.skeeno.android.gamecabinet.Model;

import java.util.ArrayList;
import java.util.List;

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
        mGameList = new ArrayList<>(addDefaultData());
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

    public ArrayList<GameModel> addDefaultData() {
        ArrayList<GameModel> list = new ArrayList();
        list.add(new GameModel("Pokemon Sun", Platform.THREE_DS, false));
        list.add(new GameModel("Deus Ex: Mankind Divided", Platform.PC, true));
        list.add(new GameModel("Skate 3", Platform.XBOX_360, true));
        list.add(new GameModel("Metal Gear Solid V: Phantom Pain", Platform.XBOX_ONE, false));
        list.add(new GameModel("Test Drive Unlimited", Platform.XBOX_360, true));
        list.add(new GameModel("Stardew Valley", Platform.PC, false));
        list.add(new GameModel("Call of Duty: Modern Warfare", Platform.XBOX_360, true));
        list.add(new GameModel("Shadow of the Colossus Remastered", Platform.PS3, false));
        list.add(new GameModel("Age of Empires II", Platform.PC, false));
        list.add(new GameModel("Destiny", Platform.XBOX_ONE, true));
        list.add(new GameModel("Pokemon Yellow", Platform.OTHER, true));
        list.add(new GameModel("Warhammer 40000: Dawn of War", Platform.PC, true));
        list.add(new GameModel("Final Fantasy XV", Platform.PS4, false));
        list.add(new GameModel("Tamagotchi", Platform.OTHER, false));

        return list;
    }

    public int getGameCollectionSize() {
        return mGameList.size();
    }
}

