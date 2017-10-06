package com.petrolpump.rlard008.petrolpump.pojo;

/**
 * Created by sudhakar on 6/6/17.
 */

public class ManagerLoginData {

    String adminname;
    String musername;
    String pumpname;
    String managercontact;
    String mpassword;


    public ManagerLoginData(String adminname, String musername, String pumpname, String managercontact, String mpassword) {
        this.adminname = adminname;
        this.musername = musername;
        this.pumpname = pumpname;
        this.managercontact = managercontact;
        this.mpassword = mpassword;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getPumpname() {
        return pumpname;
    }

    public void setPumpname(String pumpname) {
        this.pumpname = pumpname;
    }

    public String getManagercontact() {
        return managercontact;
    }

    public void setManagercontact(String managercontact) {
        this.managercontact = managercontact;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "ManagerLoginData{" +
                "adminname='" + adminname + '\'' +
                ", musername='" + musername + '\'' +
                ", pumpname='" + pumpname + '\'' +
                ", managercontact='" + managercontact + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
