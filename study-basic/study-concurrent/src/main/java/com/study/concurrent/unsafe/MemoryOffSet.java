package com.study.concurrent.unsafe;

import com.dranawhite.exception.DranawhiteException;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * unsafe.objectFieldOffset获取字段相对于对象的偏移量，发生垃圾回收后偏移量仍不变
 *
 * @author liangyq
 * @version [1.0, 2018/5/16 10:15]
 */
public class MemoryOffSet {

	private Integer num = new Integer(9876);

	public static void main(String[] args) {
		try {
			byte[] arrs = new byte[4*1024*1024];
			MemoryOffSet offSet = new MemoryOffSet();
			Field numField = MemoryOffSet.class.getDeclaredField("num");
			Unsafe unsafe = UnsafeFactory.getUnsafe();
			long offSetPre = unsafe.objectFieldOffset(numField);
			System.out.println(offSetPre);
			arrs = null;
			System.gc();
			long offSetPost = unsafe.objectFieldOffset(numField);
			System.out.println(offSetPost);
		} catch (NoSuchFieldException ex) {
			throw new DranawhiteException();
		}
	}

}
