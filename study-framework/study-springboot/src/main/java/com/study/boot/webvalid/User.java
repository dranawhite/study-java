package com.study.boot.webvalid;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dranawhite
 * @version $Id: User.java, v 0.1 2019-01-29 18:09 dranawhite Exp $$
 */
@Setter
@Getter
public class User {

    @NotNull(groups = {InsertGroup.class}, message = "address不能为空")
    private Address address;

    @NotNull(groups = {InsertGroup.class}, message = "name不能为空")
    private String name;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
