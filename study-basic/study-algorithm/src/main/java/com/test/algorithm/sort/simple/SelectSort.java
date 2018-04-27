package com.test.algorithm.sort.simple;

import com.test.algorithm.sort.Sort;
import com.test.algorithm.sort.SortUtils;

/**
 * 选择排序
 * <pre>
 * 算法思想：
 *      对数组遍历一遍，从中挑取最小的数值，放在0号位置；
 *      重复以上步骤；
 *
 * 算法复杂度：
 *      O(N^2)
 *
 * 比较次数：
 *      N(N-1)/2
 *
 * 交换次数：
 *      3（N-1)
 *
 * 执行步骤：
 *      (N+6)(N-1)/2
 *
 * </pre>
 *
 * @author dranawhite 2017/8/25
 * @version 1.0
 */
public class SelectSort implements Sort {

	@Override
	public void sort(Integer[] arrs) {
		for (int i = 0, len = arrs.length; i < len; i++) {
			int min = arrs[i];
			int index = i;
			for (int j = i + 1; j < len; j++) {
				if (min > arrs[j]) {
					min = arrs[j];
					index = j;
				}
			}
			SortUtils.compareAndSwap(arrs, i, index);
		}
	}
}
