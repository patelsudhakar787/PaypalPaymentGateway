package rlard.hr.rlard008.hr_app.Pojo;

/**
 * Created by sudhakar on 9/5/17.
 */

public class Pojo {

    private String data;
    private String role;
    private String task;
    private String start_time;
    private String stop_time;
    private String total_time;
    private String status;
    private String note;
    private String companyname;


    public Pojo(String data, String role, String task, String start_time, String stop_time, String total_time, String status, String note, String companyname) {
        this.data = data;
        this.role = role;
        this.task = task;
        this.start_time = start_time;
        this.stop_time = stop_time;
        this.total_time = total_time;
        this.status = status;
        this.note = note;
        this.companyname = companyname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getStop_time() {
        return stop_time;
    }

    public void setStop_time(String stop_time) {
        this.stop_time = stop_time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "data='" + data + '\'' +
                ", role='" + role + '\'' +
                ", task='" + task + '\'' +
                ", start_time='" + start_time + '\'' +
                ", stop_time='" + stop_time + '\'' +
                ", total_time='" + total_time + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }
}
