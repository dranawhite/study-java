package com.dranawhite.algorithm.sort.benchmark;

import com.dranawhite.jmh.JmhRunner;

/**
 * @author liangyq
 * @version [1.0, 2018/4/26 17:19]
 */
public class SortPerformMark {

	public static void main(String[] args) {
		JmhRunner.run(
				BubbleSortAverageTime.class,
				InsertSortAverageTime.class
		);
	}

}
