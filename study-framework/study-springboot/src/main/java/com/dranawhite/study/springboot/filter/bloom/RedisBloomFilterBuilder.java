
package com.dranawhite.study.springboot.filter.bloom;

import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author dranawhite
 * @version : BloomFilter.java, v 0.1 2019-10-23 10:50 dranawhite Exp $$
 */
@Component
@SuppressWarnings("UnstableApiUsage")
public class RedisBloomFilterBuilder {

    private ConcurrentMap<String, RedisBloomFilter<String>> bloomFilterMap = new ConcurrentHashMap<>(16);

    @Autowired
    private IBitOperation bitOperation;

    public RedisBloomFilter<String> build(BizTypeEnum bizTypeEnum) {
        if (bloomFilterMap.containsKey(bizTypeEnum.name())) {
            return bloomFilterMap.get(bizTypeEnum.name());
        }
        synchronized (bizTypeEnum) {
            Funnel<CharSequence> charSequenceFunnel = Funnels.stringFunnel(StandardCharsets.UTF_8);
            RedisStorageStrategy storageStrategy = new RedisStorageStrategy(bizTypeEnum);
            RedisBloomFilter<String> bloomFilter = RedisBloomFilter.create(charSequenceFunnel, 2000, 0.98,
                    storageStrategy, bitOperation);
            bloomFilterMap.put(bizTypeEnum.name(), bloomFilter);
            return bloomFilter;
        }
    }

}
