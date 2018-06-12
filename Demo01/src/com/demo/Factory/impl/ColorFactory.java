package com.demo.Factory.impl;

import com.demo.Factory.AbstractFactory;
import com.demo.dao.Color;
import com.demo.dao.Shape;
import com.demo.dao.impl.Blue;
import com.demo.dao.impl.Green;
import com.demo.dao.impl.Red;

public class ColorFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {
		if (color == null) {
			return null;
		}
		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();
		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}
		return null;

	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}

}
