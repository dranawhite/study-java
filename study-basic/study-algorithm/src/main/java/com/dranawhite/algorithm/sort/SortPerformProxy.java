package com.dranawhite.algorithm.sort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 基于JDK的动态代理，用于统计排序算法效率
 *
 * @author dranawhite 2017/8/28
 * @version 1.0
 */
public class SortPerformProxy implements InvocationHandler {

    private Sort sort;

    public SortPerformProxy(Sort sort) {
        this.sort = sort;
    }

    public Sort getSort() {
        return (Sort) Proxy
                .newProxyInstance(Sort.class.getClassLoader(), new Class[] { Sort.class }, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(sort, args);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("耗时： " + time + "毫秒");
        return result;
    }

}
