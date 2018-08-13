package com.study.spring.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * 引入增强,动态实现接口
 * <pre>
 *     AOP中对方法的增强称为Weaving(织入)
 *     对类的增强称为Introduction(引入)
 * </pre>
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
class PersonIntroductionAdvice extends DelegatingIntroductionInterceptor implements Apolopy {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return super.invoke(methodInvocation);
    }

    @Override
    public void sayAgain() {
        System.out.println("I'm Talking Again!");
    }
}