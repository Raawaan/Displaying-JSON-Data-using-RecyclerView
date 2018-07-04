package com.example.rawanali.rawanfinal;

import java.io.Serializable;

/**
 * Created by Rawan Ali on 9/4/2017.
 */

public class image implements Serializable {
    private String imageUrl;
    private String name;
    private double rate;
    private int numOfVoters;
    private String date;
    private String description;
    private String backDropUrl;

    public String getBackDropUrl() {
        return backDropUrl;
    }

    public void setBackDropUrl(String backDropUrl) {
        this.backDropUrl = backDropUrl;
    }




    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setNumOfVoters(int numOfVoters) {
        this.numOfVoters = numOfVoters;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public int getNumOfVoters() {
        return numOfVoters;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
