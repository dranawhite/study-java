package com.study.spring.beans.bean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order 注解，确定实现同一接口Bean加载的顺序
 *
 * @author dranawhite 2017/12/19
 * @version 1.0
 */
@Component
@Order(2)
public class Person implements IPerson {

    @Override
    public String sleep() {
        return "I am sleeping!";
    }
}
