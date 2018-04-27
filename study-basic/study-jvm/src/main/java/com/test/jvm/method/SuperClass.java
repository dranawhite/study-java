package com.test.jvm.method;

/**
 * @author dranawhite.web.jvm 2017/7/4
 * @version 1.0
 */
abstract class SuperClass {

    /**
     * 用于验证方法被子类继承时的问题
     * <p>
     *      invokevirtual指令运行时解析过程分为以下几个步骤：
     * </p>
     * <ol>
     *      <li>
     *          找到操作数栈顶的第一个元素所指向的对象的实际类型，记作C；
     *      </li>
     *      <li>
     *          如果在类型C中找到了与常量中的描述符和简单名称都相符的方法，则进行访问权限校验，如果通过则返回这个方法的直接
     *      引用，查找过程结束；如果不通过，则返回java.commons.IllegalAccessError异常；
     *      </li>
     *      <li>
     *          否则，按照继承关系从下往上依次对C的各个父类进行第二步的搜索和验证过程；
     *      </li>
     *      <li>
     *          如果始终没有找到合适的方法，则抛出java.commons.AbstractMethodError异常；
     *      </li>
     * </ol>
     *
     * @param param 字符串参数
     * @param num   整型参数
     * @throws IllegalArgumentException 非法参数异常
     */
    abstract void assignMethod(String param, int num) throws IllegalArgumentException;

    /**
     * 静态方法在编译时就能确定;
     * 子类不能重写父类的静态方法，加Override标注报错;
     */
    static void print() {
        System.out.println("SuperClass invoke!");
    }

    /**
     * 子类可以继承父类的静态方法
     */
    static void printHello() {
        System.out.println("SuperClass invoke Hello!");
    }

}
