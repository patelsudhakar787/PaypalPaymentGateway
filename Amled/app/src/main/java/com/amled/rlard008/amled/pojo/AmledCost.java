package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 7/25/17.
 */

public class AmledCost {
    private String light;
    private String grade;
    private int wattage;
    private double cost;

    public AmledCost(String light, String grade, int wattage, double cost) {
        this.light = light;
        this.grade = grade;
        this.wattage = wattage;
        this.cost = cost;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "AmledCost{" +
                "light='" + light + '\'' +
                ", grade='" + grade + '\'' +
                ", wattage=" + wattage +
                ", cost=" + cost +
                '}';
    }
}
