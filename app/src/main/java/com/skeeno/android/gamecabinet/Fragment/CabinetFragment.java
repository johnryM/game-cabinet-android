package com.skeeno.android.gamecabinet.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.Model.Platform;
import com.skeeno.android.gamecabinet.R;

import java.util.ArrayList;
import java.util.List;

public class CabinetFragment extends Fragment {

    private ArrayList<GameModel> mGameList = new ArrayList<>();

    private RecyclerView mGameListRecyclerView;
    private GameAdapter mGameAdapter;

    public CabinetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CabinetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CabinetFragment newInstance() {
        CabinetFragment fragment = new CabinetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mGameList.add(new GameModel("Final Fantasy XV", Platform.PS4, false));
        mGameList.add(new GameModel("Pokemon Sun", Platform.THREE_DS, false));
        mGameList.add(new GameModel("Deus Ex: Mankind Divided", Platform.PC, true));
        mGameList.add(new GameModel("Skate 3", Platform.XBOX_360, true));
        mGameList.add(new GameModel("Metal Gear Solid V: Phantom Pain", Platform.XBOX_ONE, false));
        mGameList.add(new GameModel("Test Drive Unlimited", Platform.XBOX_360, true));
        mGameList.add(new GameModel("Stardew Valley", Platform.PC, false));
        mGameList.add(new GameModel("Call of Duty: Modern Warfare", Platform.XBOX_360, true));
        mGameList.add(new GameModel("Shadow of the Colossus Remastered", Platform.PS3, false));
        mGameList.add(new GameModel("Age of Empires II", Platform.PC, false));
        mGameList.add(new GameModel("Destiny", Platform.XBOX_ONE, true));
        mGameList.add(new GameModel("Pokemon Yellow", Platform.OTHER, true));
        mGameList.add(new GameModel("Warhammer 40000: Dawn of War", Platform.PC, true));
        mGameList.add(new GameModel("Tamagotchi", Platform.OTHER, false));

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.game_cabinet_list, container, false);

        //set up recycler list with game view
        mGameListRecyclerView = (RecyclerView) view.findViewById(R.id.game_recycler_view);
        mGameListRecyclerView.setHasFixedSize(true);
        mGameListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateGameListUI();

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private class GameHolder extends RecyclerView.ViewHolder {

        public TextView mGameTitleTextView;
        public TextView mPlatformTextView;
        public CheckBox mCompletedCheck;

        public GameHolder(View itemView) {
            super(itemView);

            mGameTitleTextView = (TextView) itemView;
        }
    }

    private void updateGameListUI() {
        mGameAdapter = new GameAdapter(mGameList);
        mGameListRecyclerView.setAdapter(mGameAdapter);
    }

    private class GameAdapter extends RecyclerView.Adapter {

        private List<GameModel> mGames;

        public GameAdapter(List<GameModel> games) {
            mGames = games;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new GameHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            GameHolder gameHolder = (GameHolder) holder;
            GameModel game = mGames.get(position);
            gameHolder.mGameTitleTextView.setText(game.getGameTitle());
        }

        @Override
        public int getItemCount() {
            return mGames.size();
        }
    }

}
