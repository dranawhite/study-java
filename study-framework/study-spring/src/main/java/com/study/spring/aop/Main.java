package com.study.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * <pre>
 *     Spring AOP代理实现类
 *     BeanNameAutoProxyCreator基于Bean配置名规则的自动代理创建器;
 *     DefaultAdvisorAutoProxyCreator基于Advisor匹配机制的自动代理创建器;
 *     AnnotationAwareAspectJAutoProxyCreator基于Bean中AspectJ注解标签的自动代理创建器;
 * </pre>
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-21 17:20 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        // 用于观察生成的字节码文件
        // System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D://cglib/");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new ApolopyImpl());
        proxyFactory.addAdvice(new OriginAdvice());
        ApolopyImpl apolopy = (ApolopyImpl) proxyFactory.getProxy();
        apolopy.sayAgain();
    }

}
