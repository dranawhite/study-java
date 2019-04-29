package com.study.hadoop.flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dranawhite
 * @version : ProvincePartitioner.java, v 0.1 2019-04-29 16:38 dranawhite Exp $$
 */
public class ProvincePartitioner extends Partitioner<LongWritable, FlowBean> {

    private static final Map<String, Integer> provinceDirectory = new HashMap<>(16);

    static {
        provinceDirectory.put("130", 0);
        provinceDirectory.put("133", 1);
        provinceDirectory.put("180", 2);
        provinceDirectory.put("189", 3);
    }

    @Override
    public int getPartition(LongWritable longWritable, FlowBean flowBean, int numPartitions) {
        long phoneNo = longWritable.get();
        String provincePrefix = String.valueOf(phoneNo).substring(0, 3);
        if (provinceDirectory.containsKey(provincePrefix)) {
            return provinceDirectory.get(provincePrefix);
        }
        return 4;
    }
}
