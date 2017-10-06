package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 4/28/17.
 */

public class Drawerdata {
    int image;
    String itemname;

    public Drawerdata(int image, String itemname) {
        this.image = image;
        this.itemname = itemname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "Drawerdata{" +
                "image=" + image +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}
