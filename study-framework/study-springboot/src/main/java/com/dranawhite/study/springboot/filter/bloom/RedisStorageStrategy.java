
package com.dranawhite.study.springboot.filter.bloom;

import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

/**
 * @author dranawhite
 * @version : RedisStorageStrategy.java, v 0.1 2019-10-23 16:16 dranawhite Exp $$
 */
@SuppressWarnings("UnstableApiUsage")
public class RedisStorageStrategy implements BloomStorageStrategy {

    /**
     * redis中每个key的大小最多只能为512M，bitmap的索引最大为2^32，此处设置bitmap的值为128
     * <pre>
     *     参照guava中用两个long字段保存位图
     * </pre>
     */
    private static final long BIT_SIZE = 128;

    private String bizKey;

    RedisStorageStrategy(BizTypeEnum bizTypeEnum) {
        this.bizKey = IBitOperation.BLOOM_FILTER_PREFIX.concat(bizTypeEnum.name().toLowerCase());
    }

    @Override
    public <T> boolean put(T object, Funnel<? super T> funnel, int numHashFunctions, IBitOperation bitOperation) {
        long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
        int low = (int) hash64;
        int high = (int) (hash64 >>> 32);

        boolean bitsChanged = false;
        long combinedHash = low;
        for (int i = 0; i < numHashFunctions; i++) {
            // Make the combined hash positive and indexable
            long offset = (combinedHash & Long.MAX_VALUE) % BIT_SIZE;
            bitsChanged |= bitOperation.setBit(bizKey, offset);
            combinedHash += high;
        }
        return bitsChanged;
    }

    @Override
    public <T> boolean mightContain(T object, Funnel<? super T> funnel, int numHashFunctions, IBitOperation bitOperation) {
        long hash64 = Hashing.murmur3_128().hashObject(object, funnel).asLong();
        int low = (int) hash64;
        int high = (int) (hash64 >>> 32);

        long combinedHash = low;
        for (int i = 0; i < numHashFunctions; i++) {
            // Make the combined hash positive and indexable
            long offset = (combinedHash & Long.MAX_VALUE) % BIT_SIZE;
            if (!bitOperation.getBit(bizKey, offset)) {
                return false;
            }
            combinedHash += high;
        }
        return true;
    }

}
