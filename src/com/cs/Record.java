package com.cs;

public abstract class Record {

    protected static double index;
    protected static String recommendation;
    protected static String dayCount;

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

    public static String getDayCount() {
        return dayCount;
    }

    public static void setDayCount(String dayCount) {
        Record.dayCount = dayCount;
    }
}

