package com.skeeno.android.gamecabinet.Utils;

import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.Model.GameModelBuilder;

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
        list.add(new GameModelBuilder().setName("Pokemon Sun").setPlatform("3DS").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Deus Ex: Mankind Divided").setPlatform("PC").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Skate 3").setPlatform("XBOX 360").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Metal Gear Solid V: Phantom Pain").setPlatform("XBOX ONE").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Test Drive Unlimited").setPlatform("XBOX 360").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Stardew Valley").setPlatform("PC").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Call of Duty: Modern Warfare").setPlatform("XBOX 360").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Shadow of the Colossus Remastered").setPlatform("PS3").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Age of Empires II").setPlatform("PC").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Destiny").setPlatform("XBOX ONE").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Pokemon Yellow").setPlatform("GAMEBOY").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Warhammer 40000: Dawn of War").setPlatform("PC").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(true).createGameModel());
        list.add(new GameModelBuilder().setName("Final Fantasy XV").setPlatform("PS4").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());
        list.add(new GameModelBuilder().setName("Candy Crush").setPlatform("ANDROID").setReleaseDate(getRandomDate()).setDevelopers(getDevArray()).setGenres(getGenreArray()).setIsComplete(false).createGameModel());

        return list;
    }
}
