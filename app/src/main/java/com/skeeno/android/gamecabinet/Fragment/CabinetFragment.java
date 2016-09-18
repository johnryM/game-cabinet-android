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

import com.skeeno.android.gamecabinet.Model.GameManager;
import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.Model.Platform;
import com.skeeno.android.gamecabinet.R;
import com.skeeno.android.gamecabinet.UI.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CabinetFragment extends Fragment {

    private ArrayList<GameModel> mGameList = new ArrayList<>();
    private GameManager mGameManager;

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
        mGameManager = GameManager.getInstance();

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

        mGameListRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity()));

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void updateGameListUI() {
        fillGameList();
        mGameAdapter = new GameAdapter(mGameList);
        mGameListRecyclerView.setAdapter(mGameAdapter);
    }

    private void fillGameList() {
        for (int i = 0; i < mGameManager.getGameCollectionSize(); i++) {
            mGameList.add(mGameManager.getGameEntry(i));
        }
    }

    private class GameHolder extends RecyclerView.ViewHolder {

        public TextView mGameTitleTextView;
        public TextView mPlatformTextView;
        public CheckBox mCompletedCheck;

        public GameHolder(View itemView) {
            super(itemView);

            mGameTitleTextView = (TextView) itemView.findViewById(R.id.game_title_text);
            mPlatformTextView = (TextView) itemView.findViewById(R.id.game_platform_text);
            mCompletedCheck = (CheckBox) itemView.findViewById(R.id.completed_check_box);
        }
    }


    private class GameAdapter extends RecyclerView.Adapter<GameHolder> {

        private List<GameModel> mGames;

        public GameAdapter(List<GameModel> games) {
            mGames = games;
        }

        @Override
        public GameHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.game_cabinet_list_item, parent, false);
            return new GameHolder(view);
        }

        @Override
        public void onBindViewHolder(GameHolder holder, int position) {
            GameModel game = mGames.get(position);
            holder.mGameTitleTextView.setText(game.getGameTitle());
            holder.mPlatformTextView.setText(game.getPlatform().toString());
            holder.mCompletedCheck.setChecked(game.getComplete());
        }

        @Override
        public int getItemCount() {
            return mGames.size();
        }
    }

}
