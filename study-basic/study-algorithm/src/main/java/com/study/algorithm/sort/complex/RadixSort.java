package com.study.algorithm.sort.complex;

import com.study.algorithm.sort.Sort;

import java.util.Arrays;

/**
 * 基数排序
 * <pre>
 * 算法思想：
 *      将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次
 * 排序。这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列
 *
 * 图片：
 *      resources/sort/基数排序.png
 * </pre>
 *
 * @author dranawhite 2017/9/11
 * @version 1.0
 */
public class RadixSort implements Sort {

    @Override
    public void sort(Integer[] arrs) {
        radixSort(arrs, 10 , 10);
    }

    private void radixSort(Integer[] data, int radix, int d) {
        // 缓存数组
        Integer[] tmp = new Integer[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        for (int i = 0, rate = 1; i < d; i++) {

            // 重置count数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmp, 0, data.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmp[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmp[m] / rate) % radix;
                data[--buckets[subKey]] = tmp[m];
            }
            rate *= radix;
        }

    }
}