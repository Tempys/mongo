package com.dubovskyi.mongo.domain;

public class Items
{
    private String name;

    private String optional;

    private String type;

    private Fields[] fields;

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getOptional ()
    {
        return optional;
    }

    public void setOptional (String optional)
    {
        this.optional = optional;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public Fields[] getFields ()
    {
        return fields;
    }

    public void setFields (Fields[] fields)
    {
        this.fields = fields;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", optional = "+optional+", type = "+type+", fields = "+fields+"]";
    }
}


