package com.rlard.rlard008.stbi.Pojo;

/**
 * Created by rlard008 on 08-07-2017.
 */

public class DrawerData {

    int image;
    String itemname;



    public DrawerData(int image, String itemname) {
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
        return "DrawerData{" +
                "image=" + image +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}

