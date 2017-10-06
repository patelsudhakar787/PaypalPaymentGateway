package com.rlard.smartenergymeter.pojo;

/**
 * Created by sudhakar on 6/29/17.
 */

public class MachineDetails {
    private String clientid;
    private String machineid;

    public MachineDetails(String clientid, String machineid) {
        this.clientid = clientid;
        this.machineid = machineid;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getMachineid() {
        return machineid;
    }

    public void setMachineid(String machineid) {
        this.machineid = machineid;
    }

    @Override
    public String toString() {
        return "MachineDetails{" +
                "clientid='" + clientid + '\'' +
                ", machineid='" + machineid + '\'' +
                '}';
    }
}
