package com.example.mygym101.model;

import java.util.ArrayList;

public class ExercisePlan {
    private int id;
    private String name;
    private ArrayList<ExerciseDays> exerciseDaysArrayList;

    public ExercisePlan(int id, String name, ArrayList<ExerciseDays> exerciseDaysArrayList) {
        this.id = id;
        this.name = name;
        this.exerciseDaysArrayList = exerciseDaysArrayList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ExerciseDays> getExerciseDaysArrayList() {
        return exerciseDaysArrayList;
    }

    public void setExerciseDaysArrayList(ArrayList<ExerciseDays> exerciseDaysArrayList) {
        this.exerciseDaysArrayList = exerciseDaysArrayList;
    }

    @Override
    public String toString() {
        return "ExercisePlan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exerciseDaysArrayList=" + exerciseDaysArrayList +
                '}';
    }
}
