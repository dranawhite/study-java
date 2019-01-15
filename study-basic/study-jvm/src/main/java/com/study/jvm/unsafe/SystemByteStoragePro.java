package com.study.jvm.unsafe;

import sun.misc.Unsafe;

import java.nio.ByteOrder;

/**
 * 大端序和小端序
 * <pre>
 *     若沿着内存增长方向，数据的最低有效字节在最高有效字节前，则是大段序（大段尾）,反之则是小端序（小段尾）
 * </pre>
 *
 * @author dranawhite
 * @version $Id: SystemByteStoragePro.java, v 0.1 2019-01-14 21:19 dranawhite Exp $$
 */
public class SystemByteStoragePro {

    public static void main(String[] args) {
        ByteOrder byteOrder;
        Unsafe unsafe = UnsafeFactory.getUnsafe();
        long a = unsafe.allocateMemory(8);
        try {
            unsafe.putLong(a, 0x0102030405060708L);
            byte b = unsafe.getByte(a);
            switch (b) {
                case 0x01: byteOrder = ByteOrder.BIG_ENDIAN;     break;
                case 0x08: byteOrder = ByteOrder.LITTLE_ENDIAN;  break;
                default:
                    assert false;
                    byteOrder = null;
            }
        } finally {
            unsafe.freeMemory(a);
        }
    }
}
