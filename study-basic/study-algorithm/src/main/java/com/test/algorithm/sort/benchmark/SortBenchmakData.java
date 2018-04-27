package com.test.algorithm.sort.benchmark;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author liangyq
 * @version [1.0, 2018/4/26 17:26]
 */
public class SortBenchmakData {

	private static Integer[] arrs;

	/**
	 * 准备数据
	 */
	protected static Integer[] getRandomArray() {
		int num = 100000;
		List<Integer> list = new ArrayList<>(num);
		for (int i = 0; i < num; i++) {
			Random random = new Random();
			int data = random.nextInt(Integer.MAX_VALUE);
			list.add(data);
		}
		arrs = list.toArray(new Integer[]{});
		return arrs;
	}

}
