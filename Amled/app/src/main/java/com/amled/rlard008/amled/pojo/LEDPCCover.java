package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class LEDPCCover {

    private String config;
    private String grade;

    public LEDPCCover(String config, String grade) {
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
        return "LEDPCCover{" +
                "config='" + config + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
