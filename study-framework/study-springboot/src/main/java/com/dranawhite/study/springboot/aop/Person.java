package com.dranawhite.study.springboot.aop;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * @author dranawhite
 * @version : Person.java, v 0.1 2019-08-22 10:30 dranawhite Exp $$
 */
@Slf4j
@Component
public class Person implements IPerson {

    @Override
    public String say() {
        log.info("这个，我简单说几句啊!");
        return "Surprise, Mother Fucker";
    }
}
