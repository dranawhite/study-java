package com.study.spring.aop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 前置增强
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
class PersonBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Spring Aop——前置增强");
    }
}
