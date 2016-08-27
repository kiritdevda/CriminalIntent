package com.digits.test.quizapp.criminalintent.Fragment;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {

    private Crime mcrime;
    private EditText titleField;
    private Button date_button;
    private CheckBox solved;
    private static final String DIALOG_DATE = "date";
    public static final String EXTRA_CRIME_ID="com.digits.test.quizapp.criminalintent.Fragment.CrimeFragment.crime_id";
    public CrimeFragment() {
        // Required empty public constructor
    }

    public static CrimeFragment newInstance(UUID crime_UUID) {
        
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID,crime_UUID);

        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle SavedInstanceState){
    super.onCreate(SavedInstanceState);
        //mcrime = new Crime();

        //UUID crimeId = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);

        /*
        Above line been commented out as it make fragment rigid to use activity's intenet rather then activity handle it
        Now the Fragment doesn't need to worry about the intent and hence retains it's flexibility
        */

        UUID crime = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
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
        //date_button.setEnabled(Boolean.FALSE);
        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mcrime.getDate());
                dialog.show(fm,DIALOG_DATE);}
        });

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
