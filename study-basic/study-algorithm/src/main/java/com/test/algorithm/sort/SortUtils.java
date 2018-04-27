package com.test.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class SortUtils {

    private static final ArrayList<Integer> list = new ArrayList<>(50);

    static {
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        list.add(17);
        list.add(18);
        list.add(19);
        list.trimToSize();
        Collections.shuffle(list);
    }

    public static Integer[] getArray() {
        return SortUtils.list.toArray(new Integer[]{});
    }

    public static void compareAndSwap(Integer[] arr, Integer m, Integer n) {
        if (arr[m] > arr[n]) {
            Integer temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
    }

    public static void printArr(Integer[] arr) {
        System.out.print("[");
        for (Integer num : arr) {
            System.out.print(num + "\t");
        }
        System.out.println("]");
    }
}
