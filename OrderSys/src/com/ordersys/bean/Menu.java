package com.ordersys.bean;

/**
 * 封装Menu,即定义Menu类的变量，并给出操作各种变量的方法
 * @author cetc
 *菜单表，用于存储菜品的各种信息，包括：菜品编号、菜名、单价、图片，其中 菜单编号是唯一的，并且不是自增长的
 */
public class Menu {
	private int id;
	private String name;
	private int price;
	private String img;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Menu() {
		super();
	}

	public Menu(String name, int price, String img) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Menu(int id, String name, int price, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", price=" + price
				+ ", img=" + img + "]";
	}

}
