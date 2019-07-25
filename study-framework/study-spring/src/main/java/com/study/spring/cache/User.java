package com.study.spring.cache;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dranawhite 2017/12/27
 */
@Setter
@Getter
public class User implements Serializable {

    private static final long serialVersionUID = 5664877869926039599L;

    private int id;

    private String name;

    private int age;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public User clone() {
        try {
            return (User) BeanUtils.cloneBean(this);
        } catch (Exception e) {
            return null;
        }
    }
}
