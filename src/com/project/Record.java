package com.project;

public abstract class Record {

    protected static double index;
    protected String recommendation;
    protected int dayCount;


    public abstract double getScore();

    public abstract String getSuggestion();
}