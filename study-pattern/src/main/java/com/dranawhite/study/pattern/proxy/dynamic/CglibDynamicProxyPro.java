package com.dranawhite.study.pattern.proxy.dynamic;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * 生成的字节码文件参照docs/Person$$EnhancerByCGLIB$$a5bba25b.class
 *
 * @author dranawhite
 * @version : CglibDynamicProxy.java, v 0.1 2019-08-21 16:48 dranawhite Exp $$
 */
public class CglibDynamicProxyPro {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D://");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new CglibInterceptor());
        enhancer.create();
    }
}
