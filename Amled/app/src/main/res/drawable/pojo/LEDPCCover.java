package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class LEDPCCover {

    String grade;
    float cost;

    public LEDPCCover(String grade, float cost) {
        this.grade = grade;
        this.cost = cost;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "LEDPCCover{" +
                "grade='" + grade + '\'' +
                ", cost=" + cost +
                '}';
    }
}
