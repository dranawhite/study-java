package com.study.tomcat.digester;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

import lombok.Getter;

/**
 * @author dranawhite
 * @version $Id: Employee.java, v 0.1 2019-03-09 15:20 dranawhite Exp $$
 */
public class Employee {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private ArrayList<Office> officeList = new ArrayList();

    public Employee() {
        System.out.println("Creating Employee!");
    }

    public void setFirstName(String firstName) {
        System.out.println("Setting FirstName: " + firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        System.out.println("Setting LastName : " + lastName);
        this.lastName = lastName;
    }

    public void addOffice(Office office) {
        System.out.println("Adding office to this employee");
        officeList.add(office);
    }

    public void printName() {
        System.out.println("My Name is " + firstName + " " + lastName);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
