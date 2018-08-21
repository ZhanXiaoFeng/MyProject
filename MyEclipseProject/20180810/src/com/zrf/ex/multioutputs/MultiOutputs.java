
/**
* @Title: MultiOutputs.java
* @Package com.zrf.ex.multioutputs
* @Description: 计数器的使用
* @author ZRF
* @date 2018年8月10日
* @version V1.0  
*/

package com.zrf.ex.multioutputs;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MultiOutputs {
	// 通过枚举形式定义自定义计数器
	enum MyCounter {
		MALFORORMED, NORMAL
	}

	static class CommaMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

			String[] words = value.toString().split(",");

			for (String word : words) {
				context.write(new Text(word), new LongWritable(1));
			}
			// 对枚举定义的自定义计数器加1
			context.getCounter(MyCounter.MALFORORMED).increment(1);
			// 通过动态设置自定义计数器加1
			context.getCounter("counterGroupa", "countera").increment(1);
		}

	}
}
