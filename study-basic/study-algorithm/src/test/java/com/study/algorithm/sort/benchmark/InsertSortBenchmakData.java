package com.study.algorithm.sort.benchmark;

import com.dranawhite.test.CollectionInit;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import com.study.algorithm.sort.Sort;
import com.study.algorithm.sort.simple.InsertSort;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * 插入排序基准测试
 * <pre>
 *     性能：3.9s/op
 * </pre>
 * @author liangyq
 * @version [1.0, 2018/4/26 17:34]
 */
public class InsertSortBenchmakData extends AverageTimeBenchmark {

	@Benchmark
	public void benchmark() {
		Sort bubbleSort = new InsertSort();
		bubbleSort.sort(CollectionInit.getRandomArray(CollectionInit.DEFAULT_NUM));
	}

}
