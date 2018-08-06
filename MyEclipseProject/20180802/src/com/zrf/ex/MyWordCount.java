
/**
* @Title: MyWordCount.java
* @Package com.zrf.ex
* @Description:  统计单词数
* @author ZRF
* @date 2018年8月2日
* @version V1.0  
*/

package com.zrf.ex;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
//import org.apache.hadoop.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @ClassName: MyWordCount
 * @Description: 统计单词数
 * @author ZRF
 * @date 2018年8月2日
 */

public class MyWordCount {
	public static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			// public final class ActivationDesc
			String[] arr = line.split("\\b");
			/*
			 * for (String s : arr) { context.write(new Text(s), new
			 * IntWritable(1)); }
			 */
			Stream.of(arr).forEach(s -> {
				try {
					context.write(new Text(s), new IntWritable(1));
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			});
		}

		public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
			@Override
			protected void reduce(Text key, Iterable<IntWritable> values,
					Reducer<Text, IntWritable, Text, IntWritable>.Context context)
					throws IOException, InterruptedException {
				// public,1 final,1 class,1 public,1 ActivationDesc,1
				int count = 0;
				for (IntWritable iValue : values) {
					count += iValue.get();
				}
				context.write(key, new IntWritable(count));
			}
		}

		public static void main(String[] args) {
			Configuration config = new Configuration();
			Job job = null;
			try {
				job = Job.getInstance(config);
			} catch (IOException e) {
				e.printStackTrace();
			}

			job.setJarByClass(MyWordCount.class);
			job.setMapperClass(MyMapper.class);
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			job.setReducerClass(MyReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);

			// 判断，用户是否传递参数，。。。
			try {
				/*********************方式一**********************/
				FileInputFormat.setInputPaths(job, "d:/dog.txt");
				/*********************方式二**********************/
				//FileInputFormat.setInputPaths(job, "hdfs://192.168.1.128:8020/wordcount/input/hello.txt");
				/*********************方式三**********************/
				//FileInputFormat.setInputPaths(job, args[0]);
			} catch (IllegalArgumentException | IOException e1) {
				e1.printStackTrace();
			}

			/*********************方式一**********************/
			FileOutputFormat.setOutputPath(job, new Path("d:/dog"));
			/*********************方式二**********************/
			//FileOutputFormat.setOutputPath(job, new Path("hdfs://192.168.1.128:8020/wordcount/output1"));
			/*********************方式三**********************/
			//FileOutputFormat.setOutputPath(job, new Path(args[1]));
			boolean b = false;
			try {
				b = job.waitForCompletion(false);
			} catch (ClassNotFoundException | IOException | InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(b ? 0 : 1);
		}
	}
}
