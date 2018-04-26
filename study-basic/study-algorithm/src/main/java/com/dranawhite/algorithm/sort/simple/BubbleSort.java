package com.dranawhite.algorithm.sort.simple;

import com.dranawhite.algorithm.sort.Sort;
import com.dranawhite.algorithm.sort.SortUtils;

/**
 * 冒泡排序
 * <pre>
 * 算法思想：
 *      从左向右依次比较相邻的两个数字A和B，如果A大于B则交换位置，否则则不动；
 *      继续比较下两组数字；
 *
 * 时间复杂度：
 *      O(N^2)
 *
 * 比较次数：
 *      N(N-1)/2
 *
 * 交换次数：
 *      最好情况为0；
 *      最坏情况为N(N-1)/2；
 *
 * 执行步骤：
 *      当数组升序时出现最好情况，数组倒序时出现最坏情况；
 *      最好情况：N(N-1)/2
 *      最坏情况：N(N-1)
 *
 * 图片：
 *      resources/sort/冒泡排序.png
 * </pre>
 *
 * @author dranawhite 2017/8/23
 * @version 1.0
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(Integer[] arrs) {
        for (int j = arrs.length; j > 2; j--) {
            for (int i = 1; i < j; i++) {
                SortUtils.compareAndSwap(arrs, i - 1, i);
            }
        }
    }
}
