package com.test.jvm.method;

import org.junit.Test;

/**
 * @author dranawhite.web.jvm 2017/7/4
 * @version 1.0
 */
public class MethodTest {

   /*   运行结果

        校验封装类型：
        int invoke!
        校验继承类型：
        SuperClass invoke!
        SuperInterface invoke!
        SubClass invoke!
    */
    @Test
    public void testParse() {
        StaticAssign staticAssign = new StaticAssign();
        System.out.println("校验封装类型：");
        staticAssign.parse(1);
        System.out.println("校验继承类型：");
        SuperClass superClass = new SubClass();
        SuperInterface superInterface = new SubClass();
        staticAssign.parse(superClass);
        staticAssign.parse(superInterface);
        //当注释掉staticAssign#parse(SubClass subClass)方法时，该语句报错，因为有两个匹配的方法；
        staticAssign.parse(new SubClass());
    }

    @Test
    public void testPrint() {
        System.out.println("校验静态方法的重载：");
        SuperClass.print();
        SubClass.print();
        SuperClass superClass = new SubClass();
        superClass.print();
    }

    @Test
    public void testPrintHello() {
        System.out.println("校验静态方法的继承：");
        SuperClass.printHello();
        SubClass.printHello();
    }

}
