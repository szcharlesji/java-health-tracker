package com.project;

import java.util.ArrayList;

public class Person {

    private final ArrayList<EatingRecord> diet = new ArrayList<>();
    private final ArrayList<SleepRecord> sleep = new ArrayList<>();
    private final ArrayList<ExerciseRecord> exercise = new ArrayList<>();
    // Fields
    private String gender, name;
    private double weight, height;
    private int age;

    // Constructors
    public Person() {
    }

    public Person(String gender, double weight, double height, String name, int age) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getGender() {
        return gender;
    }

    // Setters
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<EatingRecord> getDiet() {
        return diet;
    }

    public ArrayList<SleepRecord> getSleep() {
        return sleep;
    }

    public ArrayList<ExerciseRecord> getExercise() {
        return exercise;
    }

    // Add records
    public void addSleepRecord(SleepRecord r) {
        this.sleep.add(r);
    }

    public void addEatingRecord(EatingRecord r) {
        this.diet.add(r);
    }

    public void addExerciseRecord(ExerciseRecord r) {
        this.exercise.add(r);
    }

    // Last Suggestion
    public String getLastSleepSuggestion() {
        return this.getSleep().get(this.getSleep().size() - 1).getSuggestion();
    }

}
