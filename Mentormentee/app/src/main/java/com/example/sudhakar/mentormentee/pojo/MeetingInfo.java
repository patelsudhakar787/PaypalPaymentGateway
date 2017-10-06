package com.example.sudhakar.mentormentee.pojo;

/**
 * Created by sudhakar on 4/21/17.
 */

public class MeetingInfo {
    String time;
    String pname;
    String venue;
    String purpose;

    public MeetingInfo(String time, String pname, String venue, String purpose) {
        this.time = time;
        this.pname = pname;
        this.venue = venue;
        this.purpose = purpose;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "MeetingInfo{" +
                "time='" + time + '\'' +
                ", pname='" + pname + '\'' +
                ", venue='" + venue + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
