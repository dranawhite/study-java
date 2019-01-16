package com.study.algorithm.sort.benchmark;

import com.dranawhite.test.CollectionInit;
import com.study.algorithm.sort.Sort;
import com.study.algorithm.sort.simple.BubbleSort;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * 冒泡排序基准测试
 * <pre>
 *     性能68s/op
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/4/26 17:22]
 */
public class BubbleSortBenchmakData extends AverageTimeBenchmark {

	@Benchmark
	public void benchmark() {
		Sort bubbleSort = new BubbleSort();
		bubbleSort.sort(CollectionInit.getRandomArray(CollectionInit.DEFAULT_NUM));
	}

}
