package com.skeeno.android.gamecabinet.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.skeeno.android.gamecabinet.Model.GameManager;
import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.R;

import java.util.UUID;

public class GameInfoFragment extends Fragment {

    private static final String ARG_GAME_ID = "game_id";
    private GameModel mGame;

    public GameInfoFragment() {
        // Required empty public constructor
    }


    public static GameInfoFragment newInstance(UUID gameId) {
        GameInfoFragment fragment = new GameInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_GAME_ID, gameId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            UUID gameID = (UUID) getArguments().getSerializable(ARG_GAME_ID);
            mGame = GameManager.getInstance().getGameEntry(gameID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_game_info, container, false);

        TextView titleTextView = (TextView) view.findViewById(R.id.title_text);
        titleTextView.setText(mGame.getName());

        TextView platformTextView = (TextView) view.findViewById(R.id.platform_text);
        platformTextView.setText(mGame.getPlatform());

        TextView releaseTextView = (TextView) view.findViewById(R.id.release_text);
        releaseTextView.setText(mGame.getReleaseDate().toString());

        TextView devTextView = (TextView) view.findViewById(R.id.developer_text);
        devTextView.setText(mGame.getDevelopers().toString());

        TextView genreTextView = (TextView) view.findViewById(R.id.genre_text);
        genreTextView.setText(mGame.getGenres().toString());

        CheckBox completeCheckBox = (CheckBox) view.findViewById(R.id.complete_box);
        completeCheckBox.setChecked(mGame.getComplete());

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
