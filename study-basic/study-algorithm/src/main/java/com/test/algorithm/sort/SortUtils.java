package com.test.algorithm.sort;

import com.dranawhite.test.CollectionInit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class SortUtils {

    public static Integer[] getArray() {
        return CollectionInit.getRandomArray(20);
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
