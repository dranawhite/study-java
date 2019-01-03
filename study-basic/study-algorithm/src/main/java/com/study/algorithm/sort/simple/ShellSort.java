package com.study.algorithm.sort.simple;

/**
 * 希尔排序
 * <pre>
 * 算法思想：
 *      希尔排序是在插入排序的基础上实现的，比复杂度为O(N*logN)的排序速度慢，但是优于插入排序，实现简单
 *      希尔排序将数组间隔划为h=3*h+1;
 *      希尔排序比插入排序的速度快的原因：当h值大的时候，数据项的每一趟排序需要移动元素的个数很少，但是数据
 * 项的移动的距离很长。这是非常有效率的。当h减小时，每一趟排序需要移动的元素的个数增多，但是此时数据项已经
 * 接近于它们排序后的最终位置，这对于插入排序可以更有效率。这两种情况的结合使得希尔排序的效率那么高。
 *
 * 算法复杂度：
 *      O(N^2)
 *
 * 图：
 *      resources/sort/希尔排序.png
 * </pre>
 *
 * @author dranawhite 2017/8/28
 * @version 1.0
 */
public class ShellSort extends InsertSort {

    @Override
    public void sort(Integer[] arrs) {
        int length = arrs.length;
        int h = 1;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (int i = 0; i < length - 1; i++) {
                int j = i;
                if (i + h >= length) {
                    break;
                }
                int temp = arrs[i + h];
                while (j > -1 && arrs[j] >= temp) {
                    arrs[j + h] = arrs[j];
                    j = j - h;
                }
                arrs[j + h] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
