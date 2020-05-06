package com.example.mygym101.model;

public class ExerciseData {

    private int id;
    private int weight;
    private int sets;
    private String unit;

    public ExerciseData(int id, int weight, int sets, String unit) {
        this.id = id;
        this.weight = weight;
        this.sets = sets;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ExerciseData{" +
                "id=" + id +
                ", weight=" + weight +
                ", sets=" + sets +
                ", unit='" + unit + '\'' +
                '}';
    }
}
