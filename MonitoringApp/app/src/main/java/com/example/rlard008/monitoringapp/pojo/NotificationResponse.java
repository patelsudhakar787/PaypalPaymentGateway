package com.example.rlard008.monitoringapp.pojo;

/**
 * Created by sudhakar on 4/13/17.
 */


public class NotificationResponse
{
    private String result;

    private String data;

    public String getResult ()
    {
        return result;
    }

    public void setResult (String result)
    {
        this.result = result;
    }

    public String getData ()
    {
        return data;
    }

    public void setData (String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [result = "+result+", data = "+data+"]";
    }
}
