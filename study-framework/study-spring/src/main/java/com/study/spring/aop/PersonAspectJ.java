package com.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 基于Aspectj的切面
 * <pre>
 *     @Aspect注解表明该类是一个Advisor
 * </pre>
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
@Aspect
class PersonAspectJ {

    /**
     * <pre>
     *     JoinPoint称为连接点，通过该对象可以获取方法的任何信息
     *     execution()表示拦截方法，其中是切点表达式；
     *     第一个 * 表示方法返回值是任意的
     *     第二个 * 表示匹配该类中的所有方法
     *     (..)表示方法参数是任意的
     * </pre>
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.dranawhite.spring.aop.Person.say(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        before();
        Object result = proceedingJoinPoint.proceed();
        after();
        return result;
    }

    public Object aroundXml(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        before();
        Object result = proceedingJoinPoint.proceed();
        after();
        return result;
    }

    public void before() {
        System.out.println("Spring Aspect-前置通知");
    }

    public void after() {
        System.out.println("Spring Aspect-后置通知");
    }

}
