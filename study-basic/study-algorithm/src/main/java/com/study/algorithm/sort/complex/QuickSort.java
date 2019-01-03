package com.study.algorithm.sort.complex;

/**
 * 快速排序
 * <pre>
 * 算法思想：
 *      快速排序是用的分治法，每次从数组中随机取一个值作为中值，将比中值大和比中值小的数据分别移到
 * 数组的两端；
 *      快速排序是同数量级排序中平均性能最好的
 *
 * 时间复杂度：
 *      O(N*logN)
 *
 * 图：
 *      resources/sort/快速排序.png
 * </pre>
 *
 * @author dranawhite 2017/8/28
 * @version 1.0
 */
public class QuickSort extends MergeSort {

    @Override
    public void sort(Integer[] arrs) {
        sort(arrs, 0, arrs.length - 1);
    }

    private void sort(Integer[] arrs, int min, int max) {
        if (min < max) {
            int mid = getMid(arrs, min, max);
            sort(arrs, min, mid);
            sort(arrs, mid + 1, max);
        }
    }

    private int getMid(Integer[] arrs, int min, int max) {
        int temp = arrs[min];
        while (min < max) {
            while (min < max && arrs[max] > temp) {
                max--;
            }
            arrs[min] = arrs[max];
            while (min < max && arrs[min] < temp) {
                min++;
            }
            arrs[max] = arrs[min];
        }
        arrs[min] = temp;
        return min;
    }
}
