package com.dranawhite.study.springboot.filter.bloom.validator;

import com.dranawhite.common.exception.DranaConflictException;
import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.study.springboot.filter.bloom.BizTypeEnum;
import com.dranawhite.study.springboot.filter.bloom.RedisBloomFilter;
import com.dranawhite.study.springboot.filter.bloom.RedisBloomFilterBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author dranawhite
 * @version : IdempotenceValidationHelper.java, v 0.1 2019-11-05 10:24 dranawhite Exp $$
 */
@Component
public class IdempotenceValidationHelper {

    @Autowired
    private RedisBloomFilterBuilder redisBloomFilterBuilder;

    public void validate(BizTypeEnum bizType, String redisKey, DbValidator dbValidator, String... dbKey) {
        RedisBloomFilter<String> redisBloomFilter = redisBloomFilterBuilder.build(bizType);
        if (redisBloomFilter.mightContain(redisKey)) {
            if (dbValidator.isExist(dbKey)) {
                throw new DranaConflictException("[{}]已存在Name=[{}]", GenericResultCode.CONFLICT,
                        bizType.name(), redisKey);
            }
        }
        redisBloomFilter.put(redisKey);
    }
}
