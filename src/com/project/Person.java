package com.project;

import java.util.ArrayList;

public class Person {

    // Records
    private final ArrayList<SleepRecord> sleep = new ArrayList<>();
    private final ArrayList<ExerciseRecord> exercise = new ArrayList<>();

    // Basic Info
    private String gender, name;
    private double weight, height;
    private int age;

    // Recommendation
    // Sleep
    private double sleepGoal, sleepIndex;
    private String sleepRecommendation;
    private int sleepDayCount;
    // Exercise
    private double exerciseGoal, exerciseIndex;
    private String exerciseRecommendation;
    private int exerciseDayCount;

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

    public Person(String gender, String name, double weight, double height, int age, double sleepGoal, double exerciseGoal) {
        this.gender = gender;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sleepGoal = sleepGoal;
        this.exerciseGoal = exerciseGoal;
    }

    // Getters
    public String getGender() {
        return gender;
    }

    public double getTotalSleepTime() {
        double totalSleepTime = 0.0;

        for (int i = 0; i < sleep.size(); i++) {
            totalSleepTime += sleep.get(i).getDuration();
        }

        return totalSleepTime;
    }

    public double getTotalExerciseTime() {
        double totalExerciseTime = 0.0;

        for (int i = 0; i < exercise.size(); i++) {
            totalExerciseTime += exercise.get(i).getDuration();
        }

        return totalExerciseTime;
    }

    public String getSleepRecommendation() {
        return sleepRecommendation;
    }

    public String getExerciseRecommendation() {
        return exerciseRecommendation;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public double getSleepGoal() {
        return sleepGoal;
    }

    public double getExerciseGoal() {
        return exerciseGoal;
    }

    // Setters
    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSleepGoal(double sleepGoal) {
        this.sleepGoal = sleepGoal;
    }

    public void setExerciseGoal(double exerciseGoal) {
        this.exerciseGoal = exerciseGoal;
    }

    // Record Getter
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

    public void addExerciseRecord(ExerciseRecord r) {
        this.exercise.add(r);
    }


    private void updateSleepTotal() {
        sleepDayCount++;
        sleepIndex = getTotalSleepTime() * 100 / sleepDayCount / sleepGoal;

        if (sleepIndex >= 90)
            sleepRecommendation = "Good job! Keep it up";
        else if (sleepIndex > 60)
            sleepRecommendation = "Get some more sleep in the future";
        else if (sleepIndex > 30)
            sleepRecommendation = "Consistently sleeping this little isn't healthy. Sleep more!";
        else
            sleepRecommendation = "Yikes";
    }

    private void updateExerciseTotal() {
        exerciseDayCount++;
        exerciseIndex = getTotalExerciseTime() * 100 / exerciseDayCount / exerciseGoal;

        if (exerciseIndex >= 90)
            exerciseRecommendation = "Good job! Keep it up";
        else if (exerciseIndex > 60)
            exerciseRecommendation = "Try to exercise more in the future";
        else if (exerciseIndex > 30)
            exerciseRecommendation = "You're not being active enough. Get some exercise soon!";
        else
            exerciseRecommendation = "Yikes";
    }
}
