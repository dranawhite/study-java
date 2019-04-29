package com.study.hadoop.count;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 单词计数器
 * <pre>
 *      java study-data/study-hadoop/input/word_count study-data/study-hadoop/output/word_count
 * </pre>
 *
 * @author dranawhite
 * @version $Id: WordCountPro.java, v 0.1 2018-08-15 11:29 dranawhite Exp $$
 */
public class WordCountPro {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance();

        // 设置运行JOB的类
        job.setJarByClass(WordCountPro.class);

        // 设置Mapper类和Reduce类
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // 设置map输出的key/value
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置reduce输出的key/value
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // 设置输入输出的路径
        FileInputFormat.addInputPath(job, new Path("study-data/study-hadoop/input/word_count"));
        FileOutputFormat.setOutputPath(job, new Path("study-data/study-hadoop/output/word_count"));

        // 提交JOB
        boolean result = job.waitForCompletion(true);
        if (!result) {
            System.out.println("Job Failed!");
        }
    }
}
