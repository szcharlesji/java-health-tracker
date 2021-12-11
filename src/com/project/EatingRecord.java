package com.project;

import java.util.Arrays;

public class EatingRecord extends Record {

    private static double goal = 2000;
    private double[] calories = new double[3];
    //    private LocalTime[] mealTimes = new LocalTime[3];
    private double score;

    public EatingRecord() {
    }

    public EatingRecord(double[] calories) {
        this.calories = calories;
//        this.mealTimes = mealTimes;
    }

    public static double getGoal() {
        return goal;
    }

    public static void setGoal(double goal) {
        EatingRecord.goal = goal;
    }

    public double[] getCalories() {
        return calories;
    }

    public void setCalories(double[] calories) {
        this.calories = calories;
    }

    @Override
    public double getScore() {
        double sum = Arrays.stream(calories).sum();
        if (sum >= 0) {
            // the score is based on the difference of actual duration and the goal
            // score is in percentile
            score = sum * 100 / goal;
            return score;
        } else {
            score = 0;
            return score;
        }
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String getSuggestion() {
        double score = this.getScore();

        if (score > 140)
            return "You're eating too much";
        else if (score > 100)
            return "You're eating a bit more than normal";
        else if (score > 70)
            return "You're eating a bit less than normal";
        else if (score >= 40)
            return "You're eating too little";
        else
            return "That's ridiculous";
    }
}
