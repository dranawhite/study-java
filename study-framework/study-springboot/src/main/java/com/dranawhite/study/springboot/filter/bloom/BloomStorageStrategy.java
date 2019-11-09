package com.dranawhite.study.springboot.filter.bloom;

import com.google.common.hash.Funnel;

/**
 * @author dranawhite
 * @version : BloomStorageStrategy.java, v 0.1 2019-10-23 15:45 dranawhite Exp $$
 */
@SuppressWarnings("UnstableApiUsage")
public interface BloomStorageStrategy {

    /**
     * 向BloomFilter中存储数据
     *
     * @param object           数据
     * @param funnel           funnel
     * @param numHashFunctions hash个数
     * @param bitOperation     bit操作
     * @param <T>              数据类型
     * @return boolean
     */
    <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, IBitOperation bitOperation);

    /**
     * 校验数据是否在BloomFilter中
     *
     * @param object           数据
     * @param funnel           funnel
     * @param numHashFunctions hash个数
     * @param <T>              数据类型
     * @param bitOperation     bit操作
     * @return boolean
     */
    <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, IBitOperation bitOperation);
}
