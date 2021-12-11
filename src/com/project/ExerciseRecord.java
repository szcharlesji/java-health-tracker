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
        double score = this.getScore();
        if (score > 90)
            return "Good job! Keep it up";
        else if (score > 60)
            return "Get some more exercise in the future";
        else if (score > 30)
            return "Consistently exercise this little isn't healthy. Exercise more!";
        else if (score >= 0)
            return "It's ridiculous";
        else
            return "Check your sleep data input";
    }
}
