package com.project;

public class SleepRecord extends Record {
    public SleepRecord() {
    }

    public SleepRecord(String startTime, String endTime) {
        super(startTime, endTime);
    }

//
//    @Override
//    public String getSuggestion() {
//        double score = this.getScore();
//
//        if (score > 90)
//            return "Good job! Keep it up";
//        else if (score > 60)
//            return "Get some more sleep in the future";
//        else if (score > 30)
//            return "Consistently sleeping this little isn't healthy. Sleep more!";
//        else if (score >= 0)
//            return "It's ridiculous";
//        else
//            return "Check your sleep data input";
//
//    }
}