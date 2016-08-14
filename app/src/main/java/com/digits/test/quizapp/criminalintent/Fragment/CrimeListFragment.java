package com.digits.test.quizapp.criminalintent.Fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),R.layout.simple_list_item_1,mcrime);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Crime crime = (Crime) getListAdapter().getItem(position);
        Log.d("CrimeListFragment :",crime.getTitle() + "was clicked");
    }
}
