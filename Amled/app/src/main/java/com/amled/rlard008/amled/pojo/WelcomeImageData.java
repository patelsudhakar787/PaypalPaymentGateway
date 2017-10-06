package com.amled.rlard008.amled.pojo;

/**
 * Created by sudhakar on 7/17/17.
 */

public class WelcomeImageData {
    private int imageid;
    private String imagename;

    public WelcomeImageData(int imageid, String imagename) {
        this.imageid = imageid;
        this.imagename = imagename;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    @Override
    public String toString() {
        return "WelcomeImageData{" +
                "imageid=" + imageid +
                ", imagename='" + imagename + '\'' +
                '}';
    }
}
