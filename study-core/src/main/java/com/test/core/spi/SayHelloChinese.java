package com.test.core.spi;

/**
 * @author dranawhite 2017/10/31
 * @version 1.0
 */
public class SayHelloChinese implements SayHello {

    @Override
    public void sayHello() {
        System.out.println("你好！");
    }
}
