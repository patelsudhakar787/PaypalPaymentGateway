package com.example.rlard008.hr_app.Pojo;

/**
 * Created by sudhakar on 5/8/17.
 */

public class RolesData {

    int roleicon;
    String rolename;

    public RolesData(int roleicon, String rolename) {
        this.roleicon = roleicon;
        this.rolename = rolename;
    }

    public int getRoleicon() {
        return roleicon;
    }

    public void setRoleicon(int roleicon) {
        this.roleicon = roleicon;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
