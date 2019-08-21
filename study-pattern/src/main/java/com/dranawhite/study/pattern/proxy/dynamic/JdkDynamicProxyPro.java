package com.dranawhite.study.pattern.proxy.dynamic;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Modifier;

/**
 * 生成的代理类参照docs/DranaProxy.class
 *
 * @author dranawhite
 * @version : JdkDynamicProxyPro.java, v 0.1 2019-08-21 15:58 dranawhite Exp $$
 */
public class JdkDynamicProxyPro {

    public static void main(String[] args) {
        String proxyClassName = "com.dranawhite.study.pattern.proxy.dynamic.DranaProxy";
        int accessFlag = Modifier.PUBLIC | Modifier.FINAL;
        byte[] proxyFile = ProxyGenerator.generateProxyClass(proxyClassName, new Class[]{IPerson.class},  accessFlag);
        try (FileOutputStream outs = new FileOutputStream("D:/DranaProxy.class")) {
            outs.write(proxyFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
