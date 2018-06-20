package com.jdbc.project.bean;

public class ClothesBean {

	
	//该类作为数据库表的封装类，该类的成员要跟数据库表中的字段保持一致
	
	private int id;
	private String title;
	private String des;
	private String image_url;
	private float price;
	
	public ClothesBean(){}
	
	public ClothesBean(int id, String title, String des, String image_url,
			float price) {
		super();
		this.id = id;
		this.title = title;
		this.des = des;
		this.image_url = image_url;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ClothesBean [id=" + id + ", title=" + title + ", des=" + des
				+ ", image_url=" + image_url + ", price=" + price + "]";
	}
	
	
}
