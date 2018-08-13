package com.study.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * 环绕通知
 * <pre>
 *     MethodInterceptor来自AOP联盟，Spring只是借用了该接口
 * </pre>
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
class PersonAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        before();
        Object result = invocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Spring AOP——前置通知");
    }

    private void after() {
        System.out.println("Spring AOP——后置通知");
    }
}
