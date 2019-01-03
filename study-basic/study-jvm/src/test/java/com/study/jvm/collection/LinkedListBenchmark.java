package com.study.jvm.collection;

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

	/**
	 * 性能：7.543ms/op
	 */
	@Benchmark
	public void testTraverseLoop() {
		LinkedList<Integer> list = new LinkedList<>();
		CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
		RandomAccessList.traverseWithLoop(list);
	}

	/**
	 * 性能：0.075ma/op
	 */
	@Benchmark
	public void testTraverseIterator() {
		LinkedList<Integer> list = new LinkedList<>();
		CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
		RandomAccessList.traverseWithIterator(list);
	}
}
