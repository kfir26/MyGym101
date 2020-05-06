package com.example.mygym101.model;

import java.util.ArrayList;
import java.util.List;

public class ExerciseRoot {
    private List<Exercises> exercises;
    private List<ExercisePlan> exercisePlans;

    public ExerciseRoot(List<Exercises> exercises, List<ExercisePlan> exercisePlans) {
        this.exercises = exercises;
        this.exercisePlans = exercisePlans;
    }

    public List<Exercises> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercises> exercises) {
        this.exercises = exercises;
    }

    public List<ExercisePlan> getExercisePlans() {
        return exercisePlans;
    }

    public void setExercisePlans(List<ExercisePlan> exercisePlans) {
        this.exercisePlans = exercisePlans;
    }

    @Override
    public String toString() {
        return "ExerciseRoot{" +
                "exercises=" + exercises +
                ", exercisePlans=" + exercisePlans +
                '}';
    }
}
