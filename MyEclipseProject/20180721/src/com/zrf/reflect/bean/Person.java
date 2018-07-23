package com.zrf.reflect.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>, Cloneable {
	private String name = "zhangsan";
	private double height;
	private List<Integer> list;
	{
		list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4));
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

	public void add(int i) {
		this.list.add(i);
	}

	public void printList() {
		list.forEach(System.out::println);
	}

	public Person() {
		super();
		System.out.println("执行一次");
	}

	public Person(String name, double height) {
		super();
		this.name = name;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person p) {
		/*
		 * this,p 获得一个Comparator,然后调用compare(,)
		 */
		// 名字比较
		Comparator<Person> cr1 = Comparator.comparing(Person::getName);
		// 身高比较
		Comparator<Person> cr2 = Comparator.comparing(Person::getHeight);
		Comparator<Person> com = cr1.thenComparing(cr2);
		return com.compare(this, p);
	}

	/*
	 * int i= this.getName().compareTo(p.getName());
	 * 
	 * if(i==0){ double d=this.getHeight()-p.getHeight();
	 * 
	 * if(d==0){ i=this.getMonth().ordinal()-p.getMonth().ordinal(); }else
	 * if(d>0){ i=1; }else{ i=-1; }
	 * 
	 * 
	 * } return i;
	 */
	@Override // 浅克隆
	public Person clone() {
		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String[] get(int i, double d, String str) {
		return new String[] { "aa", "bb", "cc" };
	}
}
