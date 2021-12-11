package com.project;

import java.time.Duration;
import java.time.LocalTime;


public class SleepRecord extends Record {
    private static double goal = 8;
    private static double index;
    private static String recommendation;
    private static int dayCount = 0;
    private static double totalSleepTime = 0;

    private final LocalTime sleepStart;
    private final LocalTime sleepEnd;
    private Duration sleepTime;
    private long sleepTimeLong;
    private double sleepTimeDouble;

    public SleepRecord() {
        sleepStart = LocalTime.now();
        sleepEnd = LocalTime.now();
        sleepTimeDouble = 0;
        dayCount++;
        updateTotal();
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
        updateTotal();
    }

    private void updateTotal() {
        dayCount++;
        totalSleepTime += sleepTimeDouble;
        index = totalSleepTime * 100 / dayCount / goal;

        if (index >= 90)
            recommendation = "Good job! Keep it up";
        else if (index > 60)
            recommendation = "Get some more sleep in the future";
        else if (index > 30)
            recommendation = "Consistently sleeping this little isn't healthy. Sleep more!";
        else
            recommendation = "It's ridiculous";
    }

    public void setDuration() {
        // return duration in sec
        sleepTime = Duration.between(sleepStart, sleepEnd);
        // convert duration to long
        sleepTimeLong = sleepTime.getSeconds();
        sleepTimeDouble = sleepTimeLong / 60 / 60;
        updateTotal();
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
        double score;
        if (sleepTimeDouble >= 0) {
            // the score is based on the difference of actual duration and the goal
            // score is in percentile
            score = sleepTimeDouble * 100 / goal;
        } else {
            score = 0;
        }
        return score;
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