/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.morphia;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

import org.bson.types.ObjectId;

import lombok.Data;

/**
 *
 * @author dranawhite
 * @version $Id: Person.java, v 0.1 2018-08-25 17:34 dranawhite Exp $$
 */
@Entity(value = "person")
@Data
public class Person {

    @Id
    private ObjectId id;

    private String name;

    private int age;

    private String address;

}
