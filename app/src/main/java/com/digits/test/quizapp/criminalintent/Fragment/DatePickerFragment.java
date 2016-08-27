package com.digits.test.quizapp.criminalintent.Fragment;


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
import android.widget.DatePicker;
import android.widget.TextView;

import com.digits.test.quizapp.criminalintent.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link DialogFragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {

    public static final String EXTRA_DATE = "com.digits.test.quizapp.criminalintent.Fragment.Date";
    public static Date date_selected;
    public DatePickerFragment() {
        // Required empty public constructor
    }

    public static DatePickerFragment newInstance(Date date){

        Bundle args = new Bundle();

        args.putSerializable(EXTRA_DATE,date);
        DatePickerFragment dialog = new DatePickerFragment();

        dialog.setArguments(args);
        return dialog;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Date date = (Date)getArguments().getSerializable(EXTRA_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_date,null);

        //Adding the code to set current date to date from crimeFragment

        DatePicker df = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        df.init(year, month, day,new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int month, int day) {

                date_selected = new GregorianCalendar(year,month,day).getTime();

                //This helps to preserve date even if screen gets rotated
                getArguments().putSerializable(EXTRA_DATE,date_selected);
            }
        });



        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.DatePicker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .create();
    }

        private void sendResult(int Result_code){
            if( getTargetFragment() == null){return;}

            Intent intent = new Intent();
            intent.putExtra(EXTRA_DATE,date_selected);

            getTargetFragment().
                    onActivityResult(getTargetRequestCode(),Result_code,intent);
        }
}
