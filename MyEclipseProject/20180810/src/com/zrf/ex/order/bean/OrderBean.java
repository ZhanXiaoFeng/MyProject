
/**
* @Title: OrderBean.java
* @Package com.zrf.ex.order.bean
* @Description: 订单信息bean，实现hadoop的序列化机制
* @author ZRF
* @date 2018年8月10日
* @version V1.0  
*/

package com.zrf.ex.order.bean;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class OrderBean implements WritableComparable<OrderBean> {
	private Text itemid;
	private DoubleWritable amount;

	public OrderBean() {
	}

	public OrderBean(Text itemid, DoubleWritable amount) {
		set(itemid, amount);
	}

	/************ 链式编程bean.setItemId().setAmount(); ****************/
	public OrderBean setItemId(Text itemid) {
		this.itemid = itemid;
		return this;
	}

	public OrderBean setAmount(DoubleWritable amount) {
		this.amount = amount;
		return this;
	}

	/************* 链式编程bean.setItemId().setAmount(); **************/

	public void set(Text itemid, DoubleWritable amount) {
		this.itemid = itemid;
		this.amount = amount;
	}

	public Text getItemid() {
		return itemid;
	}

	public DoubleWritable getAmount() {
		return amount;
	}

	@Override
	public int compareTo(OrderBean o) {
		int cmp = this.itemid.compareTo(o.getItemid());
		if (cmp == 0) {
			cmp = -this.amount.compareTo(o.getAmount());
		}
		return cmp;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(itemid.toString());
		out.writeDouble(amount.get());
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		String readUTF = in.readUTF();
		double readDouble = in.readDouble();
		this.itemid = new Text(readUTF);
		this.amount = new DoubleWritable(readDouble);
	}

	@Override
	public String toString() {
		return itemid.toString() + "\t" + amount.get();
	}
}
