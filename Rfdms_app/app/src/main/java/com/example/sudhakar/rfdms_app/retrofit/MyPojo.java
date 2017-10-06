package com.example.sudhakar.rfdms_app.retrofit;

import java.util.ArrayList;

/**
 * Created by sudhakar on 5/16/17.
 */




public class MyPojo
{
    private ArrayList<Feeds> feeds;

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