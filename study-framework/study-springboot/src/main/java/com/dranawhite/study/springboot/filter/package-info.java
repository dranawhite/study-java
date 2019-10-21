/**
 * <pre>
 *     StandardWrapperValve是Wrapper容器的basicValve。
 *     在StandardWrapperValve中，创建一个ApplicationFilterChain然后调用filterChain.doFilter方法.
 *     Filter是在StandardContext中传入，
 *
 *     FilterRegistrationBean extends RegistrationBean implements ServletContextInitializer, Ordered;
 *     在ServletWebServerApplicationContext启动过程中，会执行ServletContextInitializer的onStartUp()注册bean;
 *     FilterRegistrationBean通过实现Ordered接口指定Filter的顺序
 * </pre>
 *
 * <pre>
 *     如果没有指定顺序时，Filter的加载顺序如下：从BeanFactory中获取实例, 已加载的bean会被保存在exclude中，其它途径的方式不会再重复加载
 *     addServletContextInitializerBeans(beanFactory);先加载实现FilterRegistrationBean
 * 	   addAdaptableBeans(beanFactory);再加载实现Filter接口的
 * </pre>
 *
 * <pre>
 *     Spring Security中起始的Filter是DefaultSecurityFilterChain implements SecurityFilterChain接口;
 *     Spring Security中的Filter是在HttpSecurity的performBuild方法中按照comparator进行排序;
 * </pre>
 */
package com.dranawhite.study.springboot.filter;