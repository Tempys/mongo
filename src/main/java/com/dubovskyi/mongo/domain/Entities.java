package com.dubovskyi.mongo.domain;

import java.util.List;

public class Entities
{
    private Urls[] urls;

    private List<HashTag> hashtags;

    private String[] media;

    private List<UserMentions> user_mentions;

    public Urls[] getUrls ()
    {
        return urls;
    }

    public void setUrls (Urls[] urls)
    {
        this.urls = urls;
    }

    public List<HashTag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<HashTag> hashtags) {
        this.hashtags = hashtags;
    }

    public String[] getMedia ()
    {
        return media;
    }

    public void setMedia (String[] media)
    {
        this.media = media;
    }

    public List<UserMentions> getUser_mentions() {
        return user_mentions;
    }

    public void setUser_mentions(List<UserMentions> user_mentions) {
        this.user_mentions = user_mentions;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [urls = "+urls+", hashtags = "+hashtags+", media = "+media+", user_mentions = "+user_mentions+"]";
    }
}
