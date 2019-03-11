package com.study.tomcat.digester;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;

/**
 *
 * @author dranawhite
 * @version $Id: Address.java, v 0.1 2019-03-09 15:24 dranawhite Exp $$
 */
public class Address {

    @Getter
    private String streetName;

    @Getter
    private String streetNumber;

    public Address() {
        System.out.println("Creating Address!");
    }

    public void setStreetName(String streetName) {
        System.out.println("Setting StreetName: " + streetName);
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        System.out.println("Setting StreetNumber: " + streetNumber);
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
