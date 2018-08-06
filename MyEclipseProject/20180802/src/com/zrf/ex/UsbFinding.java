
/**
* @Title: UsbFinding.java
* @Package com.zrf.ex
* @Description: 设备id查找
* @author ZRF
* @date 2018年8月2日
* @version V1.0  
*/

package com.zrf.ex;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @ClassName: UsbFinding
 * @Description: 设备id查找
 * @author ZRF
 * @date 2018年8月2日
 */

public class UsbFinding {

	private Logger logger;
	// 初始化代码块，只要使用构造函数，首先执行该代码段
	{
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	public static class FindMapper extends Mapper<LongWritable, Text, LongWritable, Text> {

		/**
		 * (non-Javadoc)
		 * 
		 * @param key
		 * @param value
		 * @param context
		 * @throws IOException
		 * @throws InterruptedException
		 * @see org.apache.hadoop.mapreduce.Mapper#map(java.lang.Object,
		 *      java.lang.Object, org.apache.hadoop.mapreduce.Mapper.Context)
		 */

		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, LongWritable, Text>.Context context)
				throws IOException, InterruptedException {
			String lines = value.toString();
			String str = lines.split("\\|")[2];
			if (str.matches(".*([uU][sS][bB]).*((id:0x[A-Fa-f0-9]+).*)|(.*(device 0x[A-Fa-f0-9]+).*)")) {
				context.write(key, value);
			}
		}
	}

	public static class FindReducer extends Reducer<LongWritable, Text, Text, Text> {

		/**
		 * (non-Javadoc)
		 * 
		 * @param arg0
		 * @param arg1
		 * @param arg2
		 * @throws IOException
		 * @throws InterruptedException
		 * @see org.apache.hadoop.mapreduce.Reducer#reduce(java.lang.Object,
		 *      java.lang.Iterable, org.apache.hadoop.mapreduce.Reducer.Context)
		 */

		@Override
		protected void reduce(LongWritable line, Iterable<Text> value,
				Reducer<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
			String s = null;
			Iterator<Text> it = value.iterator();
			Text text = it.next();
			s = text.toString();
			
			String[] arr = s.split("\\|");
			Pattern pattern = Pattern.compile("(.*id:(0x[A-Fa-f0-9]+).*)|(.*device (0x[A-Fa-f0-9]+).*)");
			Matcher matcher = pattern.matcher(arr[2]);
			if (matcher.find()) {
				String group2 = matcher.group(2);
				context.write(new Text(arr[0]), new Text((group2 != null ? group2 : matcher.group(4))));
			}
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
		job.setJarByClass(UsbFinding.class);
		job.setMapperClass(FindMapper.class);
		job.setMapOutputKeyClass(LongWritable.class);
		job.setMapOutputValueClass(Text.class);

		job.setReducerClass(FindReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		// 判断，用户是否传递参数。。。
		try {
			/********************* 方式一 **********************/
			//FileInputFormat.setInputPaths(job, "d:/other/vmware.log");
			/********************* 方式二 **********************/
			FileInputFormat.setInputPaths(job,
			"hdfs://192.168.1.128:8020/wordcount/input/vmware.log");
			/********************* 方式三 **********************/
			// FileInputFormat.setInputPaths(job, args[0]);
		} catch (IllegalArgumentException | IOException e1) {
			e1.printStackTrace();
		}

		/********************* 方式一 **********************/
		//FileOutputFormat.setOutputPath(job, new Path("d:/other/vmware"));
		/********************* 方式二 **********************/
		FileOutputFormat.setOutputPath(job, new
		Path("hdfs://192.168.1.128:8020/wordcount/vmware"));
		/********************* 方式三 **********************/
		// FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean b = false;
		try {
			b = job.waitForCompletion(false);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(b ? 0 : 1);
	}
}
