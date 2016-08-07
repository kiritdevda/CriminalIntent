package com.digits.test.quizapp.criminalintent.Model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by kiritdevda on 07/08/16.
 */
public class CrimeLab {

    private static CrimeLab scrimelab;
    private ArrayList<Crime> scrimes;
    private Context mappContext;



    private CrimeLab(Context appContext){

        mappContext = appContext;
        scrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0); // Every other one
            scrimes.add(c);}

    }

    public static CrimeLab get(Context c){

    if(scrimelab == null){
        scrimelab = new CrimeLab(c.getApplicationContext());
    }
    return scrimelab;
    }

    public ArrayList<Crime> getcrimes(){
        return scrimes;
    }

    public Crime getCrime(UUID id){

        for(Crime c : scrimes){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
}
