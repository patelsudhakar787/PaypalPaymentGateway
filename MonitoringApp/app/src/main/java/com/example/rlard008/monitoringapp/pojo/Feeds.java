package com.example.rlard008.monitoringapp.pojo;


import com.google.gson.annotations.SerializedName;

/**
 * Created by sudhakar on 3/29/17.
 */

public class Feeds
{
    @SerializedName("created_at")
    private String created_at;
    @SerializedName("entry_id")
    private String entry_id;
    @SerializedName("field1")
    private String field1;
    @SerializedName("field2")
    private String field2;
    @SerializedName("field3")
    private String field3;
    @SerializedName("field4")
    private String field4;
    @SerializedName("field5")
    private String field5;
    @SerializedName("field6")
    private String field6;
    @SerializedName("field7")
    private String field7;
    @SerializedName("field8")
    private String field8;

    public Feeds(String created_at, String entry_id, String field1, String field2, String field3, String field4, String field5,String field6,String field7,String field8) {
        this.created_at = created_at;
        this.entry_id = entry_id;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.field6=field6;
        this.field7=field7;
        this.field8=field8;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    @Override
    public String toString() {
        return "Feeds{" +
                "created_at='" + created_at + '\'' +
                ", entry_id='" + entry_id + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5='" + field5 + '\'' +
                ", field6='" + field6 + '\'' +
                ", field7='" + field7 + '\'' +
                ", field8='" + field8 + '\'' +
                '}';
    }
}