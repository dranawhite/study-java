/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.boot.webvalid;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author liangyuquan
 * @version $Id: Address.java, v 0.1 2019-01-29 18:09 liangyuquan Exp $$
 */
@Setter
@Getter
public class Address {

    @NotNull(groups = {InsertGroup.class}, message = "name不能为空")
    private Integer name;

    @NotNull(groups = {InsertGroup.class}, message = "id不能为空")
    private Integer id;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
