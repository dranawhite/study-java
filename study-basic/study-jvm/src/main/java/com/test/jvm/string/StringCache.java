package com.test.jvm.string;

/**
 * <pre>
 *  1）对于"ab" + str1 这种形式的字符串，Java编译器在解析时会产生一个StringBuilder对象，将"ab"传入构造函数，然后将str1通过append
 *  方法添加进去，在调用StringBuilder的toString方法产生一个String对象
 *  2）对于字符串+基本类型或者常量的形式，编译器是按照常量表达式直接进行优化的。所以final b = "ab"；"cd" + "ab" == "cd" + b;
 * </pre>
 *
 * @author dranawhite 2017/10/24
 * @version 1.0
 */
public class StringCache {

    public static void main(String[] args) {
        String a = "go die, ";
        final String b = "final";
        String c = "go die, " + b;
        String d = a + b;
        String e = "go die, final";

        // false
        System.out.println("c==d\t" + (c == d));
        // false
        System.out.println("d==e\t" + (d == e));
        // true
        System.out.println("c==e\t" + (c == e));
    }

}
