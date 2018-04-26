package com.dranawhite.algorithm.sort.benchmark;

import com.dranawhite.algorithm.sort.Sort;
import com.dranawhite.algorithm.sort.simple.BubbleSort;

/**
 * @author liangyq
 * @version [1.0, 2018/4/26 17:22]
 */
public class BubbleSortAverageTime extends BaseSortAverageTime {

	@Override
	public void benchmark() {
		Sort bubbleSort = new BubbleSort();
		bubbleSort.sort(getRandomArray());
	}

}
