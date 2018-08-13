package com.study.spring.aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 异常抛出增强
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
public class PersonThrowAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("------抛出异常------");
        System.out.println("异常类：" + target.getClass().getName());
        System.out.println("异常方法：" + method.getName());
        System.out.println("异常信息：" + ex.getMessage());
        System.out.println("-------------------");
    }

}
