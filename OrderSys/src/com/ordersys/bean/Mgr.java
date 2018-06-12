package com.ordersys.bean;

/**
 * 封装Mgr,即定义Mgr类的变量，并给出操作各种变量的方法
 * @author cetc
 *管理员表，包括管理员编号、姓名及密码
 */
public class Mgr {
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

	public Mgr() {
		super();
	}

	public Mgr(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public Mgr(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Mgr [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

}
