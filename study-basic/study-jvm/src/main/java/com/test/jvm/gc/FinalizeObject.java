package com.test.jvm.gc;

/**
 * 垃圾回收时会调用对象的finalize方法，但是只会调用一次
 *
 * @author dranawhite 2017/8/4
 * @version 1.0
 */
class FinalizeObject {

    private static FinalizeObject obj;

    private String name;

    public FinalizeObject(String name) {
        this.name = name;
        System.out.println(name + "-创建");
    }

    public void createObj() {
        obj = new FinalizeObject("obj");
    }

    public void gc() {
        obj = null;
        System.gc();
        System.out.println(name + "-销毁obj");
    }

    @Override
    public void finalize() {
        obj = this;
        if (obj != null) {
            System.out.println(name + "-复活");
        }
    }

    public void printResult() {
        System.out.println(name + ": obj=" + obj);
    }

}
