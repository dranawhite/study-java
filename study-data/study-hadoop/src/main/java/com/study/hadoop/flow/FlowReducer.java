package com.study.hadoop.flow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author dranawhite
 * @version : FlowReducer.java, v 0.1 2019-04-29 15:37 dranawhite Exp $$
 */
public class FlowReducer extends Reducer<LongWritable, FlowBean, LongWritable, FlowBean> {

    @Override
    protected void reduce(LongWritable key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
        FlowBean result = new FlowBean();
        for (FlowBean bean : values) {
            long upFlow = result.getUpFlow() + bean.getUpFlow();
            long downFlow = result.getDownFlow() + bean.getDownFlow();

            result.setUpFlow(upFlow);
            result.setDownFlow(downFlow);
        }
        long sumFlow = result.getUpFlow() + result.getDownFlow();
        result.setSumFlow(sumFlow);

        context.write(key, result);
    }
}
