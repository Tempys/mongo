package com.dubovskyi.mongo.domain;

public class TwitterDto {
    private Schema schema;

    private Payload payload;

    public Schema getSchema ()
    {
        return schema;
    }

    public void setSchema (Schema schema)
    {
        this.schema = schema;
    }

    public Payload getPayload ()
    {
        return payload;
    }

    public void setPayload (Payload payload)
    {
        this.payload = payload;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [schema = "+schema+", payload = "+payload+"]";
    }
}
