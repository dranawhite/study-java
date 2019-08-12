package com.dranawhite.study.pattern.chain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite
 * @version : FilterChain.java, v 0.1 2019-08-12 16:37 dranawhite Exp $$
 */
public class FilterChain {

    private List<Filter> filterList = new ArrayList<>();

    private int filterSize = 0;

    public void doInternalFilter() {
        if (filterSize == filterList.size()) {
            return;
        }
        Filter nextFilter = filterList.get(filterSize++);
        nextFilter.doFilter(this);
    }

    public void addFilter(Filter filter) {
        filterList.add(filter);
    }
}
