
/**
* @Title: ItemIdPartitioner.java
* @Package com.zrf.ex.order
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年8月10日
* @version V1.0  
*/

package com.zrf.ex.order;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;
import com.zrf.ex.order.bean.OrderBean;

public class ItemIdPartitioner extends Partitioner<OrderBean, NullWritable> {
	@Override
	public int getPartition(OrderBean bean, NullWritable value, int numReduceTasks) {
		// 相同id的订单bean，会发往相同的partition
		// 而且，产生的分区数，是会跟用户设置的reduce task数保持一致
		// (bean.getItemid().hashCode() & Integer.MAX_VALUE)转化为正数
		return (bean.getItemid().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
	}
}
