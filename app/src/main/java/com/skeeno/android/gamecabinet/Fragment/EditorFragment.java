package com.skeeno.android.gamecabinet.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.skeeno.android.gamecabinet.Model.GameModel;
import com.skeeno.android.gamecabinet.R;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class EditorFragment extends Fragment {

    private static final int REQUEST_DATE = 0;
    private GameModel mGame;

    private static final String DIALOG_DATE = "DialogDate";

    private EditText mTitleField;
    private EditText mPlatformField;
    private TextView mReleaseDateView;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor, container, false);

        mTitleField = (EditText) view.findViewById(R.id.edit_text_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGame.setGameTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlatformField = (EditText) view.findViewById(R.id.edit_text_platform);
        mPlatformField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGame.setPlatform(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mReleaseDateView = (TextView) view.findViewById(R.id.release_text_view);
        mReleaseDateView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(EditorFragment.this, REQUEST_DATE);
                dialog.show(fragmentManager, DIALOG_DATE);
            }
        });


        return view;
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
}
