package com.example.rlard008.monitoringapp.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sudhakar on 3/29/17.
 */


//pojo class for retrofit
public class MyPojo
{
    @SerializedName("feeds")
    private ArrayList<Feeds> feeds;
    @SerializedName("channel")
    private Channel channel;

    public ArrayList<Feeds> getFeeds ()
    {
        return feeds;
    }

    public void setFeeds (ArrayList<Feeds> feeds)
    {
        this.feeds = feeds;
    }

    public Channel getChannel ()
    {
        return channel;
    }

    public void setChannel (Channel channel)
    {
        this.channel = channel;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [feeds = "+feeds+", channel = "+channel+"]";
    }
}