package com.dranawhite.study.pattern.chain.array;

/**
 *
 * @author dranawhite
 * @version : MasterFilter.java, v 0.1 2019-08-12 16:42 dranawhite Exp $$
 */
public class MasterFilter implements Filter {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println("This is Master!");
        filterChain.doInternalFilter();
    }
}
