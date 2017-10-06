package com.example.rlard008.hr_app.Pojo;

/**
 * Created by sudhakar on 5/11/17.
 */

public class SaveData {
    String taskname;
    String role;
    String starttime;
    String stoptime;
    int timetaken;
    String status;
    String checkbutton;
    String processstatus;
    String pausetime;
    String resumetime;
    String startcolor;
    String stopcolor;

    public SaveData(String taskname, String role, String starttime, String stoptime, int timetaken, String status) {
        this.taskname = taskname;
        this.role = role;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.timetaken = timetaken;
        this.status = status;
    }

    public SaveData(String taskname, String role, String starttime, String pausetime,String resumetime,String stoptime, int timetaken, String status, String checkbutton, String processstatus,String startcolor,String stopcolor) {
        this.taskname = taskname;
        this.role = role;
        this.starttime = starttime;
        this.pausetime=pausetime;
        this.resumetime=resumetime;
        this.stoptime = stoptime;
        this.timetaken = timetaken;
        this.status = status;
        this.checkbutton = checkbutton;
        this.processstatus = processstatus;
        this.startcolor=startcolor;
        this.stopcolor=stopcolor;
    }
    public SaveData(String taskname, String role, String starttime, String stoptime, int timetaken, String status, String checkbutton) {
        this.taskname = taskname;
        this.role = role;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.timetaken = timetaken;
        this.status = status;
        this.checkbutton = checkbutton;
    }

    public SaveData()
    {
    }

    public String getPausetime() {
        return pausetime;
    }

    public void setPausetime(String pausetime) {
        this.pausetime = pausetime;
    }

    public String getResumetime() {
        return resumetime;
    }

    public void setResumetime(String resumetime) {
        this.resumetime = resumetime;
    }

    public SaveData(String taskname, int timetaken)
    {
        this.taskname=taskname;
        this.timetaken=timetaken;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getStoptime() {
        return stoptime;
    }

    public void setStoptime(String stoptime) {
        this.stoptime = stoptime;
    }

    public int getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(int timetaken) {
        this.timetaken = timetaken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCheckbutton() {
        return checkbutton;
    }

    public void setCheckbutton(String checkbutton) {
        this.checkbutton = checkbutton;
    }

    public String getProcessstatus() {
        return processstatus;
    }

    public void setProcessstatus(String processstatus) {
        this.processstatus = processstatus;
    }

    public String getStartcolor() {
        return startcolor;
    }

    public void setStartcolor(String startcolor) {
        this.startcolor = startcolor;
    }

    public String getStopcolor() {
        return stopcolor;
    }

    public void setStopcolor(String stopcolor) {
        this.stopcolor = stopcolor;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "taskname='" + taskname + '\'' +
                ", role='" + role + '\'' +
                ", starttime='" + starttime + '\'' +
                ", stoptime='" + stoptime + '\'' +
                ", timetaken=" + timetaken +
                ", status='" + status + '\'' +
                ", checkbutton='" + checkbutton + '\'' +
                ", processstatus='" + processstatus + '\'' +
                ", pausetime='" + pausetime + '\'' +
                ", resumetime='" + resumetime + '\'' +
                ", startcolor='" + startcolor + '\'' +
                ", stopcolor='" + stopcolor + '\'' +
                '}';
    }
}
