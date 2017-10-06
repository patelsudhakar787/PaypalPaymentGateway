package com.rlard.rlard008.stbi.Pojo;

/**
 * Created by rlard008 on 08-07-2017.
 */

public class IdeaPojo {

    String ideaId;
    String titleofidea;
    String date;
    String status;
    String myservices;


    public IdeaPojo(String ideaId, String titleofidea, String date, String status, String myservices) {
        this.ideaId = ideaId;
        this.titleofidea = titleofidea;
        this.date = date;
        this.status = status;
        this.myservices = myservices;
    }


    public String getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(String ideaId) {
        this.ideaId = ideaId;
    }

    public String getTitleofidea() {
        return titleofidea;
    }

    public void setTitleofidea(String titleofidea) {
        this.titleofidea = titleofidea;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMyservices() {
        return myservices;
    }

    public void setMyservices(String myservices) {
        this.myservices = myservices;
    }

    @Override
    public String toString() {
        return "IdeaPojo{" +
                "ideaId='" + ideaId + '\'' +
                ", titleofidea='" + titleofidea + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", myservices='" + myservices + '\'' +
                '}';
    }
}
