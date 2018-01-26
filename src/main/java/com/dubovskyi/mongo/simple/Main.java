package com.dubovskyi.mongo.simple;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import static spark.Spark.get;

public class Main {

    public static void main(String[] args) {
        MongoClientOptions options = MongoClientOptions.builder().build();

        MongoClient client = new MongoClient(new ServerAddress("localhost"),options);

        MongoDatabase db = client.getDatabase("m101");
        MongoIterable<String> collections = db.listCollectionNames();

        MongoCursor<String> iterator = collections.iterator();

        while (iterator.hasNext()){ System.out.println(iterator.next()); }

        MongoCollection<Document> hw1 = db.getCollection("hw1");


      ///  db.createCollection("book");





    }
}
