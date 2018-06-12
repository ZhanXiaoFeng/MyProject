package com.demo.producer;

import com.demo.Factory.AbstractFactory;
import com.demo.Factory.impl.ColorFactory;
import com.demo.Factory.impl.ShapeFactory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}

}
