package com.zrf.ex.bean.version1;

import org.apache.hadoop.io.LongWritable;

import static org.mockito.Matchers.contains;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Friends {

	public static class MyArray extends ArrayWritable {

		/**
		 * 创建一个新的实例 MyArray.
		 * 
		 * @Title:MyArray
		 * @Description: TODO(这里用一句话描述这个方法的作用)
		 * @param valueClass
		 */

		public MyArray(Class<? extends Writable> valueClass) {
			super(valueClass);
			// TODO Auto-generated constructor stub
		}

		/**
		 * (non-Javadoc)
		 * 
		 * @return
		 * @see java.lang.Object#toString()
		 */

		@Override
		public String toString() {
			Writable[] arr = this.get();
			StringBuffer sb = new StringBuffer();
			for (Writable wr : arr) {
				sb.append(wr.toString());
			}
			return sb.toString();
		}

		/**
		 * (non-Javadoc)
		 * 
		 * @param arg0
		 * @throws IOException
		 * @see org.apache.hadoop.io.ArrayWritable#write(java.io.DataOutput)
		 */

		@Override
		public void write(DataOutput output) throws IOException {
			Writable[] wr = this.get();
			for (Writable w : wr) {
				w.write(output);
			}
		}

	}

	public static class FriendsMapper extends Mapper<LongWritable, Text, Text, Text> {
		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			System.out.println(line);
			System.out.println("00000000000000000000");
			// A:B,C,D,F,E,O
			String[] arr = line.split(":");
			System.out.println(arr.toString());
			String owner = arr[0];
			String friends[] = arr[1].split(",");
			for (String f : friends) {
				System.out.println("22222222222222222222");
				System.out.println(f.toString());
				
				context.write(new Text(f), new Text(owner));
			}
		}
	}

	public static class FriendsReducer extends Reducer<Text, Text, Text, MyArray> {
		@Override
		protected void reduce(Text owner, Iterable<Text> friends, Context context)
				throws IOException, InterruptedException {
			// Text[] values=new Text[]
			List<Text> list = new ArrayList<>();
			for (Text text : list) {
				list.add(text);
			}
			System.out.println(list);
			friends.forEach(list::add);

			int size = list.size();
			Text[] values = new Text[size];// list.toArray(new Text[]{});
			for (int i = 0; i < values.length; i++) {
				values[i] = list.get(i);
				// values.toString();
			}
			System.out.println(values);
			System.out.println("11111111111111111111111");
			// list=null;

			MyArray arr = new MyArray(Text.class);
			arr.set(values);
			System.out.println(arr);
			context.write(owner, arr);
		}
	}

	public static void main(String[] args) {
		Configuration config = new Configuration();
		Job job = null;
		try {
			job = Job.getInstance(config);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		job.setJarByClass(Friends.class);

		job.setMapperClass(FriendsMapper.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);

		job.setReducerClass(FriendsReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(MyArray.class);

		try {
			// FileInputFormat.setInputPaths(job, new Path(args[0]));
			FileInputFormat.setInputPaths(job, new Path("d:/other/friend.txt"));
			// FileInputFormat.setInputPaths(job, args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// FileOutputFormat.setOutputPath(job, new Path(args[1]));
		FileOutputFormat.setOutputPath(job, new Path("d:/other/friend5"));
		boolean b = false;
		try {
			b = job.waitForCompletion(true);
		} catch (ClassNotFoundException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
		// Thread.sleep(20 * 100010);
		System.exit(b ? 0 : 1);

	}
}
