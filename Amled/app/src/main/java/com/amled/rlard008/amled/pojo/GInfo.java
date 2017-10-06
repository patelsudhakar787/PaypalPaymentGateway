package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 5/17/17.
 */

public class GInfo {

    private String grade;
    private String config;

    public GInfo(String grade, String config) {
        this.grade = grade;
        this.config = config;
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
}
