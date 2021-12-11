package com.project;

public abstract class Record {

    protected static double index;
    protected static String recommendation;
    protected static int dayCount;

    public static double getIndex() {
        return index;
    }

    public static void setIndex(double index) {
        Record.index = index;
    }

    public static String getRecommendation() {
        return recommendation;
    }

    public static void setRecommendation(String recommendation) {
        Record.recommendation = recommendation;
    }

    public static int getDayCount() {
        return dayCount;
    }

    public static void setDayCount(int dayCount) {
        Record.dayCount = dayCount;
    }

    public abstract double getScore();

    public abstract String getSuggestion();
}