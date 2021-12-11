package com.project;

import java.time.Duration;
import java.time.LocalTime;


public class SleepRecord extends Record {
    private static double goal = 8;
    private static double index;
    private static String recommendation;
    private static int dayCount;
    private final LocalTime sleepStart;
    private final LocalTime sleepEnd;
    private Duration sleepTime;
    private long sleepTimeLong;
    private double sleepTimeDouble;
    private double score;

    public SleepRecord() {
        sleepStart = LocalTime.now();
        sleepEnd = LocalTime.now();
        sleepTimeDouble = 0;
        dayCount++;
    }

    public SleepRecord(String start, String end) {
        // Format of String: hr:min:sec
        // code to set default 0 sec
        start = start + ":00";
        end = end + ":00";
        sleepStart = LocalTime.parse(start);
        sleepEnd = LocalTime.parse(end);
        // return duration in sec
        sleepTime = Duration.between(sleepStart, sleepEnd);
        // convert duration to long
        sleepTimeLong = sleepTime.getSeconds();
        sleepTimeDouble = sleepTimeLong / 60 / 60;
        dayCount++;
    }

    public void setDuration() {
        // return duration in sec
        sleepTime = Duration.between(sleepStart, sleepEnd);
        // convert duration to long
        sleepTimeLong = sleepTime.getSeconds();
        sleepTimeDouble = sleepTimeLong / 60 / 60;
    }

    public String getStartTime() {
        return sleepStart.toString();
    }

    public String getEndTime() {
        return sleepEnd.toString();
    }

    public double getGoal() {
        return goal;
    }

    public static void setGoal(double i) {
        goal = i;
    }

    @Override
    public double getScore() {
        if (sleepTimeDouble >= 0) {
            // the score is based on the difference of actual duration and the goal
            // score is in percentile
            score = sleepTimeDouble * 100 / goal;
            return score;
        } else {
            score = 0;
            return score;
        }
    }

    @Override
    public String getSuggestion() {
        double score = this.getScore();

        if (score > 90)
            return "Good job! Keep it up";
        else if (score > 60)
            return "Get some more sleep in the future";
        else if (score > 30)
            return "Consistently sleeping this little isn't healthy. Sleep more!";
        else if (score >= 0)
            return "It's ridiculous";
        else
            return "Check your sleep data input";

    }
}