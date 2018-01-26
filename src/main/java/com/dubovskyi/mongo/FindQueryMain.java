package com.dubovskyi.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.print.Doc;

public class FindQueryMain {

    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("m101");
        MongoCollection<Document> people = database.getCollection("funnynumbers");
        Document doc;
// xxxx
        doc = people.find().first();


        System.out.println(doc);
    }
}
