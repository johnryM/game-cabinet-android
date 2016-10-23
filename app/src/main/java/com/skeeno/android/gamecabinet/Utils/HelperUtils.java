package com.skeeno.android.gamecabinet.Utils;

import com.skeeno.android.gamecabinet.Model.GameModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Johnry on 10/16/2016.
 */

public class HelperUtils {

    private static GregorianCalendar getRandomDate() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1950, 2016);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        return gc;
    }

    private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    private static List<String> getGenreArray() {
        int n = randBetween(1,4);

        switch(n) {
            case 1: return Arrays.asList("Sport");
            case 2: return Arrays.asList("RPG", "Action");
            case 3: return Arrays.asList("RTS");
            case 4: return Arrays.asList("Puzzle");
            default: return Arrays.asList("Strategy, FPS");
        }
    }

    private static List<String> getDevArray() {
        int n = randBetween(1,3);

        switch(n) {
            case 1: return Arrays.asList("Ensemble Studios");
            case 2: return Arrays.asList("Criterion");
            case 3: return Arrays.asList("Infinity Ward, Respawn Ent");
            default: return Arrays.asList("What evs");
        }
    }


    public static ArrayList<GameModel> addDefaultData() {
        ArrayList<GameModel> list = new ArrayList();
        list.add(new GameModel("Pokemon Sun", "3DS", getRandomDate(), getDevArray(), getGenreArray(), false));
        list.add(new GameModel("Deus Ex: Mankind Divided", "PC", getRandomDate(), getDevArray(), getGenreArray(), true));
        list.add(new GameModel("Skate 3", "XBOX 360", getRandomDate(), getDevArray(), getGenreArray(),true));
        list.add(new GameModel("Metal Gear Solid V: Phantom Pain", "XBOX ONE", getRandomDate(), getDevArray(), getGenreArray(), false));
        list.add(new GameModel("Test Drive Unlimited", "XBOX 360", getRandomDate(), getDevArray(), getGenreArray(),true));
        list.add(new GameModel("Stardew Valley", "PC", getRandomDate(), getDevArray(), getGenreArray(),false));
        list.add(new GameModel("Call of Duty: Modern Warfare", "XBOX 360", getRandomDate(), getDevArray(), getGenreArray(),true));
        list.add(new GameModel("Shadow of the Colossus Remastered", "PS3", getRandomDate(), getDevArray(), getGenreArray(),false));
        list.add(new GameModel("Age of Empires II", "PC", getRandomDate(), getDevArray(), getGenreArray(), false));
        list.add(new GameModel("Destiny", "XBOX ONE", getRandomDate(), getDevArray(), getGenreArray(), true));
        list.add(new GameModel("Pokemon Yellow", "GAMEBOY", getRandomDate(), getDevArray(), getGenreArray(), true));
        list.add(new GameModel("Warhammer 40000: Dawn of War", "PC", getRandomDate(), getDevArray(), getGenreArray(),true));
        list.add(new GameModel("Final Fantasy XV", "PS4", getRandomDate(), getDevArray(), getGenreArray(), false));
        list.add(new GameModel("Candy Crush", "ANDROID",getRandomDate(), getDevArray(), getGenreArray(),false));

        return list;
    }
}
