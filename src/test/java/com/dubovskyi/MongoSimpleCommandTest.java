package com.dubovskyi;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static java.util.OptionalInt.of;

public class MongoSimpleCommandTest {


    private  MongoDatabase db;

    @Before
    public void init(){

        MongoClient client = new MongoClient(new ServerAddress("localhost"));
        this.db = client.getDatabase("m101");
    }

    @Test
    @Ignore
    public void createCollection(){

        MongoIterable<String> collections = db.listCollectionNames();
        MongoCursor<String> iterator = collections.iterator();

        while (iterator.hasNext()){ System.out.println(iterator.next()); }

        MongoCollection<Document> hw1 = db.getCollection("hw1");

        db.createCollection("book");

    }

    @Test
    //@Ignore
    public void insertData(){


        MongoCollection<Document> book = db.getCollection("book");

        Document catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2015)
                .append("income",900)
                .append("title", "Engineering as a Service").append("author",
                        "David A. Kelly");


        book.insertOne(catalog);

        catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2016)
                .append("income",1000)
                .append("title", "Quintessential and Collaborative")
                .append("author", "Bensom");
        book.insertOne(catalog);


        catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2016)
                .append("income",500)
                .append("title", "Quintessential and Collaborative")
                .append("author", "Tom Haunert");
        book.insertOne(catalog);

        catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2016)
                .append("income",100)
                .append("title", "Quintessential and Collaborative")
                .append("author", "Andrian");
        book.insertOne(catalog);


    }

    @Test
    public void dropAll(){
        MongoCollection<Document> book = db.getCollection("book");
        book.drop();
    }

    @Test
    public void findData(){
        dropAll();
        insertData();


        MongoCollection<Document> book = db.getCollection("book");


       Document document = book.find().first();
        int a = document.getInteger("year");
        Assert.assertEquals(2015, a);

        Bson filter = new Document("author","Andrian");
        Assert.assertEquals(1,book.count(filter));

        Bson filter1 = and(Filters.eq("year",2016),gt("income",499));
        book.find(filter1).forEach((Consumer<? super Document>) i -> System.out.println(i));

        Assert.assertEquals(2,book.count(filter1));





    }



}
