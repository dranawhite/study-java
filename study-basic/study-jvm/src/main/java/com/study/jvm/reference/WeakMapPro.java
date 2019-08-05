package com.study.jvm.reference;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * 弱引用实验
 * <pre>
 *     GC后会回收弱引用对象;
 *     当WeakHashMap中值直接或者间接的引用键时，WeakHashMap中的数据不会被回收
 *     可以用WeakReference包裹值
 * </pre>
 *
 * <pre>
 *     WeakHashMap的实现：
 *     1）Entry继承了WeakReference对象
 *     2）Map的key被保存在WeakReference中，则每次key会失效
 *     3）在每次查询，删除，插入的时候，会调用ReferenceQueue对被删除的Entry对象进行遍历删除
 *
 *     所以，如果map中的key被强引用的话，map中的该个key，并不会失效；
 * </pre>
 *
 * <pre>
 *     运行结果：
 *     200
 *     SIZE = 977438
 *     SIZE = 128
 *
 *     Integer会对-128到127的对象进行缓存，既0-127的对象被缓存池引用，无法被回收。
 * </pre>
 *
 * @author dranawhite
 * @version $Id: WeakMapPro.java, v 0.1 2018-09-12 19:16 dranawhite Exp $$
 */
public class WeakMapPro {

    public static void main(String[] args) throws InterruptedException {
        final int size = 1024 * 1024;
        WeakHashMap<Integer, WeakReference<Integer>> map = new WeakHashMap<>();
        for (int i = 0; i < size; i++) {
            // 创建一个不被Integer对象自动缓存的integer对象
            WeakReference<Integer> reference = new WeakReference<>(i);
            map.put(i, reference);
        }
        System.out.println(map.get(200).get());
        System.out.println("SIZE = " + map.size());
        System.gc();
        Thread.sleep(5000);
        System.out.println("SIZE = " + map.size());
    }
}