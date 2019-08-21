package com.dranawhite.study.pattern.proxy.dynamic;

import com.dranawhite.interceptor.BaseJdkInterceptor;

/**
 * JDK动态代理的类必须要实现一个接口
 * <pre>
 *     JDK动态代理的代理类由Proxy$ProxyClassFactory生成;
 *     通过ProxyGenerator.generateProxyClass(proxyName, interfaces, accessFlags);生成代理类的字节码文件并添加接口
 * </pre>
 *
 * <pre>
 *     JDK动态代理的实现逻辑如下：
 *     1) 通过Proxy.newProxyInstance方法生成了一个代理类的字节码文件，并为代理类添加接口和接口相关的方法
 *     2) 在InvocationHandler的invoke方法中用反射调用被代理对象的相关方法，并在相关方法的前后做增强
 *     3) 调用代理类的相关方法
 *     public final void sayAgain() throws  {
 *         try {
 *             super.invocationHandler.invoke(this, m3, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 * </pre>
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
