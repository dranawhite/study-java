package com.dranawhite.study.springboot.kafka;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dranawhite
 * @version : Message.java, v 0.1 2019-09-05 11:20 dranawhite Exp $$
 */
@Setter
@Getter
public class Message {

    private String id;

    private String message;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
