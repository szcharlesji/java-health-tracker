package com.project;

public class DataStorageDemo {
    public static void main(String[] args) {
//        Person p1 = new Person("M", 150, 180, "C", 10);
//        p1.addSleepRecord(new SleepRecord("12:00", "18:00"));
//        p1.addSleepRecord(new SleepRecord("14:00", "19:00"));
//        p1.addSleepRecord(new SleepRecord("14:00", "15:00"));
//        p1.addSleepRecord(new SleepRecord("18:00", "19:00"));
//
//        DataStorage.saveRecord(p1);

        Person p1 = DataStorage.loadRecord("C");
        System.out.println(p1.getAge());
    }
}
