package com.test.algorithm.sort.benchmark;

import com.test.algorithm.sort.Sort;
import com.test.algorithm.sort.simple.BubbleSort;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * @author liangyq
 * @version [1.0, 2018/4/26 17:22]
 */
public class BubbleSortBenchmakData extends AverageTimeBenchmark {

	@Benchmark
	public void benchmark() {
		Sort bubbleSort = new BubbleSort();
		bubbleSort.sort(SortBenchmakData.getRandomArray());
	}

}
