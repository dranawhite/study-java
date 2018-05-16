package com.test.concurrent.unsafe;

import com.dranawhite.exception.DranawhiteException;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

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

    private Integer num;

    private long offSet;

    public static void main(String[] args) {
        try {
            Unsafe unsafe = UnsafeFactory.getUnsafe();
            Field numField = UnsafePro.class.getDeclaredField("num");
            UnsafePro pro = new UnsafePro();
            pro.offSet = unsafe.objectFieldOffset(numField);
            System.out.println("初始值：" + unsafe.getObject(pro, pro.offSet));
            unsafe.compareAndSwapObject(pro, pro.offSet, null, 100);
            System.out.println("变更值：" + pro.num);
        } catch (NoSuchFieldException ex) {
            throw new DranawhiteException();
        }
    }
}
