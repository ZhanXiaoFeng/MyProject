
/**
* @Title: SecondarySort.java
* @Package com.zrf.ex.order
* @Description: 利用secondarysort机制输出每种item订单金额最大的记录
* @author ZRF
* @date 2018年8月10日
* @version V1.0  
*/

package com.zrf.ex.order;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import com.zrf.ex.order.bean.OrderBean;

/**
 * Order_0000001,Pdt_01,222.8 Order_0000001,Pdt_05,25.8
 * Order_0000002,Pdt_05,325.8 Order_0000002,Pdt_03,522.8
 * Order_0000002,Pdt_04,122.4 Order_0000003,Pdt_01,222.8
 */
public class SecondarySort {

	static class SecondarySortMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {

		OrderBean bean = new OrderBean();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] fields = StringUtils.split(line, ",");
			//链式编程法
			bean.setItemId(new Text(fields[0])).setAmount(new DoubleWritable(Double.parseDouble(fields[2])));
			//bean.set(new Text(fields[0]), new DoubleWritable(Double.parseDouble(fields[2])));
			context.write(bean, NullWritable.get());
		}
	}

	static class SecondarySortReducer extends Reducer<OrderBean, NullWritable, OrderBean, NullWritable> {

		// 到达reduce时，相同id的所有bean已经被看成一组，且金额最大的那个排在第一位
		// 在设置了groupingcomparator以后，这里收到的kv数据就是： <1001 87.6>,null <1001
		// 76.5>,null ....
		// 此时，reduce方法中的参数key就是上述kv组中的第一个kv的key：<1001 87.6>
		// 要输出同一个item的所有订单中最大金额的那一个，就只要输出这个key
		@Override
		protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context)
				throws IOException, InterruptedException {
			context.write(key, NullWritable.get());
		}
	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(SecondarySort.class);

		job.setMapperClass(SecondarySortMapper.class);
		//job.setMapOutputKeyClass(OrderBean.class);
		//job.setMapOutputValueClass(NullWritable.class);
		
		job.setReducerClass(SecondarySortReducer.class);
		job.setOutputKeyClass(OrderBean.class);
		job.setOutputValueClass(NullWritable.class);

		FileInputFormat.setInputPaths(job, new Path("d:/other/orders.txt"));
		FileOutputFormat.setOutputPath(job, new Path("d:/other/order2"));

		// 在此设置自定义的Groupingcomparator类
		job.setGroupingComparatorClass(ItemidGroupingComparator.class);
		// 在此设置自定义的partitioner类
		job.setPartitionerClass(ItemIdPartitioner.class);
		// 设置Reduce的数量,设置分区，最终变成生成的文件数量
		job.setNumReduceTasks(3);
		job.waitForCompletion(true);
	}
}
