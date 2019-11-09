
package com.dranawhite.study.springboot.filter.bloom;

import com.google.common.hash.Funnel;

/**
 * <pre>
 *     布隆过滤器根据失败率和插入的数据量大小可以计算出哈希值的个数，以及位图的总大小
 * </pre>
 *
 * @author dranawhite
 * @version : RedisBloomFilter.java, v 0.1 2019-10-23 15:33 dranawhite Exp $$
 */
@SuppressWarnings("UnstableApiUsage")
public class RedisBloomFilter<T> {

    private int numHashFunctions;
    private Funnel<? super T> funnel;
    private BloomStorageStrategy strategy;
    private IBitOperation bitOperation;

    private RedisBloomFilter() {
    }

    static <T> RedisBloomFilter<T> create(Funnel<? super T> funnel, long exceptedInsertions, double fpp,
                                          BloomStorageStrategy strategy, IBitOperation bitOperation) {
        RedisBloomFilter<T> redisBloomFilter = new RedisBloomFilter<>();
        long numBits = redisBloomFilter.optimalNumOfBits(exceptedInsertions, fpp);
        redisBloomFilter.numHashFunctions = redisBloomFilter.optimalNumOfHashFunctions(exceptedInsertions, numBits);
        redisBloomFilter.funnel = funnel;
        redisBloomFilter.strategy = strategy;
        redisBloomFilter.bitOperation = bitOperation;
        return redisBloomFilter;
    }

    public boolean put(T object) {
        return strategy.put(object, funnel, numHashFunctions, bitOperation);
    }

    public boolean mightContain(T object) {
        return strategy.mightContain(object, funnel, numHashFunctions, bitOperation);
    }

    /**
     * 计算位图大小
     *
     * @param exceptedInsertions 插入的数据量
     * @param fpp                失败率
     * @return BitMap Size
     */
    private long optimalNumOfBits(long exceptedInsertions, double fpp) {
        if (fpp == 0) {
            fpp = Double.MIN_VALUE;
        }
        return (long) (-exceptedInsertions * Math.log(fpp) / (Math.log(2) * Math.log(2)));
    }

    /**
     * 计算哈希值个数
     *
     * @param exceptedInsertions 插入的数据量
     * @param numBits            位图的大小
     * @return Hash Size
     */
    private int optimalNumOfHashFunctions(long exceptedInsertions, long numBits) {
        return Math.max(1, (int) Math.round((double) numBits / exceptedInsertions * Math.log(2)));
    }
}
