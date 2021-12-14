package com.project;

import java.util.Arrays;

public class HealthTrackerDemo {
    public static void main(String[] args) {

        // Instantiation
        Person p1 = new Person("M", 150, 180, "Cheng", 10);

        // Attempts to add records
        p1.addSleepRecord(new SleepRecord("12:00", "18:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "19:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "15:00"));
        p1.addSleepRecord(new SleepRecord("18:00", "19:00"));

        System.out.println(Arrays.deepToString(p1.toSleepTable()));

    }
}
