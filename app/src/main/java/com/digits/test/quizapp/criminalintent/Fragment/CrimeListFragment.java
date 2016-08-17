package com.digits.test.quizapp.criminalintent.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.digits.test.quizapp.criminalintent.Activity.CrimeActivity;
import com.digits.test.quizapp.criminalintent.Model.Crime;
import com.digits.test.quizapp.criminalintent.Model.CrimeLab;
import com.digits.test.quizapp.criminalintent.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mcrime;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mcrime = CrimeLab.get(getActivity()).getcrimes();

        // ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),R.layout.simple_list_item_1,mcrime);
        CrimeAdapter adapter = new CrimeAdapter(mcrime);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Crime crime = (Crime)((CrimeAdapter)getListAdapter()).getItem(position);
        //since we have bifercated fragment , Activity and in different packages so we use FQDN to refer it
        Intent intent = new Intent(getActivity(), com.digits.test.quizapp.criminalintent.Activity.CrimeActivity.class);
        intent.putExtra(CrimeFragment.EXTRA_CRIME_ID,crime.getId());
        startActivity(intent);
        Log.d("CrimeListFragment :",crime.getTitle() + "was clicked");
    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class CrimeAdapter extends ArrayAdapter{

        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(),0,crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)
            {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);
            }

            Crime c=(Crime)getItem(position);
            TextView crime_name =(TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            crime_name.setText(c.getTitle());

            TextView crime_date = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            crime_date.setText(c.getDate().toString());

            CheckBox crime_solved = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            crime_solved.setChecked(c.IsSolved());

            return convertView;
        }
    }
}
