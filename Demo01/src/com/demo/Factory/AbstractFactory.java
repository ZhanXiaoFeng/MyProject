package com.demo.Factory;

import com.demo.dao.Color;
import com.demo.dao.Shape;

public abstract class AbstractFactory {

	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);

}
