package com.study.jvm.collection;

import com.dranawhite.test.CollectionInit;
import com.dranawhite.test.jmh.AverageTimeBenchmark;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.ArrayList;

/**
 * 数组表基准测试
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class ArrayListBenchmark extends AverageTimeBenchmark {

	@Benchmark
    public void testTraverse() {
        ArrayList<Integer> list = new ArrayList<>(CollectionInit.DEFAULT_NUM);
        CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
        RandomAccessList.traverse(list);
    }

    /**
     * 性能：0.075ms/op
     */
    @Benchmark
    public void testTraverseLoop() {
        ArrayList<Integer> list = new ArrayList<>(CollectionInit.DEFAULT_NUM);
        CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
        RandomAccessList.traverseWithLoop(list);
    }

    /**
     * 性能:0.070ms/op
     */
    @Benchmark
    public void testTraverseIterator() {
        ArrayList<Integer> list = new ArrayList<>(CollectionInit.DEFAULT_NUM);
        CollectionInit.randomInitList(list, CollectionInit.DEFAULT_NUM);
        RandomAccessList.traverseWithIterator(list);
    }
}
