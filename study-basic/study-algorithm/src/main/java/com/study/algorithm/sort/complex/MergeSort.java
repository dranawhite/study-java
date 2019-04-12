package com.study.algorithm.sort.complex;

import com.study.algorithm.sort.Sort;
import com.study.algorithm.sort.SortUtils;

/**
 * 归并排序
 * <pre>
 * 算法思想：
 *      将数组不断的分割成一个个极小的单元数组，对每个单元数组排序后，再两两合并
 *      需要一个临时数组
 *
 * 算法复杂度：
 *      O(N*logN)
 *
 * 图：
 *      resources/sort/归并排序.png
 * </pre>
 *
 * @author dranawhite 2017/8/25
 * @version 1.0
 */
public class MergeSort implements Sort {

    @Override
    public void sort(Integer[] arrs) {
        int min = 0;
        int max = arrs.length - 1;
        Integer[] tempArr = new Integer[max + 1];
        sort(arrs, min, max, tempArr);
    }

    private void sort(Integer[] arrs, int min, int max, Integer[] tempArr) {
        if (min == max) {
            return;
        }
        if (max - min == 1) {
            SortUtils.compareAndSwap(arrs, min, max);
            return;
        }

        int mid = (max - min) / 2 + min;
        sort(arrs, min, mid, tempArr);
        sort(arrs, mid + 1, max, tempArr);
        merge(arrs, min, mid, max, tempArr);
    }

    private void merge(Integer[] arrs, int min, int mid, int max, Integer[] tempArr) {
        int i = min;
        int j = mid + 1;
        int k = 0;
        //在临时数组中按顺序组装数据
        while (i <= mid && j <= max) {
            if (arrs[i] < arrs[j]) {
                tempArr[k++] = arrs[i++];
            } else {
                tempArr[k++] = arrs[j++];
            }
        }
        if (mid > i - 1) {
            while (i <= mid) {
                tempArr[k++] = arrs[i++];
            }
        } else if (max > j - 1) {
            while (j <= max) {
                tempArr[k++] = arrs[j++];
            }
        }
        k = 0;
        for (int n = min; n <= max; n++) {
            arrs[n] = tempArr[k++];
        }
    }
}
