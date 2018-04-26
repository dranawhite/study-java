package com.dranawhite.pattern.dynamicproxy;

/**
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
class Person implements IPerson {

    @Override
    public void say() {
        System.out.println("装逼中......");
    }

    @Override
    public void sayAgain() {
        System.out.println("再次装逼......");
    }

}
