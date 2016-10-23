package com.skeeno.android.gamecabinet;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skeeno.android.gamecabinet.Fragment.GameInfoFragment;

import java.util.UUID;


public class GameActivity extends AppCompatActivity {

    private static final String EXTRA_GAME_ID = "extra_game_id";

    public static Intent newIntent(Context context, UUID gameId) {
        Intent intent = new Intent(context, GameActivity.class);
        intent.putExtra(EXTRA_GAME_ID, gameId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment gameInfoFragment = fragmentManager.findFragmentById(R.id.activity_editor_container);

        UUID gameId = (UUID) getIntent().getSerializableExtra(EXTRA_GAME_ID);

        if(gameInfoFragment == null) {
            gameInfoFragment = GameInfoFragment.newInstance(gameId);
            fragmentManager.beginTransaction()
                    .add(R.id.activity_game_container, gameInfoFragment)
                    .commit();
        }
    }

}
