package com.digits.test.quizapp.criminalintent.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.digits.test.quizapp.criminalintent.Model.Crime;
import com.digits.test.quizapp.criminalintent.Model.CrimeLab;
import com.digits.test.quizapp.criminalintent.R;

import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {

    private Crime mcrime;
    private EditText titleField;
    private Button date_button;
    private CheckBox solved;
    public static final String EXTRA_CRIME_ID="com.digits.test.quizapp.criminalintent.Fragment.CrimeFragment.crime_id";
    public CrimeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle SavedInstanceState){
    super.onCreate(SavedInstanceState);
        //mcrime = new Crime();
        UUID crime = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        mcrime = CrimeLab.get(getActivity()).getCrime(crime);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crime_layout,parent, false);
        titleField = (EditText) v.findViewById(R.id.crime_title);
        titleField.setText(mcrime.getTitle());
        titleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mcrime.setTitle(charSequence.toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        date_button = (Button) v.findViewById(R.id.date);
        date_button.setText(mcrime.getDate().toString());
        date_button.setEnabled(Boolean.FALSE);

        solved=(CheckBox) v.findViewById(R.id.solved);
        solved.setChecked(mcrime.IsSolved());
        solved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mcrime.setSolved(b);
            }
        });


        return v;
    }

}
