
package com.dranawhite.study.springboot.filter.bloom;

/**
 * @author dranawhite
 * @version : IBitOperation.java, v 0.1 2019-10-25 9:57 dranawhite Exp $$
 */
public interface IBitOperation {

    String BLOOM_FILTER_PREFIX = "drana:test:bloom:";

    /**
     * 存储bitmap
     *
     * @param key    key
     * @param offset offset
     * @return boolean
     */
    boolean setBit(String key, long offset);

    /**
     * 查询bitmap
     *
     * @param key    key
     * @param offset offset
     * @return boolean
     */
    boolean getBit(String key, long offset);
}
