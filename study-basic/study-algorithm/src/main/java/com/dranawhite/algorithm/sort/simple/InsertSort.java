package com.dranawhite.algorithm.sort.simple;

import com.dranawhite.algorithm.sort.Sort;

/**
 * 插入排序
 * <pre>
 * 算法思想：
 *      队列中有一个被标记的数值，其左边是有序的，右边是无序的；
 *      将被标记的数值与左边有序的数组比较，并插入到左边有序的数组中；
 *      重复以上步骤；
 *
 * 时间复杂度：
 *      O(N^2)
 *
 * 比较次数：
 *      最好情况：N-1
 *      最坏情况：N(N-1)/2
 *      平均情况：N(N-1)/4
 *
 * 交换次数：
 *      最好情况：0
 *      最坏情况：N(N-1)/2
 *      平均情况：N(N-1)/4
 *
 * 执行步骤：
 *      当数组升序时出现最好情况;数组倒序时出现最坏情况
 *      最好情况：N-1
 *      最坏情况：N(N-1)
 * </pre>
 *
 * @author dranawhite 2017/8/25
 * @version 1.0
 */
public class InsertSort implements Sort {

	@Override
	public void sort(Integer[] arrs) {
		for (int i = 1, len = arrs.length; i < len; i++) {
			int j = i;
			int num = arrs[i];
			while (j > 0 && num < arrs[j - 1]) {
				arrs[j] = arrs[j - 1];
				j--;
			}
			arrs[j] = num;
		}
	}
}
