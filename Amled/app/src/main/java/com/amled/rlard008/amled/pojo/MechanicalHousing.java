package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class MechanicalHousing {

    private String config;
    private String grade;

    public MechanicalHousing(String config, String grade) {
        this.config = config;
        this.grade = grade;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "MechanicalHousing{" +
                "config='" + config + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
