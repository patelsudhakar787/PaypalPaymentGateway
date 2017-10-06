package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class ChooseLEDOption {
    String configuration;
    float cost;

    public ChooseLEDOption(String configuration, float cost) {
        this.configuration = configuration;
        this.cost = cost;
    }


    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ChooseLEDOption{" +
                "configuration='" + configuration + '\'' +
                ", cost=" + cost +
                '}';
    }
}
