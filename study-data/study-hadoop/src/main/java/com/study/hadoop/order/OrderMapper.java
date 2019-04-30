package com.study.hadoop.order;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author dranawhite
 * @version : OrderMapper.java, v 0.1 2019-04-29 17:12 dranawhite Exp $$
 */
public class OrderMapper extends Mapper<LongWritable, Text, Text, OrderBean> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String wordStr = value.toString();
        String[] valueArr = StringUtils.split(wordStr, " ");
        OrderBean order = new OrderBean(valueArr[0], Double.parseDouble(valueArr[2]));
        context.write(new Text((valueArr[0])), order);
    }

}
