package com.study.jvm.method;

/**
 * @author dranawhite.web.jvm 2017/7/4
 * @version 1.0
 */
class SubClass extends SuperClass implements SuperInterface {

    /**
     * 子类重写父类方法时，有关异常的处理：
     * <p>
     *     如果是RuntimeException，编译器不会做静态检查；如果是检查异常，则子类不能抛出比父类更广范围的异常；
     * </p>
     *
     * @param param 字符串参数
     * @param num   整型参数
     */
    @Override
    void assignMethod(String param, int num) {
        throw new NullPointerException();
    }

    /**
     * 静态方法在编译时就能确定;
     * 子类不能重写父类的静态方法，加Override标注报错;
     */
    static void print() {
        System.out.println("SubClass invoke!");
    }

}
