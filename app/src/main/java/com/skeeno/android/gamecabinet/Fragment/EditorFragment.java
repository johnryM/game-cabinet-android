package com.skeeno.android.gamecabinet.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.R;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

public class EditorFragment extends Fragment {

    private static final int REQUEST_DATE = 0;
    private GameModel mGame;

    private static final String DIALOG_DATE = "DialogDate";

    @BindView(R.id.edit_text_title) EditText mTitleField;
    @BindView(R.id.edit_text_platform) EditText mPlatformField;
    @BindView(R.id.release_text_view) TextView mReleaseDateView;

    private Unbinder unbinder;

    public EditorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditorFragment newInstance(String param1, String param2) {
        EditorFragment fragment = new EditorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mGame = new GameModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor, container, false);
        unbinder = ButterKnife.bind(this,view);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) { return; }

        if (requestCode == REQUEST_DATE) {
            GregorianCalendar calendar = (GregorianCalendar) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            int style = DateFormat.FULL;
            DateFormat dateFormat = DateFormat.getDateInstance(style, Locale.UK);
            mReleaseDateView.setText(dateFormat.format(calendar.getTime()));
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_editor, menu);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnTextChanged(value = R.id.edit_text_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void setEditGameTitle(Editable editable) {
        mGame.setGameTitle(editable.toString());
    }

    @OnTextChanged(value = R.id.edit_text_platform, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void setEditGamePlatform(Editable editable) {
        mGame.setPlatform(editable.toString());
    }

    @OnClick(R.id.release_text_view)
    public void openCalendar() {
        FragmentManager fragmentManager = getFragmentManager();
        DatePickerFragment dialog = new DatePickerFragment();
        dialog.setTargetFragment(EditorFragment.this, REQUEST_DATE);
        dialog.show(fragmentManager, DIALOG_DATE);
    }

}
