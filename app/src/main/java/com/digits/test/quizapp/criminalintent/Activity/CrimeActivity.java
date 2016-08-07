package com.digits.test.quizapp.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.digits.test.quizapp.criminalintent.Fragment.AbstractFragmentClass;
import com.digits.test.quizapp.criminalintent.Fragment.CrimeFragment;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class CrimeActivity extends AbstractFragmentClass {

    public Fragment getFragment(){
        Fragment crimeFragment = new CrimeFragment();
        return crimeFragment;
    }

}
