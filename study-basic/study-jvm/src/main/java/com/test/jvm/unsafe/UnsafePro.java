package com.test.jvm.unsafe;

import sun.misc.Unsafe;

/**
 * <pre>
 *     Unsafe提供了一个更底层的操作，并且应该在受信任的代码中使用。可以通过内存地址存取fileds，如果给出的内存地址是无效的那么会有一个
 * 不确定的运行表现。
 * </pre>
 *
 * @author dranawhite 2017/10/18
 * @version 1.0
 */
public class UnsafePro {

    public static void main(String[] args) {
        Unsafe unsafe = UnsafeFactory.getUnsafe();
        System.out.println(unsafe);
    }

}
