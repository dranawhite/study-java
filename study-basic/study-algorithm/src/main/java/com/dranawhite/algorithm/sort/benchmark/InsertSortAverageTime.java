package com.dranawhite.algorithm.sort.benchmark;

import com.dranawhite.algorithm.sort.Sort;
import com.dranawhite.algorithm.sort.simple.InsertSort;

/**
 * 插入排序基准测试
 *
 * @author liangyq
 * @version [1.0, 2018/4/26 17:34]
 */
public class InsertSortAverageTime extends BaseSortAverageTime {

	@Override
	public void benchmark() {
		Sort bubbleSort = new InsertSort();
		bubbleSort.sort(getRandomArray());
	}

}
