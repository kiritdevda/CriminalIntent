package com.digits.test.quizapp.criminalintent.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.digits.test.quizapp.criminalintent.Fragment.CrimeFragment;
import com.digits.test.quizapp.criminalintent.Fragment.CrimeListFragment;
import com.digits.test.quizapp.criminalintent.Model.Crime;
import com.digits.test.quizapp.criminalintent.Model.CrimeLab;
import com.digits.test.quizapp.criminalintent.R;

import java.util.ArrayList;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CrimePagerActivity extends FragmentActivity {

    private ViewPager viewpager;
    private ArrayList<Crime> mcrime;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewpager = new ViewPager(this);
        viewpager.setId(R.id.viewPager);
        setContentView(viewpager);

        mcrime=CrimeLab.get(this).getcrimes();
        FragmentManager fm = getSupportFragmentManager();
        viewpager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
               return new CrimeFragment().newInstance(mcrime.get(position).getId());
            }

            @Override
            public int getCount() {
                return mcrime.size();
            }
        });
        UUID extra_crime = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for(int i =0 ; i < mcrime.size() ; i++){
            if(mcrime.get(i).getId().equals(extra_crime)){
                viewpager.setCurrentItem(i);
                break;
            }
        }
    }

    public CrimePagerActivity() {
        // Required empty public constructor
    }




}
