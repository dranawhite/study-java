package com.dranawhite.study.pattern.chain.array;

/**
 * @author dranawhite
 * @version : ManagerFilter.java, v 0.1 2019-08-12 16:40 dranawhite Exp $$
 */
public class ManagerFilter implements Filter {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println("This is Manager!");
        filterChain.doInternalFilter();
    }
}
