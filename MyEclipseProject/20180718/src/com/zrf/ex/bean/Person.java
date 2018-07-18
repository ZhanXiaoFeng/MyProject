
/**
* @Title: Person.java
* @Package com.zrf.ex.bean
* @Description: 构建Person类
* @author ZRF
* @date 2018年7月18日
* @version V1.0  
*/

package com.zrf.ex.bean;

import com.zrf.ex.meiju.Month;

/**
 * @ClassName: Person
 * @Description: 构建Person类
 * @author ZRF
 * @date 2018年7月18日
 */

public class Person {
	private String name;
	private double height;
	private Month month;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Person() {
		super();
	}

	public Person(String name, double height, Month month) {
		super();
		this.name = name;
		this.height = height;
		this.month = month;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", month=" + month + "]";
	}
}
