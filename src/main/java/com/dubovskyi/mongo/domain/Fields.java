package com.dubovskyi.mongo.domain;



public class Fields
{
    private String field;

    private String optional;

    private String type;

    public String getField ()
    {
        return field;
    }

    public void setField (String field)
    {
        this.field = field;
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

    @Override
    public String toString()
    {
        return "ClassPojo [field = "+field+", optional = "+optional+", type = "+type+"]";
    }
}
