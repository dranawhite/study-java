package com.dranawhite.algorithm.sort.complex;

import com.dranawhite.algorithm.sort.Sort;

/**
 * 桶排序
 * <pre>
 * 算法思想：
 *      （1）对于这个可枚举范围构建一个buckets数组，用于记录“落入”每个桶中元素的个数；
 *      （2）将（1）中得到的buckets数组重新进行计算，按如下公式重新计算：
 *       桶中存放的数据就是数据的索引；
 *
 * 算法复杂度：
 *      如果待排序数据的范围在0~k之间，那么它的时间复杂度是O(k+n)；
 *
 * </pre>
 * @author dranawhite 2017/9/12
 * @version 1.0
 */
public class BucketSort implements Sort {

    @Override
    public void sort(Integer[] arrs) {
        bucketSort(arrs, 0, 20);
    }

    private void bucketSort(Integer[] data, int min, int max) {
        // 缓存数组
        Integer[] tmp = new Integer[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[max - min];
        // 计算每个元素在序列出现的次数
        for (int i = 0; i < data.length; i++) {
            buckets[data[i] - min]++;
        }
        // 计算“落入”各桶内的元素在有序序列中的位置
        for (int i = 1; i < max - min; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        // 将data中的元素完全复制到tmp数组中
        System.arraycopy(data, 0, tmp, 0, data.length);
        // 根据buckets数组中的信息将待排序列的各元素放入相应位置
        for (int k = data.length - 1; k >= 0; k--) {
            data[--buckets[tmp[k] - min]] = tmp[k];
        }
    }
}
