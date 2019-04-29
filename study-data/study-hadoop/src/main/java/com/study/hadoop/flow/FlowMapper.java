package com.study.hadoop.flow;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version : FlowMapper.java, v 0.1 2019-04-29 15:36 dranawhite Exp $$
 */
public class FlowMapper extends Mapper<LongWritable, Text, LongWritable, FlowBean> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String wordValue = value.toString();
        String[] valueArr = StringUtils.split(wordValue, " ");
        FlowBean bean = new FlowBean(Long.parseLong(valueArr[1]), Long.parseLong(valueArr[2]));
        context.write(new LongWritable(Long.parseLong(valueArr[0])), bean);
    }

}
