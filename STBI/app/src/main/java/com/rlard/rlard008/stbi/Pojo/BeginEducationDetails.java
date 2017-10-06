package com.rlard.rlard008.stbi.Pojo;

/**
 * Created by rlard008 on 22-08-2017.
 */

public class BeginEducationDetails {

    String Name,Degree,Field,Grade,TimeFrom,TimeTo,Description;

    public BeginEducationDetails(String name) {
        Name = name;
    }

    public BeginEducationDetails(String name, String degree, String field, String timeFrom, String timeTo, String description) {
        Name = name;
        Degree = degree;
        Field = field;
        TimeFrom = timeFrom;
        TimeTo = timeTo;
        Description = description;
    }

    public BeginEducationDetails(String name, String degree, String field, String grade, String timeFrom, String timeTo, String description) {
        Name = name;
        Degree = degree;
        Field = field;
        Grade = grade;
        TimeFrom = timeFrom;
        TimeTo = timeTo;
        Description = description;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDegree() {
        return Degree;
    }

    public void setDegree(String degree) {
        Degree = degree;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getTimeFrom() {
        return TimeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        TimeFrom = timeFrom;
    }

    public String getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(String timeTo) {
        TimeTo = timeTo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "BeginEducationDetails{" +
                "Name='" + Name + '\'' +
                ", Degree='" + Degree + '\'' +
                ", Field='" + Field + '\'' +
                ", Grade='" + Grade + '\'' +
                ", TimeFrom='" + TimeFrom + '\'' +
                ", TimeTo='" + TimeTo + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
