package com.lhyla.databases;

/**
 * Created by RENT on 2017-07-04.
 */

public class MovieModel {
    private String filmID, filmName, filmBudget, filmProductionYear;

    public String getFilmID() {
        return filmID;
    }

    public void setFilmID(String filmID) {
        this.filmID = filmID;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmBudget() {
        return filmBudget;
    }

    public void setFilmBudget(String filmBudget) {
        this.filmBudget = filmBudget;
    }

    public String getFilmProductionYear() {
        return filmProductionYear;
    }

    public void setFilmProductionYear(String filmProductionYear) {
        this.filmProductionYear = filmProductionYear;
    }
}
