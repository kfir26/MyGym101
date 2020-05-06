package com.example.mygym101.model;

import java.util.List;

public class ExerciseDays {

    private int id;
    private String name;
    private List<ExerciseData> exerciseDataList;

    public ExerciseDays(int id, String name, List<ExerciseData> exerciseDataList) {
        this.id = id;
        this.name = name;
        this.exerciseDataList = exerciseDataList;
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

    public List<ExerciseData> getExerciseDataList() {
        return exerciseDataList;
    }

    public void setExerciseDataList(List<ExerciseData> exerciseDataList) {
        this.exerciseDataList = exerciseDataList;
    }

    @Override
    public String toString() {
        return "ExerciseDays{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exerciseDataList=" + exerciseDataList +
                '}';
    }
}
