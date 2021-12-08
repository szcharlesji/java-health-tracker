package com.cs;

import java.util.ArrayList;

public class Person {

    private String gender;
    private double weight;
    private double height;
    private String name;
    private int age;

    private ArrayList<EatingRecord> diet;
    private ArrayList<SleepRecord> sleep;
    private ArrayList<ExerciseRecord> exercise;

    public Person() {
    }

    public Person(String gender, double weight, double height, String name, int age) {
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.name = name;
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setDiet(ArrayList<EatingRecord> diet) {
        this.diet = diet;
    }

    public ArrayList<SleepRecord> getSleep() {
        return sleep;
    }

    public void setSleep(ArrayList<SleepRecord> sleep) {
        this.sleep = sleep;
    }

    public ArrayList<ExerciseRecord> getExercise() {
        return exercise;
    }

    public void setExercise(ArrayList<ExerciseRecord> exercise) {
        this.exercise = exercise;
    }

}
