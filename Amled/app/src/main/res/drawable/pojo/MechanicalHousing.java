package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class MechanicalHousing {
    String grade;
    String config;
    float cost;

    public MechanicalHousing(String grade, String config, float cost) {
        this.grade = grade;
        this.config = config;
        this.cost = cost;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MechanicalHousing{" +
                "grade='" + grade + '\'' +
                ", config='" + config + '\'' +
                ", cost=" + cost +
                '}';
    }
}
