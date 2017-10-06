package com.petrolpump.rlard008.petrolpump;

/**
 * Created by sudhakar on 5/29/17.
 */

public class PumpData {
    String address;
    String cmoney;
    String cpayment;
    String preading;
    String dreading;

    public PumpData(String address, String cmoney) {
        this.address = address;
        this.cmoney = cmoney;
        }

    public PumpData(String cmoney, String cpayment, String preading, String dreading) {
        this.cmoney = cmoney;
        this.cpayment = cpayment;
        this.preading = preading;
        this.dreading = dreading;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCmoney() {
        return cmoney;
    }

    public void setCmoney(String cmoney) {
        this.cmoney = cmoney;
    }

    public String getCpayment() {
        return cpayment;
    }

    public void setCpayment(String cpayment) {
        this.cpayment = cpayment;
    }

    public String getPreading() {
        return preading;
    }

    public void setPreading(String preading) {
        this.preading = preading;
    }

    public String getDreading() {
        return dreading;
    }

    public void setDreading(String dreading) {
        this.dreading = dreading;
    }

    @Override
    public String toString() {
        return "PumpData{" +
                "address='" + address + '\'' +
                ", cmoney='" + cmoney + '\'' +
                ", cpayment='" + cpayment + '\'' +
                ", preading='" + preading + '\'' +
                ", dreading='" + dreading + '\'' +
                '}';
    }
}
;