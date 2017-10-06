package com.rlard.tubelighttestingrack.pojo;

/**
 * Created by sudhakar on 6/29/17.
 */

public class LoginDetails {
    private String loginid;
    private String password;
    private String clientid;

    public LoginDetails(String loginid, String password, String clientid) {
        this.loginid = loginid;
        this.password = password;
        this.clientid = clientid;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return "LoginDetails{" +
                "loginid='" + loginid + '\'' +
                ", password='" + password + '\'' +
                ", clientid='" + clientid + '\'' +
                '}';
    }
}
