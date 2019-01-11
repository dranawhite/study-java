package com.study.jvm.string;

/**
 * <pre>
 *  1）对于"ab" + str1 这种形式的字符串，Java编译器在解析时会产生一个StringBuilder对象，将"ab"传入构造函数，然后将str1通过append
 *  方法添加进去，在调用StringBuilder的toString方法产生一个String对象
 *  2）对于字符串+基本类型或者常量的形式，编译器是按照常量表达式直接进行优化的。所以final b = "ab"；"cd" + "ab" == "cd" + b;
 * </pre>
 *
 * <pre>
 *     字节码如下：
 *      String c = "go die, final";
 *      String d = new StringBuilder().append("go die,").append("final").toString();
 *      String e = "go die, final";
 *
 *          0: ldc           #2                  // String go die,
 *          2: astore_1
 *          3: ldc           #3                  // String final
 *          5: astore_2
 *          6: ldc           #4                  // String go die, final
 *          8: astore_3
 *          9: new           #5                  // class java/lang/StringBuilder
 *         12: dup
 *         13: invokespecial #6                  // Method java/lang/StringBuilder."<init>":()V
 *         16: aload_1
 *         17: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *
 *         20: ldc           #3                  // String final
 *         22: invokevirtual #7                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *
 *         25: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *         28: astore        4
 *         30: ldc           #4                  // String go die, final
 *         32: astore        5
 * </pre>
 *
 * <pre>
 *     String#intern() 方法底层实现，是一个StringTable，固定长度为1009，类似于HashTable的结构;
 *     在JDK1.7之后，可以通过-XX:StringTableSize=99991参数调整StringTable的长度;
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
        // d编译过程如下：StringBuilder sb = new StringBuilder(); sb.append(a).append(b); sb.toString();
        String d = a + b;
        String e = "go die, final";
        String f = "final";
        String g = "go die, " + f;

        // false
        System.out.println("c==d\t" + (c == d));
        // false
        System.out.println("d==e\t" + (d == e));
        // true
        System.out.println("c==e\t" + (c == e));
        // true
        System.out.println("b==f\t" + (b == f));
        // false
        System.out.println("g==e\t" + (g == e));
    }

}
