package com.study.spring.aop.origin;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author dranawhite
 * @version : OriginProxyPro.java, v 0.1 2019-08-21 17:17 dranawhite Exp $$
 */
public class OriginAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("Before Method!");
    }
}
