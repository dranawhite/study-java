package com.test.jvm.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author dranawhite 2017/10/24
 * @version 1.0
 */
public class UnsafeFactory {

    private static Unsafe unsafe;

    static {
        Field field;
        try {
            field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException nsfe) {
            nsfe.printStackTrace();
        } catch (IllegalAccessException ice) {
            ice.printStackTrace();
        }
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }
}
