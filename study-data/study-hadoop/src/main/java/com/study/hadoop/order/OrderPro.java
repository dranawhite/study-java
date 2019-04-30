package com.study.hadoop.order;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 *
 * @author dranawhite
 * @version : FlowPro.java, v 0.1 2019-04-29 15:37 dranawhite Exp $$
 */
public class OrderPro {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance();

        job.setJarByClass(OrderPro.class);

        job.setMapperClass(OrderMapper.class);
        job.setReducerClass(OrderReducer.class);
//        job.setGroupingComparatorClass(OrderGroupComparator.class);
        job.setPartitionerClass(OrderPartitioner.class);
        // 指定ReduceTask数量，跟Partition分区数保持一致
        job.setNumReduceTasks(5);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(OrderBean.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path("study-data/study-hadoop/input/order"));
        FileOutputFormat.setOutputPath(job, new Path("study-data/study-hadoop/output/order"));

        boolean result = job.waitForCompletion(true);
        if (!result) {
            System.out.println("Job Failed");
        }
    }
}
