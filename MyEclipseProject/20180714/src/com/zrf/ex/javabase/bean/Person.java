package com.zrf.ex.javabase.bean;

public class Person {
	private String name;
	private double height;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, double height, int age) {
		super();
		this.name = name;
		this.height = height;
		this.age = age;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + ", age=" + age + "]";
	}

}