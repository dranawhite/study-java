package com.study.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author liangyq 2018/1/17
 */
@Aspect
@Component
public class ServiceLog {

    @Around("execution(* SimpleService.doService(..))")
    public Object printLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("====进入Service方法====");
        Object result = pjp.proceed();
        System.out.println("====步出Service方法====");
        return result;
    }

}
