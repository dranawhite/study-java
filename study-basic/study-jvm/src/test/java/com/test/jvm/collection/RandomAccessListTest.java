package com.test.jvm.collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class RandomAccessListTest {

    private static RandomAccessList randomAccessList;
    private static ArrayList arraylist;
    private static LinkedList linkedlist;

    @BeforeClass
    public static void init() {
        randomAccessList = new RandomAccessList();
        arraylist = new ArrayList();
        linkedlist = new LinkedList();
        randomAccessList.initList(arraylist, 1000);
        randomAccessList.initList(linkedlist, 1000);
    }

    @Test
    public void testTraverse() {
        System.out.println("--------实现RandomAccess接口则用for循环遍历，否则用迭代器遍历----");
        System.out.println("--------ArrayList----------------");
        randomAccessList.traverse(arraylist);
        System.out.println("--------LinkedList---------------");
        randomAccessList.traverse(linkedlist);
    }

    @Test
    public void testTraverseLoop() {
        System.out.println("--------for循环遍历---------------");
        System.out.println("--------ArrayList----------------");
        randomAccessList.traverseWithLoop(arraylist);
        System.out.println("--------LinkedList---------------");
        randomAccessList.traverseWithLoop(linkedlist);
    }

    @Test
    public void testTraverseIterator() {
        System.out.println("--------Iterator遍历--------------");
        System.out.println("--------ArrayList----------------");
        randomAccessList.traverseWithIterator(arraylist);
        System.out.println("--------LinkedList---------------");
        randomAccessList.traverseWithIterator(linkedlist);
    }

    @AfterClass
    public static void destroy() {
        randomAccessList = null;
        arraylist = null;
        linkedlist = null;
    }

}
