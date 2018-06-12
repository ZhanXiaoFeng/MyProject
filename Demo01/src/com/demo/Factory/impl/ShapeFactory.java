package com.demo.Factory.impl;

import com.demo.Factory.AbstractFactory;
import com.demo.dao.Color;
import com.demo.dao.Shape;
import com.demo.dao.impl.Circle;
import com.demo.dao.impl.Rectangle;
import com.demo.dao.impl.Square;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Color getColor(String color) {

		return null;

	}

	@Override
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;

	}

}
