/**
 * AOP中的基本概念
 * <pre>
 *     1)Joinpoint连接点  如方法调用前、方法调用后、方法抛出异常时；
 *     2)Pointcut切点     切点用来标记感兴趣的连接点，既被代理的连接点
 *     3)Advice增强       增强的逻辑
 *     4)Target目标对象    被代理的类
 *     5)Weaving织入      将增强添加到目标类具体连接点的过程
 *          AOP有三种织入过程：
 *          编译期织入，类装载期织入，动态代理织入；
 *          Spring采用动态代理织入，AspectJ采用编译期织入和类装载期织入；
 *     6)代理Proxy        生成的结果代理类
 *     7)Aspect切面       切面由切点和增强组成
 * </pre>
 *
 * <pre>
 *     动态代理JDK实现
 *     1)Proxy和InvocationHandler
 * </pre>
 */
package com.study.spring.aop;