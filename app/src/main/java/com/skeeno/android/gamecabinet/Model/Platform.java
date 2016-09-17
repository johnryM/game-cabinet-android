package com.skeeno.android.gamecabinet.Model;

/**
 * Created by Johnry on 9/5/2016.
 */
public enum Platform {
    PC("PC"),
    XBOX_ONE("Xbox One"),
    XBOX_360("Xbox 360"),
    PS4("PS4"),
    PS3("PS3"),
    THREE_DS("3DS"),
    DS("DS"),
    OTHER("Other");

    private String platformString;

    Platform(String name) {
        platformString = name;
    }

    @Override
    public String toString() {
        return platformString;
    }
}
