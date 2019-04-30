package com.study.hadoop.order;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;


/**
 * @author dranawhite
 * @version : OrderPartitioner.java, v 0.1 2019-04-29 18:11 dranawhite Exp $$
 */
public class OrderPartitioner extends Partitioner<Text, OrderBean> {

    @Override
    public int getPartition(Text key, OrderBean value, int numPartitions) {
        // hashcode有可能是负值，按位与Integer.MAX_VALUE将值转正
        int hash = key.toString().hashCode() & Integer.MAX_VALUE;
        return hash % numPartitions;
    }

}
