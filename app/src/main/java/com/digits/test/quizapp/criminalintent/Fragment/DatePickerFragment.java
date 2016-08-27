package com.digits.test.quizapp.criminalintent.Fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.digits.test.quizapp.criminalintent.R;

/**
 * A simple {@link DialogFragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {


    public DatePickerFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.DatePicker_title)
                .setPositiveButton("Ok",null)
                .create();
    }
}
