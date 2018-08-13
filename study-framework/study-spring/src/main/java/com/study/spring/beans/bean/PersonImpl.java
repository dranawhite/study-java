package com.study.spring.beans.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dranawhite 2017/12/19
 * @version 1.0
 */
@Component
@Order(1)
public class PersonImpl implements IPerson  {

    @Override
    public String sleep() {
        return "I do not want to sleep!";
    }
}
