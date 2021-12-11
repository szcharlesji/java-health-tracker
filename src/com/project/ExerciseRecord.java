package com.project;

import java.time.LocalTime;

public class ExerciseRecord extends Record {

    private static double exerciseGoal, totalExerciseTime, numDays, avgSleepTime;
    //fields
    private double exerciseDuration;
    private LocalTime exerciseStart, exerciseEnd;

    //constructors
    public ExerciseRecord() {
    }

    public ExerciseRecord(LocalTime start, LocalTime end) {
        this.exerciseStart = start;
        this.exerciseEnd = end;
    }

    public static double getExerciseGoal() {
        return exerciseGoal;
    }

    public static double getTotalExerciseTime() {
        return totalExerciseTime;
    }

    public static double getNumDays() {
        return numDays;
    }

    public static double getAvgSleepTime() {
        return avgSleepTime;
    }

    //getters
    public double getExerciseDuration() {
        return exerciseDuration;
    }

    public LocalTime getExerciseStart() {
        return exerciseStart;
    }

    public LocalTime getExerciseEnd() {
        return exerciseEnd;
    }

    @Override
    public double getScore() {
        if (exerciseDuration >= 0) {
            // the score is based on the difference of actual duration and the goal
            // score is in percentile

            return exerciseDuration * 100 / exerciseGoal;
        } else {
            return 0;
        }
    }

    @Override
    public String getSuggestion() {
        return null;
    }
}
