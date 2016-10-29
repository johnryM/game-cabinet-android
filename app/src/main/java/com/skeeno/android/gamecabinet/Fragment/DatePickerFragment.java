package com.skeeno.android.gamecabinet.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;

import com.skeeno.android.gamecabinet.R;

import java.util.Date;
import java.util.GregorianCalendar;


public class DatePickerFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    static final String EXTRA_DATE = "extra_date" ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public DatePickerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DatePickerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DatePickerFragment newInstance(String param1, String param2) {
        DatePickerFragment fragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        final DatePicker mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);

        return new AlertDialog.Builder(getActivity()).
                setView(v).
                setTitle("Pick release date").
                setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year = mDatePicker.getYear();
                        int month = mDatePicker.getMonth();
                        int day = mDatePicker.getDayOfMonth();
                        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
                        sendResult(Activity.RESULT_OK, calendar);
                    }
                }).
                create();
    }

    private void sendResult(int resultCode, GregorianCalendar calendar) {
        if (getTargetFragment() == null) { return; }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, calendar);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
