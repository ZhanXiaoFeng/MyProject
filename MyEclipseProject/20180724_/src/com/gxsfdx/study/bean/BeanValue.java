package com.gxsfdx.study.bean;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

public class BeanValue {
	private String className;
	private Map<String, SimpleEntry<String, String>> propertyValues;

	{
		// 一定要先new，不然会出现空指针异常
		this.propertyValues = new HashMap<>();
	}

	public BeanValue() {
		super();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setPropertyValues(Map<String, SimpleEntry<String, String>> propertyValues) {
		this.propertyValues = propertyValues;
	}

	public Map<String, SimpleEntry<String, String>> getPropertyValues() {
		return propertyValues;
	}

	public void add(String name, String value, String type) {
		this.propertyValues.put(name, new SimpleEntry(value, type));
	}

	@Override
	public String toString() {
		return "BeanValue [className=" + className + ", propertyValues=" + propertyValues + "]";
	}

}
