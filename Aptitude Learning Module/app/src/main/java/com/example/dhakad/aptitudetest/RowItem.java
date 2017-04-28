package com.example.dhakad.aptitudetest;

/**
 * Created by Dhakad on 1/26/2016.
 */
public class RowItem {

    private String item_name;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCatg() {
        return catg;
    }

    public void setCatg(String catg) {
        this.catg = catg;
    }

    private String level;
    private String catg;
    public RowItem(){}

}