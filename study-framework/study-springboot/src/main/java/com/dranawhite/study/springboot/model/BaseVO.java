package com.dranawhite.study.springboot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dranawhite
 * @version : BaseVO.java, v 0.1 2019-07-26 11:13 dranawhite Exp $$
 */
@Setter
@Getter
public class BaseVO implements Serializable {

    private static final long serialVersionUID = -8335787382278732424L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
