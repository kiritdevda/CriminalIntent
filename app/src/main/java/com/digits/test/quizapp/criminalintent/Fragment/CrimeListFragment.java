package com.digits.test.quizapp.criminalintent.Fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.digits.test.quizapp.criminalintent.Model.Crime;
import com.digits.test.quizapp.criminalintent.Model.CrimeLab;
import com.digits.test.quizapp.criminalintent.R;

import java.util.List;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class CrimeListFragment extends ListFragment {
    private List<Crime> mcrime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mcrime = CrimeLab.get(getActivity()).getcrimes();
    }
}
