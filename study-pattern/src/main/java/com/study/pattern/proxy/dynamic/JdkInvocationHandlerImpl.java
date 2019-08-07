package com.study.pattern.proxy.dynamic;

import com.dranawhite.interceptor.BaseJdkInterceptor;

/**
 * JDK动态代理的类必须要实现一个接口
 *
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
class JdkInvocationHandlerImpl<T> extends BaseJdkInterceptor<T> {

    @Override
    protected void setUp() {
        System.out.println("闪开，我要开始装逼了！");
    }

    @Override
    protected void tearDown() {
        System.out.println("装完逼就跑，真刺激！");
    }

}
