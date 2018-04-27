package com.test.jvm.benchmark.collection;

import com.dranawhite.test.CollectionInit;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.LinkedList;

/**
 * 链表基准测试
 *
 * @author liangyq
 * @version [1.0, 2018/4/27 14:41]
 */
public class LinkedListBenchmark extends AverageTimeBenchmark {

	@Benchmark
	public void testTraverse() {
		LinkedList<Integer> list = new LinkedList<>();
		CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
		RandomAccessList.traverse(list);
	}

	@Benchmark
	public void testTraverseLoop() {
		LinkedList<Integer> list = new LinkedList<>();
		CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
		RandomAccessList.traverseWithLoop(list);
	}

	@Benchmark
	public void testTraverseIterator() {
		LinkedList<Integer> list = new LinkedList<>();
		CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
		RandomAccessList.traverseWithIterator(list);
	}
}
