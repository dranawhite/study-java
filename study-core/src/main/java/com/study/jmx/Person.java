/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.jmx;

/**
 *
 * @author liangyuquan
 * @version $Id: Person.java, v 0.1 2019-01-03 14:24 liangyuquan Exp $$
 */
public class Person implements PersonMBean {

    private int age;

    private String name;

    private String address;

    private int id;

    /**
     * @return the age
     */
    public int getAge() {
        System.out.println(age);
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {
        System.out.println(name);
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    @Override
    public String getAddress() {
        System.out.println(address);
        return address;
    }

    /**
     * @param address the address to set
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the id
     */
    public int getId() {
        System.out.println(id);
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
