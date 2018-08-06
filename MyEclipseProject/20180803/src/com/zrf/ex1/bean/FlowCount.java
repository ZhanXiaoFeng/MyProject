
/**
* @Title: FlowCount.java
* @Package com.zrf.ex1.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月3日
* @version V1.0  
*/

package com.zrf.ex1.bean;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @ClassName: FlowCount
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年8月3日
 */

public class FlowCount {

	static class FlowCountMapper extends Mapper<LongWritable, Text, FlowBean, Text> {
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] fields = line.split("(\\s)+");
			try {
				String phonenbr = fields[0];
				long upflow = Long.parseLong(fields[7]);
				long dflow = Long.parseLong(fields[8]);
				FlowBean flowBean = new FlowBean(upflow, dflow);
				context.write(flowBean, new Text(phonenbr));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class FlowCountReducer extends Reducer<FlowBean, Text, Text, FlowBean> {
		@Override
		protected void reduce(FlowBean bean, Iterable<Text> phonenbr, Context context)
				throws IOException, InterruptedException {
			Text phoneNbr = phonenbr.iterator().next();
			context.write(phoneNbr, bean);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(FlowCount.class);

		job.setMapperClass(FlowCountMapper.class);
		job.setMapOutputKeyClass(FlowBean.class);
		job.setMapOutputValueClass(Text.class);

		job.setReducerClass(FlowCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);

		// job.setInputFormatClass(TextInputFormat.class);

		// FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileInputFormat.setInputPaths(job, new Path("d:/other/flowcount.txt"));

		// FileOutputFormat.setOutputPath(job, new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path("d:/other/flowcount"));

		job.waitForCompletion(true);
	}
}
