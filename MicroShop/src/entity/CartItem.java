package entity;

import java.math.BigDecimal;



/**
 * 购物车模块购物条目类
 * @author tiger
 *
 */
public class CartItem {
	
	private Goods goods;	//商品
	private int count;			//数量
	private double subtotal;	//小计
	
	/*
	 * 计算小计
	 *   >数量*单价
	 */
	public double getSubtotal() {
		/*
		 * 为了不损失精度--使用BigDecimals
		 *   注意：参数必须是String类型
		 */
		BigDecimal bd1 = new BigDecimal(count + "");
		BigDecimal bd2 = new BigDecimal(goods.getPrice2() + "");
		BigDecimal bd3 = bd1.multiply(bd2);
		return bd3.doubleValue();
	}
	
	
	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
