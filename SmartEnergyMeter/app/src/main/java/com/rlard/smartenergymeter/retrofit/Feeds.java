package com.rlard.smartenergymeter.retrofit;

/**
 * Created by sudhakar on 5/16/17.
 */

public class Feeds
{
    private String entry_id;
    private String created_at;
    private String field1;
    private String field2;
    private String field3;
    private String field4;

    public Feeds(String entry_id, String created_at, String field1, String field2, String field3, String field4) {
        this.entry_id = entry_id;
        this.created_at = created_at;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public String getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(String entry_id) {
        this.entry_id = entry_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
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


    @Override
    public String toString() {
        return "Feeds{" +
                "entry_id='" + entry_id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                '}';
    }
}