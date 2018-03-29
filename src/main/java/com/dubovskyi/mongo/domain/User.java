package com.dubovskyi.mongo.domain;

public class User
{
    private String id;

    private String location;

    private String friends_count;

    private String verified;

    private String name;

    private String screen_name;

    private String statuses_count;

    private String followers_count;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getLocation ()
    {
        return location;
    }

    public void setLocation (String location)
    {
        this.location = location;
    }

    public String getFriends_count ()
    {
        return friends_count;
    }

    public void setFriends_count (String friends_count)
    {
        this.friends_count = friends_count;
    }

    public String getVerified ()
    {
        return verified;
    }

    public void setVerified (String verified)
    {
        this.verified = verified;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getScreen_name ()
    {
        return screen_name;
    }

    public void setScreen_name (String screen_name)
    {
        this.screen_name = screen_name;
    }

    public String getStatuses_count ()
    {
        return statuses_count;
    }

    public void setStatuses_count (String statuses_count)
    {
        this.statuses_count = statuses_count;
    }

    public String getFollowers_count ()
    {
        return followers_count;
    }

    public void setFollowers_count (String followers_count)
    {
        this.followers_count = followers_count;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", location = "+location+", friends_count = "+friends_count+", verified = "+verified+", name = "+name+", screen_name = "+screen_name+", statuses_count = "+statuses_count+", followers_count = "+followers_count+"]";
    }
}

