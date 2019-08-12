package com.dranawhite.study.pattern.chain.array;

/**
 * @author dranawhite
 * @version : Filter.java, v 0.1 2019-08-12 16:37 dranawhite Exp $$
 */
public interface Filter {

    /**
     * 过滤数据
     *
     * @param filterChain 过滤器链
     */
    void doFilter(FilterChain filterChain);
}
