package com.test.jvm.collection;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/**
 * 随机访问接口
 * <pre>
 *      实现该接口的List，使用索引遍历的速度，要快于使用迭代器遍历
 * </pre>
 *
 * @author dranawhite 2017/8/14
 * @version 1.0
 *
 * @see RandomAccess
 */
class RandomAccessList {

    /**
     * 初始化列表
     */
    public static void initList(List list, int n) {
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
    }

    /**
     *  使用循环进行对列表的迭代
     */
    public static void traverseWithLoop(List list) {
        long starttime;
        long endtime;
        starttime = System.currentTimeMillis();
        for (int count = 0; count <= 1000; count++) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
        }
        endtime = System.currentTimeMillis();
        System.out.println("使用loop迭代一共花了" + (endtime - starttime) + "ms时间");
    }

    /**
     * 使用迭代器对列表进行迭代
     */
    public static void traverseWithIterator(List list) {
        long starttime;
        long endtime;
        starttime = System.currentTimeMillis();
        for (int count = 0; count <= 1000; count++) {
            for (Iterator itr = list.iterator(); itr.hasNext(); ) {
                itr.next();
            }
        }
        endtime = System.currentTimeMillis();
        System.out.println("使用Iterator迭代一共花了" + (endtime - starttime) + "ms时间");
    }

    public static void traverse(List list) {
        long starttime;
        long endtime;
        if (list instanceof RandomAccess) {
            System.out.println("该list实现了RandomAccess接口");
            starttime = System.currentTimeMillis();
            for (int count = 0; count <= 1000; count++) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i);
                }
            }
            endtime = System.currentTimeMillis();
            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");
        } else {
            System.out.println("该list未实现RandomAccess接口");
            starttime = System.currentTimeMillis();
            for (int count = 0; count <= 1000; count++) {
                for (Iterator itr = list.iterator(); itr.hasNext(); ) {
                    itr.next();
                }
            }
            endtime = System.currentTimeMillis();
            System.out.println("迭代一共花了" + (endtime - starttime) + "ms时间");
        }
    }

}
