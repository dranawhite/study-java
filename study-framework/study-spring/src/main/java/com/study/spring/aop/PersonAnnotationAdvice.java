package com.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 作用于注解上的通知
 *
 * @author dranawhite 2017/8/18
 */
@Aspect
@Component
class PersonAnnotationAdvice {

    @Around("@annotation(com.dranawhite.spring.aop.Tag)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        before();
        Object result = joinPoint.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Spring Aspect-前置通知");
    }

    private void after() {
        System.out.println("Spring Aspect-后置通知");
    }

}
