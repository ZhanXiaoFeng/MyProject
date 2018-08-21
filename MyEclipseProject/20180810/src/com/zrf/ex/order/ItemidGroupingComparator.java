
/**
* @Title: ItemidGroupingComparator.java
* @Package com.zrf.ex.order
* @Description: 用于控制shuffle过程中reduce端对kv对的聚合逻辑
* @author ZRF
* @date 2018年8月10日
* @version V1.0  
*/

package com.zrf.ex.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import com.zrf.ex.order.bean.OrderBean;

public class ItemidGroupingComparator extends WritableComparator {

	protected ItemidGroupingComparator() {
		super(OrderBean.class, true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		OrderBean abean = (OrderBean) a;
		OrderBean bbean = (OrderBean) b;
		// 将item_id相同的bean都视为相同，从而聚合为一组
		return abean.getItemid().compareTo(bbean.getItemid());
	}
}
