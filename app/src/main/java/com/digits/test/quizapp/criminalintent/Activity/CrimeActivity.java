package com.digits.test.quizapp.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.digits.test.quizapp.criminalintent.Fragment.AbstractFragmentClass;
import com.digits.test.quizapp.criminalintent.Fragment.CrimeFragment;

import java.util.UUID;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class  CrimeActivity extends AbstractFragmentClass {

    public Fragment getFragment(){

        UUID crime_UUID = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        Fragment crimeFragment = CrimeFragment.newInstance(crime_UUID);
        return crimeFragment;
    }

}
