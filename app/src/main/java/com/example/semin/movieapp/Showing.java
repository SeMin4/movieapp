package com.example.semin.movieapp;

import java.util.ArrayList;

public class Showing {
    private String theaterName;
    private String theaterDate;
    private String theater_Box_office;
    private String MovieName;
    public ArrayList<String> time = new ArrayList<>();

    public Showing(String theaterName, String theaterDate, String theater_Box_office, String movieName) {
        this.theaterName = theaterName;
        this.theaterDate = theaterDate;
        this.theater_Box_office = theater_Box_office;
        MovieName = movieName;
    }

    public Showing() {
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterDate() {
        return theaterDate;
    }

    public void setTheaterDate(String theaterDate) {
        this.theaterDate = theaterDate;
    }

    public String getTheater_Box_office() {
        return theater_Box_office;
    }

    public void setTheater_Box_office(String theater_Box_office) {
        this.theater_Box_office = theater_Box_office;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }
}
