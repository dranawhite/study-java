package com.study.tomcat.digester;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;

/**
 * @author dranawhite
 * @version $Id: Office.java, v 0.1 2019-03-09 15:23 dranawhite Exp $$
 */
public class Office {

    @Getter
    private Address address;

    @Getter
    private String description;

    public Office() {
        System.out.println("Creating Office!");
    }

    public void setAddress(Address address) {
        System.out.println("Setting Address: " + address);
        this.address = address;
    }

    public void setDescription(String description) {
        System.out.println("Setting Description: " + description);
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
