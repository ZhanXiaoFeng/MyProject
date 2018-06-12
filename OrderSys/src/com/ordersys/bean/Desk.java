package com.ordersys.bean;

/**
 *  封装Desk,即定义Desk类的变量，并给出操作各种变量的方法
 * @author cetc
 * 桌子表，用于存储桌子号，对应桌子号的顾客消费的总价，为该桌子服务的服务员的编号
 */
public class Desk {
	private int id;
	private int waiterId;
	private int totalPrice;
	private boolean pay;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPay() {
		return pay;
	}

	public void setPay(boolean pay) {
		this.pay = pay;
	}

	public Desk(int id, int waiterId, int totalPrice, boolean pay) {
		super();
		this.id = id;
		this.waiterId = waiterId;
		this.totalPrice = totalPrice;
		this.pay = pay;
	}

	public Desk(int waiterId, int totalPrice, boolean pay) {
		super();
		this.waiterId = waiterId;
		this.totalPrice = totalPrice;
		this.pay = pay;
	}

	public Desk() {
		super();

	}

	@Override
	public String toString() {
		return "Desk [id=" + id + ", waiterId=" + waiterId + ", totalPrice="
				+ totalPrice + ", pay=" + pay + "]";
	}

}
