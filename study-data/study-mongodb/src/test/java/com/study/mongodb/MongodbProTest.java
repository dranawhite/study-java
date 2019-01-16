/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.image.FilteredImageSource;
import java.util.function.Consumer;

/**
 * MongoDb CURD
 *
 * @author dranawhite
 * @version $Id: MongodbProTest.java, v 0.1 2018-08-25 16:24 dranawhite Exp $$
 */
public class MongodbProTest {

    private static MongoDatabase mongoDatabase;

    @BeforeClass
    public static void init() {
        MongoClient client = new MongoClient("tencent.dranawhite.com");
        mongoDatabase = client.getDatabase("drana");
    }

    @Test
    @Ignore
    public void testListCollection() {
        MongoIterable<String> iterable = mongoDatabase.listCollectionNames();
        iterable.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    @Ignore
    public void testDropCollection() {
        MongoCollection coll = mongoDatabase.getCollection("person");
        coll.drop();
        MongoIterable<String> iterable = mongoDatabase.listCollectionNames();
        Assert.assertEquals(iterable.first(), null);
    }

    @Test
    @Ignore
    public void testCreateCollection() {
        mongoDatabase.createCollection("person");
    }

    @Test
    @Ignore
    public void testInsert() {
        MongoCollection coll = mongoDatabase.getCollection("person");
        coll.insertOne(new Document().append("name", "tom").append("age", 12).append("address", "NanJing"));
        coll.insertOne(new Document().append("name", "jerry").append("age", 18).append("address", "BeiJing"));
    }

    @Test
    @Ignore
    public void testFind() {
        MongoCollection<Document> coll = mongoDatabase.getCollection("person");
        MongoIterable<Document> iterable = coll.find(new Document("name", "tom"));
        iterable.forEach(new Consumer<Document>() {
            @Override
            public void accept(Document document) {
                System.out.println(document.toJson());
            }
        });
    }

    @Test
    @Ignore
    public void testUpdate() {
        MongoCollection<Document> coll = mongoDatabase.getCollection("person");
        coll.updateOne(Filters.eq("name", "tom"), new Document("$set", new Document("age", 45)));
    }

    @Test
    @Ignore
    public void testDelete() {
        MongoCollection<Document> coll = mongoDatabase.getCollection("person");
        coll.deleteOne(Filters.eq("name", "tom"));
    }
}
