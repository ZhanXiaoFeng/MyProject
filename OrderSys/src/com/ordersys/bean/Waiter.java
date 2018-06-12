package com.ordersys.bean;

/**
 * 封装Waiter,即定义Waiter类的变量，并给出操作各种变量的方法
 * @author cetc
 *服务员表，存储服务员的编号、姓名、账户密码，服务员编号是唯一的 ，并且不是自增的 
 */
public class Waiter {
	private int id;
	private String name;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Waiter() {
		super();
	}
	public Waiter(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public Waiter(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Waiter [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}
	
}
