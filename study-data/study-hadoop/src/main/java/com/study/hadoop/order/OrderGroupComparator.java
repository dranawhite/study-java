package com.study.hadoop.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @author dranawhite
 * @version : OrderGroupComparator.java, v 0.1 2019-04-29 18:22 dranawhite Exp $$
 */
public class OrderGroupComparator extends WritableComparator {

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return a.compareTo(b);
    }
}
