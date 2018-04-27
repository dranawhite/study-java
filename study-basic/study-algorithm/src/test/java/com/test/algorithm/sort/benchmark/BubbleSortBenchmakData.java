package com.test.algorithm.sort.benchmark;

import com.dranawhite.test.CollectionInit;
import com.test.algorithm.sort.Sort;
import com.test.algorithm.sort.simple.BubbleSort;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * 冒泡排序基准测试
 * <pre>
 *     性能68s/op
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/26 17:22]
 */
public class BubbleSortBenchmakData extends AverageTimeBenchmark {

	@Benchmark
	public void benchmark() {
		Sort bubbleSort = new BubbleSort();
		bubbleSort.sort(CollectionInit.getRandomArray(DataInitConstant.NUM));
	}

}
