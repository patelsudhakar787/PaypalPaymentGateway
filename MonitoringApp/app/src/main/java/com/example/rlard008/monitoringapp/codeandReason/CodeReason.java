package com.example.rlard008.monitoringapp.codeandReason;

/**
 * Created by sudhakar on 3/31/17.
 */

//Pojo class for Rejection and Downtime Code,Reason
public class CodeReason {

    String code;
    String reason;

    public CodeReason(String code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "CodeReason{" +
                "code='" + code + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
