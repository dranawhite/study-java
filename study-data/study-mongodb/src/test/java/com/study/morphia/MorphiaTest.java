/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.morphia;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import com.mongodb.MongoClient;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author dranawhite
 * @version $Id: MorphiaTest.java, v 0.1 2018-08-25 17:36 dranawhite Exp $$
 */
public class MorphiaTest {

    private static Datastore datastore;

    @BeforeClass
    public static void init() {
        Morphia morphia = new Morphia();
        datastore = morphia.createDatastore(new MongoClient("tencent.dranawhite.com"), "drana");
    }

    @Test
    @Ignore
    public void testSave() {
        Person pn = new Person();
        pn.setName("Air");
        pn.setAge(12);
        pn.setAddress("以色列");
        datastore.save(pn);
    }

    @Test
    @Ignore
    public void testDelete() {
        Query<Person> query = datastore.find(Person.class);
        query.criteria("name").equal("Lony");
        datastore.delete(query);
    }

    @Test
    @Ignore
    public void testQuery() {
        Query<Person> query = datastore.find(Person.class);
        System.out.println(query.asList());

        query.criteria("name").equal("Air");
        Person result = query.get();
        System.out.println(result);
        System.out.println(query.asList());
        System.out.println(query.countAll());
    }

    @Ignore
    @Test
    public void testUpdate() {
        Query query = datastore.createQuery(Person.class);
        query.criteria("name").equal("Jerry");
        UpdateOperations<Person> operas = datastore.createUpdateOperations(Person.class);
        operas.set("name", "Lony");
        datastore.update(query, operas);
    }

}
