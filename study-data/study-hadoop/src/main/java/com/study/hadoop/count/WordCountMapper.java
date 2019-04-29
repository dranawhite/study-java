package com.study.hadoop.count;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Mapper<LongWritable, Text, Text, IntWritable>
 * 其中:
 *      LongWritable    表示输入Key类型;默认情况下是MR读取一行文本的偏移量；
 *      Text            表示输入Value类型;默认情况下是MR读取一行的数据内容；
 *      Text            表示输出Key类型;用户自定义的类型
 *      IntWritable     表示输出Value类型;用户自定义的类型
 *
 * MR为了方便数据在不同的机器上传输以及序列化，定义了自己的可序列化类型LongWritable对应Long型，Text对应String型；
 *
 * @author dranawhite
 * @version $Id: WordCountMapper.java, v 0.1 2018-08-15 11:30 dranawhite Exp $$
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            context.write(word, one);
        }
    }
}
