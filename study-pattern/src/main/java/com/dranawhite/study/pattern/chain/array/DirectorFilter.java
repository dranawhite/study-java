package com.dranawhite.study.pattern.chain.array;

/**
 *
 * @author dranawhite
 * @version : DirectorFilter.java, v 0.1 2019-08-12 16:40 dranawhite Exp $$
 */
public class DirectorFilter implements Filter {

    @Override
    public void doFilter(FilterChain filterChain) {
        System.out.println("This is Director!");
        filterChain.doInternalFilter();
    }
}
