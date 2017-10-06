package com.petrolpump.rlard008.petrolpump.pojo;

/**
 * Created by sudhakar on 6/6/17.
 */

public class AdminLoginData {
    String adminname;
    String admincontact;
    String adminpassword;
    String pump1name;
    String pump2name;
    String pump3name;
    String pump4name;
    String pump5name;
    String pump6name;
    String pump7name;


    public AdminLoginData(String adminname, String admincontact, String adminpassword, String pump1name, String pump2name, String pump3name, String pump4name, String pump5name, String pump6name, String pump7name) {
        this.adminname = adminname;
        this.admincontact = admincontact;
        this.adminpassword = adminpassword;
        this.pump1name = pump1name;
        this.pump2name = pump2name;
        this.pump3name = pump3name;
        this.pump4name = pump4name;
        this.pump5name = pump5name;
        this.pump6name = pump6name;
        this.pump7name = pump7name;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdmincontact() {
        return admincontact;
    }

    public void setAdmincontact(String admincontact) {
        this.admincontact = admincontact;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public String getPump1name() {
        return pump1name;
    }

    public void setPump1name(String pump1name) {
        this.pump1name = pump1name;
    }

    public String getPump2name() {
        return pump2name;
    }

    public void setPump2name(String pump2name) {
        this.pump2name = pump2name;
    }

    public String getPump3name() {
        return pump3name;
    }

    public void setPump3name(String pump3name) {
        this.pump3name = pump3name;
    }

    public String getPump4name() {
        return pump4name;
    }

    public void setPump4name(String pump4name) {
        this.pump4name = pump4name;
    }

    public String getPump5name() {
        return pump5name;
    }

    public void setPump5name(String pump5name) {
        this.pump5name = pump5name;
    }

    public String getPump6name() {
        return pump6name;
    }

    public void setPump6name(String pump6name) {
        this.pump6name = pump6name;
    }

    public String getPump7name() {
        return pump7name;
    }

    public void setPump7name(String pump7name) {
        this.pump7name = pump7name;
    }


    @Override
    public String toString() {
        return "AdminLoginData{" +
                "adminname='" + adminname + '\'' +
                ", admincontact='" + admincontact + '\'' +
                ", adminpassword='" + adminpassword + '\'' +
                ", pump1name='" + pump1name + '\'' +
                ", pump2name='" + pump2name + '\'' +
                ", pump3name='" + pump3name + '\'' +
                ", pump4name='" + pump4name + '\'' +
                ", pump5name='" + pump5name + '\'' +
                ", pump6name='" + pump6name + '\'' +
                ", pump7name='" + pump7name + '\'' +
                '}';
    }
}
