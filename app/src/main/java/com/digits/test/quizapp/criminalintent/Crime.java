package com.digits.test.quizapp.criminalintent;

import java.util.UUID;

/**
 * Created by kiritdevda on 05/08/16.
 */
public class Crime {

    private UUID id;
    private String Title;

    public String getTitle() {
        return Title;
    }

    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    Crime(){
         id = UUID.randomUUID();

     }
}
