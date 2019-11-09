
package com.dranawhite.study.springboot.filter.bloom.validator;

/**
 * @author dranawhite
 * @version : DbValidator.java, v 0.1 2019-11-05 10:37 dranawhite Exp $$
 */
@FunctionalInterface
public interface DbValidator {

    /**
     * 校验数据在物理库中是否存在
     *
     * @param key key
     * @return boolean
     */
    boolean isExist(String... key);
}
