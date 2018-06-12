package com.demo.dao.impl;

import com.demo.dao.Item;
import com.demo.dao.Packing;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new Bottle();
	}

	@Override
	public abstract float price();
}
