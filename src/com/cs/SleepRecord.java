package com.cs;

import java.time.*;

public class SleepRecord extends Record {

    public static void main(String[] args) {

    }

    //fields
    private double sleepDuration;
    private LocalTime sleepStart, sleepEnd;
    private static double sleepGoal, totalSleepTime, numDays, avgSleepTime;

    //constructors
    public SleepRecord() {}

    public SleepRecord(LocalTime start, LocalTime end) {
        this.sleepStart = start;
        this.sleepEnd = end;
        //Calculate sleeptime & assign to this.sleepTime
    }

    //Getters
    public double getSleepDuration() { return sleepDuration; }

    public LocalTime getSleepStart() { return sleepStart; }

    public LocalTime getSleepEnd() { return sleepEnd; }

    public static double getSleepGoal() { return sleepGoal; }

    public static double getTotalSleepTime() { return totalSleepTime; }

    public static double getNumDays() { return numDays; }

    public static double getAvgSleepTime() { return avgSleepTime; }

    public double getSleepScore() {
        //Do algorithm
        return 0;
    }



}
