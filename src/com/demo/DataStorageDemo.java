package com.demo;

import com.project.DataStorage;
import com.project.ExerciseRecord;
import com.project.Person;
import com.project.SleepRecord;

public class DataStorageDemo {
    public static void main(String[] args) {
        Person p1 = new Person("M", 150, 180, "Edward", 10);
        p1.addSleepRecord(new SleepRecord("12:00", "18:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "19:00"));
        p1.addSleepRecord(new SleepRecord("14:00", "15:00"));
        p1.addSleepRecord(new SleepRecord("18:00", "19:00"));

        p1.addExerciseRecord(new ExerciseRecord("14:00", "14:30"));
        p1.addExerciseRecord(new ExerciseRecord("14:00", "14:30"));
        p1.addExerciseRecord(new ExerciseRecord("14:00", "15:30"));
        DataStorage.saveRecord(p1);

//        Person p1 = DataStorage.loadRecord("C");
//        System.out.println(p1.getAge());
    }
}
