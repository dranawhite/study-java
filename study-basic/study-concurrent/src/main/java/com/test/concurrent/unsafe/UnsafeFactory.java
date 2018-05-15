package com.test.concurrent.unsafe;

import com.dranawhite.exception.IllegalAccessDranawhiteException;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author dranawhite 2017/10/24
 * @version 1.0
 */
public class UnsafeFactory {

	private static volatile Unsafe unsafe;

	/**
	 * 双重检测懒加载
	 *
	 * @return unsafe
	 */
	public static Unsafe getUnsafe() {
		if (unsafe == null) {
			synchronized (UnsafeFactory.class) {
				if (unsafe == null) {
					Field field;
					try {
						field = Unsafe.class.getDeclaredField("theUnsafe");
						field.setAccessible(true);
						unsafe = (Unsafe) field.get(null);
					} catch (NoSuchFieldException | IllegalAccessException ex) {
						throw new IllegalAccessDranawhiteException("Unsafe获取错误", ex);
					}
				}
			}
		}
		return unsafe;
	}
}
