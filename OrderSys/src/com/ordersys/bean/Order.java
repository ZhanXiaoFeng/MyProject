package com.ordersys.bean;

/**
 * 封装Order,即定义Order类的变量，并给出操作各种变量的方法
 * @author cetc
 *订单表，用于存储订单信息，包括：订单号、顾客就餐的桌子号、还有菜品编号
 */
public class Order {
	private int id;
	private int deskId;
	private int foodId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public Order() {
		super();
	}

	public Order(int deskId, int foodId) {
		super();
		this.deskId = deskId;
		this.foodId = foodId;
	}

	public Order(int id, int deskId, int foodId) {
		super();
		this.id = id;
		this.deskId = deskId;
		this.foodId = foodId;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", deskId=" + deskId + ", foodId=" + foodId
				+ "]";
	}

}
