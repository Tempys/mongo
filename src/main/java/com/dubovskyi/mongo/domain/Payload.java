package com.dubovskyi.mongo.domain;

public class Payload
{
    private String id;

    private String is_retweet;

    private String text;

    private String created_at;

    private Entities entities;

    private String lang;

    private User user;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_retweet ()
    {
        return is_retweet;
    }

    public void setIs_retweet (String is_retweet)
    {
        this.is_retweet = is_retweet;
    }

    public String getText ()
    {
        return text;
    }

    public void setText (String text)
    {
        this.text = text;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public Entities getEntities ()
    {
        return entities;
    }

    public void setEntities (Entities entities)
    {
        this.entities = entities;
    }

    public String getLang ()
    {
        return lang;
    }

    public void setLang (String lang)
    {
        this.lang = lang;
    }

    public User getUser ()
    {
        return user;
    }

    public void setUser (User user)
    {
        this.user = user;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", is_retweet = "+is_retweet+", text = "+text+", created_at = "+created_at+", entities = "+entities+", lang = "+lang+", user = "+user+"]";
    }
}
