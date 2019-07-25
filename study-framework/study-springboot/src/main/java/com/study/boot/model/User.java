package com.study.boot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dranawhite
 * @version : User.java, v 0.1 2019-07-25 16:38 dranawhite Exp $$
 */
@Setter
@Getter
public class User {

    private int id;

    private String name;

    private String address;

    private int age;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
