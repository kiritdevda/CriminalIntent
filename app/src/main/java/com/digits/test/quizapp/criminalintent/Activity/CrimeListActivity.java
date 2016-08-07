package com.digits.test.quizapp.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.digits.test.quizapp.criminalintent.Fragment.AbstractFragmentClass;
import com.digits.test.quizapp.criminalintent.Fragment.CrimeListFragment;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class CrimeListActivity extends AbstractFragmentClass {

    @Override
    protected Fragment getFragment() {
        CrimeListFragment crimeListFragment = new CrimeListFragment();
        return crimeListFragment;
    }
}
