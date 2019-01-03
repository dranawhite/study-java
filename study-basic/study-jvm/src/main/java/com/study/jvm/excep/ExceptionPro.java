package com.study.jvm.excep;

import java.io.IOException;

/**
 * 研究try包裹的代码块多少对于效率的影响
 * <pre>
 *     字节码如下：
 *     Constant pool:
 * #1 = Methodref          #5.#21         // java/commons/Object."<init>":()V
 * #2 = Class              #22            // java/io/IOException
 * #3 = Methodref          #2.#21         // java/io/IOException."<init>":()V
 * #4 = Class              #23            // com/dranawhite/jvm/excep/ExceptionPro
 * #5 = Class              #24            // java/commons/Object
 * #6 = Utf8               <init>
 * #7 = Utf8               ()V
 * #8 = Utf8               Code
 * #9 = Utf8               LineNumberTable
 * #10 = Utf8               LocalVariableTable
 * #11 = Utf8               this
 * #12 = Utf8               Lcom/dranawhite/jvm/excep/ExceptionPro;
 * #13 = Utf8               study
 * #14 = Utf8               i
 * #15 = Utf8               I
 * #16 = Utf8               StackMapTable
 * #17 = Class              #23            // com/dranawhite/jvm/excep/ExceptionPro
 * #18 = Class              #22            // java/io/IOException
 * #19 = Utf8               SourceFile
 * #20 = Utf8               ExceptionPro.java
 * #21 = NameAndType        #6:#7          // "<init>":()V
 * #22 = Utf8               java/io/IOException
 * #23 = Utf8               com/dranawhite/jvm/excep/ExceptionPro
 * #24 = Utf8               java/commons/Object

 * </pre>
 *
 * @author dranawhite 2017/10/26
 * @version 1.0
 */
public class ExceptionPro {

    public void tryPro() {
        try {
            int i = 4;
            if (i == 4) {
                throw new IOException();
            }
            i++;
        } catch(IOException e) {
            //do nothing.
        }
    }

    public void tryMethodPro() {
        try {
            exceptionMethod();
        } catch (IOException e) {
            //do nothing
        }
    }

    /**
     * <pre>
     *     字节码如下：finally会捕获Any异常
     *     Code:
     *       stack=2, locals=3, args_size=1
     *          0: iconst_0
     *          1: istore_1
     *          2: iconst_1
     *          3: istore_1
     *          4: new           #5                  // class java/lang/RuntimeException
     *          7: dup
     *          8: invokespecial #6                  // Method java/lang/RuntimeException."<init>":()V
     *         11: athrow
     *         12: astore_2
     *         13: iconst_2
     *         14: istore_1
     *         15: aload_2
     *         16: athrow
     *       Exception table:
     *          from    to  target type
     *              2    13    12   any
     * </pre>
     */
    public void tryFinally() {
        int i = 0;
        try {
            i = 1;
            throw new RuntimeException();
        } finally {
            i = 2;
        }
    }

    public void tryCatchFinally() {
        int i = 0;
        try {
            i = 1;
            throw new RuntimeException();
        } catch (Exception e) {
            throw e;
        } finally {
            i = 2;
        }
    }

    private void exceptionMethod() throws IOException {
        throw new IOException();
    }

}
