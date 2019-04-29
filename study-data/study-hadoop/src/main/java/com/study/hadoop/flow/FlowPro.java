package com.study.hadoop.flow;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version : FlowPro.java, v 0.1 2019-04-29 15:37 dranawhite Exp $$
 */
public class FlowPro {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance();

        job.setJarByClass(FlowPro.class);

        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);
        job.setPartitionerClass(ProvincePartitioner.class);

        // 指定ReduceTask数量，跟Partition分区数保持一致
        job.setNumReduceTasks(5);

        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(FlowBean.class);

        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(FlowBean.class);

        FileInputFormat.addInputPath(job, new Path("study-data/study-hadoop/input/flow"));
        FileOutputFormat.setOutputPath(job, new Path("study-data/study-hadoop/output/flow"));

        boolean result = job.waitForCompletion(true);
        if (!result) {
            System.out.println("Job Failed");
        }
    }
}
