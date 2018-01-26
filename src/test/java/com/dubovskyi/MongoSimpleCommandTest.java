package com.dubovskyi;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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
    public void InsertData(){


        MongoCollection<Document> book = db.getCollection("book");

        Document catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2015)
                .append("title", "Engineering as a Service").append("author",
                        "David A. Kelly");


        book.insertOne(catalog);




        catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2016)
                .append("title", "Quintessential and Collaborative")
                .append("author", "Tom Haunert");
        book.insertOne(catalog);

        catalog = new Document("journal", "Oracle Magazine")
                .append("publisher", "Oracle Publishing")
                .append("edition", "November December 2013")
                .append("year", 2016)
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


    }



}
