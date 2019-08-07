package com.study.pattern;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * @author dranawhite
 * @version : User.java, v 0.1 2019-08-07 11:21 dranawhite Exp $$
 */
@Setter
@Getter
public class User {

    private int id;

    private String name;

    private String address;

    private long phone;

    private String mail;

    private RoleEnum roleEnum;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
