
/**
* @Title: Student.java
* @Package com.gxsfdx.study.bean
* @Description: TODO(用一句话描述该文件做什么)
* @author ZRF
* @date 2018年7月24日
* @version V1.0  
*/

package com.gxsfdx.study.bean;

/**
 * @ClassName: Student
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ZRF
 * @date 2018年7月24日
 */

public class Student {
	private String name;
	private double height;
	private boolean sex;

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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Student() {
		super();
	}

	public Student(String name, double height, boolean sex) {
		super();
		this.name = name;
		this.height = height;
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", height=" + height + ", sex=" + sex + "]";
	}

}
