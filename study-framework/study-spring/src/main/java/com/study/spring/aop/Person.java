package com.study.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
class Person {

    public void say() {
        System.out.println("I'm Talking!");
    }

    public void sayNull() {
        System.out.println("I'm Talking Null!");
        throw new NullPointerException("我是一个异常！");
    }

    public void sayGoodMorning() {
        System.out.println("Good Morning!");
    }

    public void sayGoodEvening() {
        System.out.println("Good Evening!");
    }

    @Tag
    public void sayTag() {
        System.out.println("I'm A Tag!");
    }

}
