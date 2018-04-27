package com.test.jvm.spi;

import com.test.core.spi.SayHello;

import java.util.ServiceLoader;

/**
 * @author dranawhite 2017/10/31
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<SayHello> loader = ServiceLoader.load(SayHello.class);
        for (SayHello sayHello : loader) {
            sayHello.sayHello();
        }
    }

}
