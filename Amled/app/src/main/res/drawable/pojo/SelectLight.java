package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 5/1/17.
 */

public class SelectLight {
    String light;

    public SelectLight(String light) {
        this.light = light;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "SelectLight{" +
                "light='" + light + '\'' +
                '}';
    }
}
