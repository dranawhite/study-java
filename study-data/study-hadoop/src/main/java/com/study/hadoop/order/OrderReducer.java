package com.study.hadoop.order;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version : OrderReducer.java, v 0.1 2019-04-30 9:37 dranawhite Exp $$
 */
public class OrderReducer extends Reducer<Text, OrderBean, Text, DoubleWritable> {

    @Override
    protected void reduce(Text key, Iterable<OrderBean> values, Context context) throws IOException,
            InterruptedException {
        double max = 0;
        for (OrderBean order : values) {
            if (max < order.getAmount()) {
                max = order.getAmount();
            }
        }
        context.write(key, new DoubleWritable(max));
    }
}
