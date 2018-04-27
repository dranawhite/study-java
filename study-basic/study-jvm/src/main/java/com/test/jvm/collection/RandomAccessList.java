package com.test.jvm.collection;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * 随机访问接口
 * <pre>
 *      实现该接口的List，使用索引遍历的速度，要快于使用迭代器遍历
 * </pre>
 *
 * @author dranawhite 2017/8/14
 * @version 1.0
 * @see RandomAccess
 */
public class RandomAccessList {

	/**
	 * 使用循环进行对列表的迭代
	 */
	public static int traverseWithLoop(List<Integer> list) {
		Integer num = 0;
		for (int i = 0; i < list.size(); i++) {
			num += list.get(i);
		}
		return num;
	}

	/**
	 * 使用迭代器对列表进行迭代
	 */
	public static int traverseWithIterator(List<Integer> list) {
		Integer num = 0;
		for (Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
			num += itr.next();
		}
		return num;
	}

	public static int traverse(List<Integer> list) {
		Integer num = 0;
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				num += list.get(i);
			}
		} else {
			for (Iterator<Integer> itr = list.iterator(); itr.hasNext(); ) {
				num += itr.next();
			}
		}
		return num;
	}
}
