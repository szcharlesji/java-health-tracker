package com.project;

public class HealthTrackerDemo {
    public static void main(String[] args) {

        // Instantiation
        Person p1 = new Person("M", 150, 180, "C", 10);

        // Attempts to add records
        p1.addSleepRecord(new SleepRecord("12:00", "18:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "19:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "15:00"));
        p1.addSleepRecord(new SleepRecord("18:00", "19:00"));

        // Setting goals
        SleepRecord.setGoal(4);

        // Getting Suggestions
        System.out.println(p1.getLastSleepSuggestion());
        System.out.println(SleepRecord.getRecommendation());
    }
}
