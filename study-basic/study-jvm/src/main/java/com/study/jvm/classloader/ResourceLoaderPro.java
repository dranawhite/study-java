package com.study.jvm.classloader;

import java.io.InputStream;

/**
 *
 * @author dranawhite
 * @version $Id: ResourceLoaderPro.java, v 0.1 2019-01-22 20:52 dranawhite Exp $$
 */
public class ResourceLoaderPro {

    public static void main(String[] args) {
        InputStream ins = ClassLoader.getSystemResourceAsStream("com/study/jvm/classloader/test.properties");
        System.out.println("INS = " + ins);
    }
}
