package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class LEDDriver {
    private String configuration;
    private String grade;

    public LEDDriver(String configuration, String grade) {
        this.configuration = configuration;
        this.grade = grade;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "LEDDriver{" +
                "configuration='" + configuration + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
