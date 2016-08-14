package com.digits.test.quizapp.criminalintent.Model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kiritdevda on 05/08/16.
 */
public class Crime {

    private UUID id;
    private String Title;
    private Boolean solved;
    private Date date;
    public String getTitle() {
        return Title;
    }

    public UUID getId() {
        return id;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Crime(){
        id = UUID.randomUUID();
        date = new Date();
     }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean IsSolved() {
        return solved;
    }

    public Crime setSolved(Boolean solved) {
        this.solved = solved;
        return this;
    }

    @Override
    public String toString() {
        return this.Title + "       " + this.solved;
    }
}
